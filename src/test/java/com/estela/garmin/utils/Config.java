package com.estela.garmin.utils;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    
    private static Properties properties;

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar config.properties", e);
        }
    }

    public static String get(String chave) {
        return properties.getProperty(chave);
    }

}
