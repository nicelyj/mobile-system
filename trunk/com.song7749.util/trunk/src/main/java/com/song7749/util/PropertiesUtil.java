package com.song7749.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties getProperties(String propertyPath) {
		InputStream is = null;
		Properties p = null;
		try {
			is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(propertyPath);
			p = new Properties();
			p.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
}