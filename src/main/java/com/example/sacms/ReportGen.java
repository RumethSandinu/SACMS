package com.example.sacms;

import java.sql.*;
import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import org.apache.poi.*;

public class ReportGen {
    private static final String url = "jdbc:mysql://localhost:3306/sacms";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void studentReport() throws SQLException {
        try (Connection newCon = getConnection()){
            String query = "SELECT * FROM students";
            try (PreparedStatement stmt = newCon.prepareStatement(query)){
                ResultSet rs = stmt.executeQuery();
                String studentId = rs.getString("student_id");
                String studentFirstName = rs.getString("first_name");
                String studentLastName = rs.getString("last_name");
                String studentEmail = rs.getString("email");
                DateOfBirth studentDateOfBirth = parseDateOfBirth(rs.getString("dateOfBirth"));
            }catch (SQLException e2) {
                e2.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void excelGenerate() throws SQLException{
        try (Connection newCon = getConnection()){
            String query = "SELECT * FROM students";
            try (PreparedStatement stmt = newCon.prepareStatement(query)){
//                XSSFWorkbook workbook = new XSSFWorkbook(stmt);
            }catch (SQLException e2) {
                e2.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static DateOfBirth parseDateOfBirth(String dateString) {
        String[] dateParts = dateString.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        return new DateOfBirth(day, month, year);
    }

}
