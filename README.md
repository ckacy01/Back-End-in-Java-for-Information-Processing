# Java JSON and CSV Processor

![Java](https://img.shields.io/badge/Java-17-blue) ![Maven](https://img.shields.io/badge/Maven-3.9.6-orange) ![License](https://img.shields.io/badge/License-MIT-green)

## Overview
Java app for JSON to CSV conversion (Sprint 3). Uses `org.json` and `OpenCSV`.

## Features
- Reads JSON dynamically (`JsonReader`).
- Maps JSON to CSV (`JsonCsvConverter`).
- Writes CSV with custom delimiters (`CsvWriter`).
- Configurable via `config.properties` or args.