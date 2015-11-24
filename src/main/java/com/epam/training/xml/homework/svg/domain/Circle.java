package com.epam.training.xml.homework.svg.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.xml.homework.svg.Colors;
import com.epam.training.xml.homework.zip.domain.Record;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Circle implements Serializable {

	private static final int CY_BASE_NUMBER = 700;
	private static final int CX_BASE_NUMBER = 1300;
	private static final int MULTIPLICAND = 10;
	private static final int CX_LOWER_LIMIT = 500;
	private static final int CX_UPPER_LIMIT = 0;
	private static final long serialVersionUID = -4152880822487088981L;
	private static final Logger LOGGER = LoggerFactory.getLogger(Circle.class);

	@XmlAttribute(required = true)
	private int r = 1;
	
	@XmlAttribute(required = true)
	private BigDecimal cx;
	
	@XmlAttribute(required = true)
	private BigDecimal cy;
	
	@XmlAttribute(required = true)
	private String fill;
	
	@XmlValue
	private String content = "";

	public Circle() {}
	
	protected Circle(BigDecimal cx, BigDecimal cy, String fill) {
		this.r = 1;
		this.cx = cx;
		this.cy = cy;
		this.fill = fill;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public BigDecimal getCx() {
		return cx;
	}

	public void setCx(BigDecimal cx) {
		this.cx = cx;
	}

	public BigDecimal getCy() {
		return cy;
	}

	public void setCy(BigDecimal cy) {
		this.cy = cy;
	}

	public String getFill() {
		return fill;
	}
	
	public void setFill(String fill) {
		this.fill = fill;
	}

	@Override
	public String toString() {
		return "Circle [r=" + r + ", cx=" + cx + ", cy=" + cy + ", fill=" + fill + "]";
	}

	
	public static Circle fromRecord(Record record) {
		if (record == null || record.getState() == null) {
			LOGGER.info("The record is invalid.");
			return null;
		}
		if (record.getLatitude() == null || record.getLongitude() == null) {
			LOGGER.info("The latitude or the longitude is null: {}", record.toString());
			return null;
		}
		if (record.getState() == null) {
			LOGGER.info("The state is null.");
			return null;
		}
		BigDecimal cx = BigDecimal.valueOf(CX_BASE_NUMBER).add(record.getLongitude().multiply(BigDecimal.valueOf(MULTIPLICAND)));
		BigDecimal cy = BigDecimal.valueOf(CY_BASE_NUMBER).subtract(record.getLatitude().multiply(BigDecimal.valueOf(MULTIPLICAND)));

		if (cx.doubleValue() < CX_UPPER_LIMIT || cy.doubleValue() > CX_LOWER_LIMIT) {
			LOGGER.info("The calculated coordinates are invalid. cx = {}, cy = {}", cx, cy);
			return null;
		}
		
		return new Circle(cx, cy, Colors.getColorForState(record.getState()));
	}

}
