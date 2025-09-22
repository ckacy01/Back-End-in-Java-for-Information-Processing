package org.technoready.jsoncsv;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class for read and parse JSON Files.
 * DATE: 21 - September - 2025
 *
* @author Jorge Armando Avila Carrillo | NAOID: 3310
*
*
* @version 1.0
* */

public class JsonReader {


    /**
     * JSONArray function
     * Description: Reads a JSON File and parse it into JSONArray
     *
     * @param filePath [String] Route of the JSON file.
     * @return A JSONArray with all the data parsed.
     * @throws IOException File not found or the file can't be read.
     * @throws JSONException If the content of the file isn't a valid JSON.
     *
     */

    public JSONArray readJsonFile(String filePath) throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONArray(content);
    }



}
