package com.demo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.demo.constants.GlobalConstants;

import Enums.PropertyFileAttributes;

public class ReadPropertyFile {

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();

	private ReadPropertyFile() {
	}

	static {
		try {
			FileInputStream propertyFile = new FileInputStream(GlobalConstants.getPropertyFilePath());
			property.load(propertyFile);
			for (Map.Entry<Object, Object> entrySet : property.entrySet()) {
				String key = String.valueOf(entrySet.getKey()).trim();
				String value = String.valueOf(entrySet.getValue()).trim();
				CONFIGMAP.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(PropertyFileAttributes key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " not found. Please check Config.properties file");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
