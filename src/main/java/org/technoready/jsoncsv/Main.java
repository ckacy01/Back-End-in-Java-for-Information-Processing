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
 * @version 3.0
 *
 * */

public class Main {


    /**
     * Main for JSON to CSV conversion (only calls other classes).
     */
    public static void main(String[] args) {
        // Initialize dependencies
        JsonReader reader = new JsonReader();
        CsvWriter writer = new CsvWriter(',');
        JsonCsvConverter converter = new JsonCsvConverter();

        // Load configuration
        // TODO: Add the lines to obtain the config properties
        String input = "src/main/resources/input.json";
        String output = "src/main/resources/output.csv";

        // Set delimiter
        // TODO: Add the line to set the demilimiter using CsvWriter

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
