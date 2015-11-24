package com.epam.training.xml.homework.zip.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ZipClassType")
@XmlEnum
public enum ZipClass {

	UNIQUE("UNIQUE"), 
	STANDARD("STANDARD"), 
	MILITARY("MILITARY"), 
	@XmlEnumValue("PO BOX ONLY") 
	PO_BOX_ONLY("PO BOX ONLY");
	
	private final String value;

	ZipClass(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static ZipClass fromValue(String v) {
		for (ZipClass c : ZipClass.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
