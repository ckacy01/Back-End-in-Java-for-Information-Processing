package org.technoready.jsoncsv;

import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * A class responsible for writing data to CSV files.
 * Utilizes the OpenCSV library to generate CSV files with configurable delimiters.
 * DATE: 24 - September - 2025
 *
 * @author Jorge Armando Avila Carrillo | NAOID: 3310
 * @version 1.1
 *
 * */


public class CsvWriter {

    private char delimiter;

    /**
     * Constructs a CsvWriter with a specified delimiter.
     *
     * @param delimiter The character to use as delimiter (e.g., ',', '\t').
     */
    public CsvWriter(char delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Sets a new delimiter for CSV writing.
     *
     * @param delimiter The new delimiter character.
     */
    public void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Writes a two-dimensional array of data to a CSV file at the specified path.
     *
     * @param filePath The path to the CSV file.
     * @param data The 2D array of data to write.
     * @throws IOException If an error occurs while writing the file.
     */
    public void writeCsvFile(String filePath, String[][] data) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                delimiter, // Delimiter
                CSVWriter.DEFAULT_QUOTE_CHARACTER, // Quote character
                CSVWriter.DEFAULT_ESCAPE_CHARACTER, // Escape character
                CSVWriter.DEFAULT_LINE_END // Line ending
                )) {
            writer.writeAll(Arrays.asList(data));
        }
    }


}
