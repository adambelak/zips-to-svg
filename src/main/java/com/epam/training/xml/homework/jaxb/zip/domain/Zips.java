package com.epam.training.xml.homework.jaxb.zip.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZipListType", propOrder = { "record" })
public class Zips {

	@XmlElement(required = true)
	protected List<Record> record;

	public List<Record> getRecord() {
		if (record == null) {
			record = new ArrayList<Record>();
		}
		return this.record;
	}

}
