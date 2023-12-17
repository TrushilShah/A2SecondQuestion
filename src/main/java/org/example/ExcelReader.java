package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\trushil.shah\\Downloads\\Accolite Interview Data - Q4 2023 - Grad Program November 2023.xlsx";
        readDataFromExcel(excelFilePath);
    }

    public static void readDataFromExcel(String filePath) {
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath))) {
            // Iterate through sheets, rows, and cells to extract data
            for (Sheet sheet : workbook) {
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        // Extract data and create Java objects
                        String cellValue = cell.getStringCellValue();
                        // Handle the cell value accordingly
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
