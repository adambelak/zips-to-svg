package com.epam.training.xml.homework.jaxb.svg.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Html implements Serializable {

	private static final long serialVersionUID = -8643218147521814952L;
	
	@XmlElement(required = true)
	private Body body;

	public Html() {
	}
	
	public Html(Body body) {
		this.body = body;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

}
