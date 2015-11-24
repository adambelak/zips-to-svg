package com.epam.training.xml.homework.svg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Colors {
	
	private static final int CACHE_INIT_SIZE = 50;
	private static final Random RANDOM = new Random();
	private static final String[] LETTERS = "0123456789ABCDEF".split("");
	private static final Map<String, String> COLOR_CACHE = new HashMap<>(CACHE_INIT_SIZE);
	private static final Logger LOGGER = LoggerFactory.getLogger(Colors.class);
	
	private Colors() {}
	
	public static String getColorForState(String key) {
		if (!COLOR_CACHE.containsKey(key)) {
			COLOR_CACHE.put(key, getUniqueColor());
			LOGGER.debug("Generated color for {}: {}", key, COLOR_CACHE.get(key));
		}
		return COLOR_CACHE.get(key);
	}
	
	private static String getUniqueColor() {
		String color = null;
		do {
			color = getColor();
		} while (COLOR_CACHE.containsValue(color));
		return color;
	}
	
	private static String getColor() {
		StringBuilder builder = new StringBuilder("#");
		for (int i = 0; i < 6; i++) {
			builder.append(LETTERS[randomIndex()]);
		}
		return builder.toString();
	}
	
	private static int randomIndex() {
		return RANDOM.nextInt(LETTERS.length);
	}


}
