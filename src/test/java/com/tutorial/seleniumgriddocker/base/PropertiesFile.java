package com.tutorial.seleniumgriddocker.base;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    private Properties properties;
    private InputStream input = null;
    private final String CONFIG_FILE_NAME = "config.properties";

    public PropertiesFile(){
        properties = new Properties();
        try {
            input = PropertiesFile.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDockerMachineIp(){
        return properties.getProperty("docker-machine-ip");
    }

    public String getSeleniumHubPort(){
        return properties.getProperty("selenium-hub-port");
    }
}
