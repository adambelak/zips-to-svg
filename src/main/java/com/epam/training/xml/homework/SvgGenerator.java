package com.epam.training.xml.homework;

import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.epam.training.xml.homework.svg.domain.Body;
import com.epam.training.xml.homework.svg.domain.Circle;
import com.epam.training.xml.homework.svg.domain.Html;
import com.epam.training.xml.homework.svg.domain.Svg;
import com.epam.training.xml.homework.zip.domain.ObjectFactory;
import com.epam.training.xml.homework.zip.domain.Zips;


public class SvgGenerator {

	private static final File OUTPUT_FILE = new File("zip.html");
	private static final Logger LOGGER = LoggerFactory.getLogger(SvgGenerator.class);
	
	public void run() {
		Optional<Zips> zips = unmarshalling();
		if (zips.isPresent()) {
			marshalling(convertZipsToHtml(zips.get()));
		} else {
			LOGGER.debug("Zips is empty.");
		}
	}
	
	private Optional<Zips> unmarshalling() {
		LOGGER.trace("Start unmarshalling...");
		JAXBContext context;
		InputStream inputStream = getClass().getResourceAsStream("/zip-full.xml");
		InputSource inputSource = new InputSource(inputStream);
		try {
			context = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			SAXSource source = new SAXSource(inputSource);
			Zips zips = unmarshaller.unmarshal(source, Zips.class).getValue();
			return Optional.of(zips);
		} catch (JAXBException e) {
			LOGGER.warn("Unmarshalling failed: {}", e.getMessage());
		}
		return Optional.empty();
	}
	
	private Html convertZipsToHtml(Zips zips) {
		LOGGER.trace("Start converting zips to html...");
		List<Circle> circles = zips.getRecord()
				.stream()
				.map(record -> Circle.fromRecord(record))
				.collect(Collectors.toList());
		circles.removeAll(Collections.singleton(null));
		Svg svg = new Svg(1700, 800, circles);
		Body body = new Body(svg);
		return new Html(body);
	}
	
	private void marshalling(Html html) {
		marshalling(html, OUTPUT_FILE);
	}
	
	private void marshalling(Html html, File output) {
		LOGGER.trace("Start marshalling...");
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Body.class, Circle.class, Html.class, Svg.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(html, output);
		} catch (JAXBException e) {
			LOGGER.warn("Marshalling failed: {}", e.getMessage());
		}
	}
	
}
