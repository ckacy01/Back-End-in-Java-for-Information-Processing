package org.technoready.jsoncsv;

import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;

/**
 * Main class that integrates all the functions of JSON reader and CSV writer
 * Currently only reads a JSON file and shows its content in console
 *
 * @author Jorge Armando Avila Carrillo - NAOID: 3310
 *
 * @version 1.0
 *
 * */

public class Main {
    /**
     * Entry point of the program. Reads a JSON file from a resource and shows its
     * content in console. In future versions a CSV writer will be implemented
     *
     * @params args Arguments of CLI
     */
    public static void main(String[] args) {
        JsonReader reader = new JsonReader();
        String inputFile = "src/main/resources/input.json";

        try{
            JSONArray jsonArray = reader.readJsonFile(inputFile);
            System.out.println("JSON content: ");
            System.out.println(jsonArray.toString(2));
        }catch(IOException e){
            System.err.println("Error while reading file: " + e.getMessage());
        }catch(JSONException e){
            System.out.println("Error in JSON format: " + e.getMessage());
        }
    }

}
