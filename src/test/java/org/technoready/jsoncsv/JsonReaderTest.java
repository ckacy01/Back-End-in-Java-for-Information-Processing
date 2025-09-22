package org.technoready.jsoncsv;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Class test for JsonReader.
 * Validates a valid JSON file, if the file exits and Invalid format.
 * DATE: 21 - September - 2025
 *
 * @author Jorge Armando Avila Carrillo | NAOID: 3310
 *
 *
 *
 * @version 1.0
 * */

public class JsonReaderTest {
    private JsonReader jsonReader;

    /**
     * Initialize an jsonReader instance
     * */

    @BeforeEach
    public void setup() {
        jsonReader = new JsonReader();
    }

    /**
    * Test the read of a valid JSON file
    * */
    @Test
    public void testReadJsonFileValid(){
        String jsonFile = "src/main/resources/input.json";
        try{
            JSONArray result = jsonReader.readJsonFile(jsonFile);
            assertNotNull(result, "The JSONArray can't be null");
            assertFalse(result.isEmpty(), "The JSONArray can't be empty");
        }catch(IOException | JSONException e){
            fail("This exception must not be thrown");
        }
    }

    /**
    * Tests the exception for a JSON file not found
    * */
    @Test
    public void testReadJsonFileNotFound() {
        String filePath = "src/main/resources/file_that_does_not_exist_123.json";
        assertThrows(IOException.class,
                () -> jsonReader.readJsonFile(filePath),
                "Must throw IOException for file Not Found");
    }

    /**
    * Tests the exception for an invalid JSON file
    * */
    @Test
    public void testReadJsonFileInvalidFormat(){
        String jsonFile = "src/main/resources/invalid.json";
        assertThrows(JSONException.class, () -> jsonReader.readJsonFile(jsonFile),  "Must throw JSONException for invalid format");
    }


}
