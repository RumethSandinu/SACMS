package com.example.sacms;

import java.sql.*;
import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReportGen {
    private static final String url = "jdbc:mysql://localhost:3306/sacms";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static boolean excelGenerateStudents() throws SQLException {
        try (Connection newCon = getConnection()) {
            String query = "SELECT * FROM student";
            try (PreparedStatement stmt = newCon.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();

                // Create a new workbook
                XSSFWorkbook workbook = new XSSFWorkbook();

                // Create a sheet in the workbook
                XSSFSheet sheet = workbook.createSheet("Student Data");

                // Create header row
                XSSFRow headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Student ID");
                headerRow.createCell(1).setCellValue("First Name");
                headerRow.createCell(2).setCellValue("Last Name");
                headerRow.createCell(3).setCellValue("Email");
                headerRow.createCell(4).setCellValue("Date of Birth");

                int rowNum = 1;
                while (rs.next()) {
                    // Iterate over the result set and add data to the sheet
                    XSSFRow row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(rs.getString("student_id"));
                    row.createCell(1).setCellValue(rs.getString("first_name"));
                    row.createCell(2).setCellValue(rs.getString("last_name"));
                    row.createCell(3).setCellValue(rs.getString("email"));
                    DateOfBirth studentDateOfBirth = parseDateOfBirth(rs.getString("dateOfBirth"));
                    row.createCell(4).setCellValue(studentDateOfBirth.toString());
                }

                // Save the workbook to a file or perform other operations

                // For example, you can save it to a file
                try (FileOutputStream fileOut = new FileOutputStream("students_registered.xlsx")) {
                    workbook.write(fileOut);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean excelGenerateAdvisors() throws SQLException {
        try (Connection newCon = getConnection()) {
            String query = "SELECT * FROM advisor";
            try (PreparedStatement stmt = newCon.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();

                // Create a new workbook
                XSSFWorkbook workbook = new XSSFWorkbook();

                // Create a sheet in the workbook
                XSSFSheet sheet = workbook.createSheet("Advisor Data");

                // Create header row
                XSSFRow headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Advisor ID");
                headerRow.createCell(1).setCellValue("First Name");
                headerRow.createCell(2).setCellValue("Last Name");
                headerRow.createCell(3).setCellValue("Email");
                headerRow.createCell(4).setCellValue("Date of Birth");

                int rowNum = 1;
                while (rs.next()) {
                    // Iterate over the result set and add data to the sheet
                    XSSFRow row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(rs.getString("advisor_id"));
                    row.createCell(1).setCellValue(rs.getString("first_name"));
                    row.createCell(2).setCellValue(rs.getString("last_name"));
                    row.createCell(3).setCellValue(rs.getString("email"));
                    DateOfBirth studentDateOfBirth = parseDateOfBirth(rs.getString("dateOfBirth"));
                    row.createCell(4).setCellValue(studentDateOfBirth.toString());
                }

                // Save the workbook to a file or perform other operations

                // For example, you can save it to a file
                try (FileOutputStream fileOut = new FileOutputStream("advisors_registered.xlsx")) {
                    workbook.write(fileOut);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static DateOfBirth parseDateOfBirth(String dateString) {
        String[] dateParts = dateString.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        return new DateOfBirth(day, month, year);
    }

//    public static void main(String[] args) {
//        try {
//            excelGenerateStudents();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
