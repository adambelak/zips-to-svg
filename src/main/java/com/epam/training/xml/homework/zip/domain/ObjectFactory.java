package com.epam.training.xml.homework.zip.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

	private final static QName ZIPS_QNAME = new QName("http://www.epam.com/training/zip", "zips");

	public ObjectFactory() {
	}

	public Zips createZipListType() {
		return new Zips();
	}

	public Record createZipRecordType() {
		return new Record();
	}

	@XmlElementDecl(namespace = "http://www.epam.com/training/zip", name = "zips")
	public JAXBElement<Zips> createZips(Zips value) {
		return new JAXBElement<Zips>(ZIPS_QNAME, Zips.class, null, value);
	}

}
