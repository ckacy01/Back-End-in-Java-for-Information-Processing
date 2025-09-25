package org.technoready.jsoncsv;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

/**
 * Interface converters, allowing extension to other formats
 */
interface  Converter {
    String[][] convert(JSONArray jsonArray) throws JSONException;
}

/**
* Class for mapping JSON data to CSV structure
 * DATE: 24 - September - 2025
 *
 * @author Jorge Armando Avila Carrillo | NAOID: 3310
 * @version 1.0
*/

public class JsonCsvConverter implements Converter {
    /**
     * Maps JSONArray to 2D array for CSV. Dynamically detects unique keys as headers.
     *
     * @param jsonArray JSONArray to convert.
     * @return 2D array with headers and data.
     * @throws JSONException If malformed.
     */
    @Override
    public String[][] convert(JSONArray jsonArray) throws JSONException {
        System.out.println("Converting JSON array to CSV at src/main/resources/output.csv");
        if (jsonArray.isEmpty()) return new String[0][0];

        Set<String> allKeys = new HashSet<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            allKeys.addAll(jsonArray.getJSONObject(i).keySet());
        }
        String[] headers = allKeys.toArray(new String[0]);

        List<String[]> dataList = new ArrayList<>();
        dataList.add(headers);
        System.out.println("Headers: " + Arrays.toString(headers));

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String[] row = new String[headers.length];
            for (int j = 0; j < headers.length; j++) {
                row[j] = object.has(headers[j]) ? object.get(headers[j]).toString() : "";

            }
            dataList.add(row);
        }
        return dataList.toArray(new String[0][0]);
    }
}
