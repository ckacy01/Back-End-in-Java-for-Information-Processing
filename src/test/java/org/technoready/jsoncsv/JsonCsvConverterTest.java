package org.technoready.jsoncsv;

import org.json.JSONArray;
import org.technoready.jsoncsv.Main;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Class to test JSON to CSV convert.
 * DATE: 24 - September - 2025
 *
 *
 * @author Jorge Armando Avila Carrillo
 * @version 1.0
 */


public class JsonCsvConverterTest {
    private final JsonCsvConverter converter = new JsonCsvConverter();

    /**
     * This test Validate if the json file is a valid JSON
     *
     */
    @Test
    public void testConvertValidJson() throws JSONException {
        JSONArray json = new JSONArray("[{\"name\":\"Alice\",\"age\":25},{\"name\":\"Bob\"}]");
        String[][] csv = converter.convert(json);
        assertEquals(2, csv[0].length); // Headers: name, age
        assertEquals("Alice", csv[1][0]);
        assertEquals("25", csv[1][1]);
        assertEquals("", csv[2][1]); // Missing age for Bob
    }

    /**
     * This test Validate if the Json you want to convert its empty
     */
    @Test
    public void testConvertEmptyJson() throws JSONException {
        JSONArray json = new JSONArray();
        String[][] csv = converter.convert(json);
        assertEquals(0, csv.length);
    }

}
