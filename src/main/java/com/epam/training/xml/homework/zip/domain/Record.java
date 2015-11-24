package com.epam.training.xml.homework.zip.domain;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZipRecordType", propOrder = { "zip", "latitude", "longitude", "city", "state", "county", "zipClass" })
public class Record {

	@XmlSchemaType(name = "integer")
	protected int zip;
	protected BigDecimal latitude;
	protected BigDecimal longitude;
	@XmlElement(required = true)
	protected String city;
	@XmlElement(required = true)
	protected String state;
	protected String county;
	@XmlElement(name = "zip-class", required = true)
	@XmlSchemaType(name = "string")
	protected ZipClass zipClass;

	public int getZip() {
		return zip;
	}

	public void setZip(int value) {
		this.zip = value;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal value) {
		this.latitude = value;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal value) {
		this.longitude = value;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String value) {
		this.city = value;
	}

	public String getState() {
		return state;
	}

	public void setState(String value) {
		this.state = value;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String value) {
		this.county = value;
	}

	public ZipClass getZipClass() {
		return zipClass;
	}

	public void setZipClass(ZipClass value) {
		this.zipClass = value;
	}

	@Override
	public String toString() {
		return "Record [latitude=" + latitude + ", longitude=" + longitude + ", city=" + city + ", state=" + state
				+ "]";
	}

	
	
}
