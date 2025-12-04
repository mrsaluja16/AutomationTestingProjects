package org.basic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileProperties {
	
	private static final String filePath = ".//src//main//config//config.properties";
	
	public static String getPropertyValue(String propertyName) throws Exception{
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Properties prop= new Properties();
		prop.load(fis);
		return prop.getProperty(propertyName);
	}

}
