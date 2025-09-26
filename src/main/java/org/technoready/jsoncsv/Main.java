package org.technoready.jsoncsv;

import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;

/**
 * Main class that integrates all the functions of JSON reader, CSV writer and JSON to CSV converter.
 * DATE: 24 - September - 2025
 *
 * @author Jorge Armando Avila Carrillo - NAOID: 3310
 *
 * @version 3.1
 *
 * */

public class Main {


    /**
     * Main for JSON to CSV conversion (only calls other classes).
     */
    public static void main(String[] args) {
        // Initialize dependencies
        JsonReader reader = new JsonReader();
        JsonCsvConverter converter = new JsonCsvConverter();
        ConfigManager configManager = new ConfigManager();

        // Load configuration
        String input = configManager.getInputPath(args);
        String output = configManager.getOutputPath(args);

        // Set delimiter
        char separator = configManager.getDelimiter(args);
        CsvWriter writer = new CsvWriter(separator);

        try {
            JSONArray json = reader.readJsonFile(input);
            String[][] csvData = converter.convert(json);
            writer.writeCsvFile(output, csvData);
            System.out.println("Conversion complete");
        } catch (IOException | JSONException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
