package org.technoready.jsoncsv;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class to manage configuration settings for the JSON to CSV conversion process.
 * Provides centralized access to configuration properties with default values.
 * DATE: 24 - September - 2025
 *
 * @author Jorge Armando Avila Carrillo | NAOID: 3310
 * @version 1.0
 */
public class ConfigManager {
    private static final String CONFIG_FILE = "src/main/resources/config.properties";
    private static final String DEFAULT_INPUT_PATH = "src/main/resources/input.json";
    private static final String DEFAULT_OUTPUT_PATH = "src/main/resources/output.csv";
    private static final char DEFAULT_DELIMITER = ',';

    private static Properties props = new Properties();

    static {
        // Load properties file on class initialization
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            props.load(fis);
        } catch (IOException e) {
            System.err.println("Warning: Could not load config.properties, using defaults.");
        }
    }

    /**
     * Gets the input file path from configuration or defaults.
     *
     * @param args Command-line arguments (overrides config if provided).
     * @return The input file path.
     */
    public static String getInputPath(String[] args) {
        return args.length > 0 ? args[0] : props.getProperty("input.path", DEFAULT_INPUT_PATH);
    }

    /**
     * Gets the output file path from configuration or defaults.
     *
     * @param args Command-line arguments (overrides config if provided).
     * @return The output file path.
     */
    public static String getOutputPath(String[] args) {
        return args.length > 1 ? args[1] : props.getProperty("output.path", DEFAULT_OUTPUT_PATH);
    }

    /**
     * Gets the delimiter from configuration or defaults.
     *
     * @param args Command-line arguments (overrides config if provided).
     * @return The delimiter character.
     */
    public static char getDelimiter(String[] args) {
        String delimiterStr = args.length > 2 ? args[2] : props.getProperty("delimiter", String.valueOf(DEFAULT_DELIMITER));
        return delimiterStr.length() > 0 ? delimiterStr.charAt(0) : DEFAULT_DELIMITER;
    }
}
