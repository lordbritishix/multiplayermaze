package com.quitevis.multiplayermaze.tests;

import io.netty.channel.ChannelHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBase {
    private static Properties properties = readProperties();
    
    private static String getPropertiesFilename() {
        return System.getProperty("CONFIG") + "/test.properties";
    }
    
    private static Properties readProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(getPropertiesFilename())) {
            properties.load(fis);
        } catch (IOException e) {
            log.error("Unable to read properties file", e);
        }
        
        return properties;
    }
    
    public String getHost() {
        return properties.getProperty("server.hostname");
    }
    
    public int getPort() {
        return Integer.parseInt(properties.getProperty("server.port"));
    }
    
    public ClientTestResource getClient(ChannelHandler handler) {
        return new ClientTestResource(getHost(), getPort(), handler);
    }
    
}
