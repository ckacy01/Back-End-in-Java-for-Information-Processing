package org.technoready.jsoncsv;

import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * A class responsible for writing data to CSV files.
 * Utilizes the OpenCSV library to generate CSV files with configurable delimiters.
 *
 * @author Jorge Armando Avila Carrillo | NAOID: 3310
 * @version 1.0
 *
 * */


public class CsvWriter {
    /**
     * Writes a two-dimensional arrat of data to a CSV file at the specified path.
     * Use a default comma delimiter and overwirtes the file if it already exists.
     *
     * @param filePath-String The path  to the CSV file to be created or overwritten
     * @param data-Array a Two dimensional array of strings containing the rows and columns to write
     * @throws IOException If an error occurs while writing the file
     *
     *
     * */
    public void writeCsvFile(String filePath,String[][] data) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(Arrays.asList(data));
        }
    }


}
