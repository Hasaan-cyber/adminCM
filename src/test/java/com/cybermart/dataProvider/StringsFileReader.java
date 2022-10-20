package com.cybermart.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class StringsFileReader {

	private Properties properties;
	private BufferedReader reader;
	private final String stringsFilePath = "localization//Strings.properties";

	public StringsFileReader() {

		try {

			reader = new BufferedReader(new FileReader(stringsFilePath));
			properties = new Properties();

			try {

				properties.load(reader);
				reader.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + stringsFilePath);

		}

	}

	public String getString(String string) {

		String requiredString = properties.getProperty(string);

		if (requiredString != null) {

			return requiredString;

		} else {

			throw new RuntimeException("The required string is not specified in the Strings.properties file.");

		}
	}

}
