package org.technoready.jsoncsv;


import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;

/**
 * Main class that integrates all the functions of JSON reader and CSV writer
 * Currently reads a JSON file and converts it to CSV
 *
 * @author Jorge Armando Avila Carrillo - NAOID: 3310
 *
 * @version 2.0
 *
 * */

public class Main {
    private final JsonReader jsonReader;
    private final CsvWriter csvWriter;

    /**
     * Constructs a Main instance with the specified JsonReader and CsvWriter.
     *
     * @param jsonReader The JsonReader instance to read JSON files.
     * @param csvWriter The CsvWriter instance to write CSV files.
     */
    public Main(JsonReader jsonReader, CsvWriter csvWriter) {
        this.jsonReader = jsonReader;
        this.csvWriter = csvWriter;
    }

    /**
     * Entry point of the program. Reads a JSON file and converts it to CSV.
     *
     * @param args Command-line arguments (not used currently).
     */
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        CsvWriter csvWriter = new CsvWriter();
        Main app = new Main(jsonReader, csvWriter);
        app.run();
    }

    /**
     * Executes the JSON to CSV conversion process.
     * Reads the JSON file using readJson and writes the result to CSV using writeCsv.
     */
    public void run() {
        try {
            JSONArray jsonData = readJson("src/main/resources/input.json");
            String[][] csvData = convertJsonToCsvData(jsonData);
            writeCsv("src/main/resources/output.csv", csvData);
            System.out.println("JSON successfully converted to CSV at src/main/resources/output.csv");
        } catch (IOException | JSONException e) {
            System.err.println("Error during conversion: " + e.getMessage());
        }
    }

    /**
     * Reads a JSON file from the specified path and returns its content as a JSONArray.
     *
     * @param filePath The path to the JSON file to read.
     * @return A JSONArray containing the parsed JSON data.
     * @throws IOException If the file cannot be read.
     * @throws JSONException If the JSON format is invalid.
     */
    private JSONArray readJson(String filePath) throws IOException, JSONException {
        return jsonReader.readJsonFile(filePath);
    }

    /**
     * Converts a JSONArray to a two-dimensional array suitable for CSV writing.
     * Assumes the JSON objects have "name", "age", and "city" fields.
     *
     * @param jsonArray The JSONArray to convert.
     * @return A 2D array where the first row is the header and subsequent rows are data.
     * @throws JSONException If a JSON object lacks expected fields.
     */
    private String[][] convertJsonToCsvData(JSONArray jsonArray) throws JSONException {
        String[][] data = new String[jsonArray.length() + 1][3];
        data[0] = new String[]{"name", "age", "city"}; // Header row
        for (int i = 0; i < jsonArray.length(); i++) {
            data[i + 1] = new String[]{
                    jsonArray.getJSONObject(i).getString("name"),
                    String.valueOf(jsonArray.getJSONObject(i).getInt("age")),
                    jsonArray.getJSONObject(i).getString("city")
            };
        }
        return data;
    }

    /**
     * Writes the provided data to a CSV file at the specified path.
     *
     * @param filePath The path to the CSV file to write.
     * @param data The 2D array of data to write to the CSV file.
     * @throws IOException If the file cannot be written.
     */
    private void writeCsv(String filePath, String[][] data) throws IOException {
        csvWriter.writeCsvFile(filePath, data);
    }


}
