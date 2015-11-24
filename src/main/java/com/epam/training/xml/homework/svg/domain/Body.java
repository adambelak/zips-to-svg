package com.epam.training.xml.homework.svg.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Body implements Serializable {

	private static final long serialVersionUID = -5906256497830103777L;

	@XmlElement(required = true)
	private Svg svg;

	public Body() {
	}
	
	public Body(Svg svg) {
		this.svg = svg;
	}

	public Svg getSvg() {
		return svg;
	}

	public void setSvg(Svg svg) {
		this.svg = svg;
	}
	
}
