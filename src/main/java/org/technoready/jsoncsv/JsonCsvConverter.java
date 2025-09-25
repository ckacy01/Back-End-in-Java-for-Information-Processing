package org.technoready.jsoncsv;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonCsvConverter {

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

}
