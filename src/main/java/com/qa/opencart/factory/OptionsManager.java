package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private EdgeOptions eo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
    public ChromeOptions ChromeOptions() {
    	if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
    	if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");
    	return co;
    }
    public EdgeOptions EdgeOptions() {
    	if(Boolean.parseBoolean(prop.getProperty("headless").trim())) eo.addArguments("headless");
    	if(Boolean.parseBoolean(prop.getProperty("--inprivate").trim())) eo.addArguments("--inprivate");
    	return eo;
    }
}
