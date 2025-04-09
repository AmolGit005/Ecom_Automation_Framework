package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager
{
    private static final Properties props = new Properties();

    static {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config properties");
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
