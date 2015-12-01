package com.epam.training.xml.homework.jaxb.svg.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "svg")
@XmlAccessorType(XmlAccessType.FIELD)
public class Svg implements Serializable {

	private static final long serialVersionUID = 7314758261715481187L;
	
	@XmlAttribute(required = true)
	private int width;
	@XmlAttribute(required = true)
	private int height;
	@XmlElement(required = true, name = "circle")
	private List<Circle> circles;

	public Svg() {
		this(1700, 800, new ArrayList<>());
	}
	
	public Svg(int width, int height, List<Circle> circles) {
		this.width = width;
		this.height = height;
		this.circles = circles;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public List<Circle> getCircles() {
		return circles;
	}

	public void setCircle(List<Circle> circles) {
		this.circles = circles;
	}

	public void addCircle(Circle circle) {
		if (circles == null) {
			circles = new ArrayList<>();
		}
		circles.add(circle);
	}
	
}
