package org.technoready.jsoncsv;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A test class for the CsvWriter class.
 * Validates the functionality of writing CSV files,
 * including error handling and correct file creation.
 * DATE: 21 - September - 2025
 *
 * @author Jorge Armando Avila Carrillo | NAOID: 3310
 * @version 1.0
 */
public class CsvWriterTest {
    private CsvWriter csvWriter;
    private String tempFilePath;

    /**
     * Initializes a CsvWriter instance and generates a unique temporary file path,
     * for testing before each test case.
     */
    @BeforeEach
    public void setUp() {
        csvWriter = new CsvWriter(',');
        tempFilePath = "src/main/resources/test.csv";
    }

    /**
     * Removes the temporary file created during testing after each test case.
     */
    @AfterEach
    public void tearDown() {
        try {
            Files.deleteIfExists(Paths.get(tempFilePath));
        } catch (IOException e) {
            System.err.println("Error deleting temporary file: " + e.getMessage());
        }
    }

    /**
     * Tests writing a valid CSV file with sample data.
     * Verifies that the file is created and contains the expected content,
     * accounting for OpenCSV's default quoting behavior.
     *
     * @throws IOException If an error occurs while reading the test file.
     */
    @Test
    public void testWriteCsvFileValid() throws IOException {
        String[][] data = {
                {"name", "age", "city"},
                {"Alice", "25", "New York"},
                {"Bob", "30", "San Francisco"}
        };
        csvWriter.writeCsvFile(tempFilePath, data);

        // Verify file exists and is not empty
        assertTrue(Files.exists(Paths.get(tempFilePath)), "The CSV file should exist");
        assertTrue(Files.size(Paths.get(tempFilePath)) > 0, "The CSV file should not be empty");

        String content = new String(Files.readAllBytes(Paths.get(tempFilePath)));
        System.out.println("Generated CSV content: " + content.replace("\n", "\\n")); // Debug print

        // Adjust assertions to match OpenCSV's quoted format
        assertTrue(content.contains("\"name\",\"age\",\"city\""), "Header row not found");
        assertTrue(content.contains("\"Alice\",\"25\",\"New York\""), "First data row not found");
        assertTrue(content.contains("\"Bob\",\"30\",\"San Francisco\""), "Second data row not found");
    }

    /**
     * Tests that an IOException is thrown when writing to a path with no write permissions.
     */
    @Test
    public void testWriteCsvFileNoPermission() {
        // Use a protected path based on OS
        String invalidPath = isWindows() ? "C:\\Windows\\System32\\test_output.csv" : "/root/test_output.csv";
        assertThrows(IOException.class, () -> csvWriter.writeCsvFile(invalidPath, new String[][]{{"test"}}),
                "Should throw IOException due to lack of permissions");
    }

    /**
     * Helper method to detect if the operating system is Windows
     *
     * @return true if the OS is Windows, false otherwise
     */
    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

}