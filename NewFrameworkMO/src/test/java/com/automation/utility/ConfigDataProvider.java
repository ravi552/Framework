package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	public ConfigDataProvider() {
		File file = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("not able to load config file >>"+e.getMessage());
		}

	}

	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	public String getStagingUrl() {
		return prop.getProperty("qaUrl");
	}

}
