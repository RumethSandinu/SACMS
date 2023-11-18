package com.example.sacms;

import java.sql.*;

public class DBConnect {

    private static final String url = "jdbc:mysql://localhost:3306/sacms";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // CREATE (INSERT) operation for student
    public static void insertStudent(String studentId, String firstName, String lastName, String email, String dateOfBirth, String password) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO student (student_id, student_firstname, student_lastname, student_email, student_dateofbirth, student_password) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, studentId);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, dateOfBirth);
                preparedStatement.setString(6, password);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CREATE (INSERT) operation for advisor
    public static void insertAdvisor(String advisorId, String firstName, String lastName, String email, String dateOfBirth, String password) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO advisor (advisor_id, advisor_firstname, advisor_lastname, advisor_email, advisor_dateofbirth, advisor_password) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, advisorId);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, dateOfBirth);
                preparedStatement.setString(6, password);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ operation for student
    public static void getStudentById(String studentId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM student WHERE student_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, studentId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("Student ID: " + resultSet.getString("student_id"));
                        System.out.println("First Name: " + resultSet.getString("student_firstname"));
                        System.out.println("Last Name: " + resultSet.getString("student_lastname"));
                        System.out.println("Email: " + resultSet.getString("student_email"));
                        System.out.println("Date of Birth: " + resultSet.getString("student_dateofbirth"));
                        // Do not print the password for security reasons
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ operation for advisor
    public static void getAdvisorById(String advisorId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM advisor WHERE advisor_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, advisorId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("Advisor ID: " + resultSet.getString("advisor_id"));
                        System.out.println("First Name: " + resultSet.getString("advisor_firstname"));
                        System.out.println("Last Name: " + resultSet.getString("advisor_lastname"));
                        System.out.println("Email: " + resultSet.getString("advisor_email"));
                        System.out.println("Date of Birth: " + resultSet.getString("advisor_dateofbirth"));
                        // Do not print the password for security reasons
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE operation for student
    public static void updateStudent(String studentId, String newFirstName, String newLastName, String newEmail, String newDateOfBirth, String newPassword) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE student SET student_firstname = ?, student_lastname = ?, student_email = ?, student_dateofbirth = ?, student_password = ? WHERE student_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, newFirstName);
                preparedStatement.setString(2, newLastName);
                preparedStatement.setString(3, newEmail);
                preparedStatement.setString(4, newDateOfBirth);
                preparedStatement.setString(5, newPassword);
                preparedStatement.setString(6, studentId);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE operation for advisor
    public static void updateAdvisor(String advisorId, String newFirstName, String newLastName, String newEmail, String newDateOfBirth, String newPassword) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE advisor SET advisor_firstname = ?, advisor_lastname = ?, advisor_email = ?, advisor_dateofbirth = ?, advisor_password = ? WHERE advisor_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, newFirstName);
                preparedStatement.setString(2, newLastName);
                preparedStatement.setString(3, newEmail);
                preparedStatement.setString(4, newDateOfBirth);
                preparedStatement.setString(5, newPassword);
                preparedStatement.setString(6, advisorId);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE operation for student
    public static void deleteStudent(String studentId) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM student WHERE student_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, studentId);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE operation for advisor
    public static void deleteAdvisor(String advisorId) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM advisor WHERE advisor_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, advisorId);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
            e.printStackTrace();
        }

        System.out.println("Driver class registered");
        Connection sample = null;

        try {
            sample = DriverManager.getConnection(url, username, password);
        }catch (SQLException e2) {
            System.out.println("sql exception found");
            e2.printStackTrace();
            return;
        }

        if (sample != null){
            System.out.println("success");
        }else {
            System.out.println("failed to connect");
        }

        DateOfBirth date = new DateOfBirth(06,04, 2002);
        System.out.println(date.getYear() + "-" + date.getMonth() + "-" + date.getDate());
        try {
            String query = "INSERT INTO student (student_id, student_firstname, student_lastname, student_email, student_dateofbirth, student_password) VALUES (?, ?, ?, ?, ?, ?)";
            assert sample != null;
            try (PreparedStatement preparedStatement = sample.prepareStatement(query)) {
                preparedStatement.setString(1, "ST211");
                preparedStatement.setString(2, "Praveen");
                preparedStatement.setString(3, "Peiris");
                preparedStatement.setString(4, "praveen@abc.com");
                preparedStatement.setString(5, date.getYear() + "-" + date.getMonth() + "-" + date.getDate());
                preparedStatement.setString(6, "heloo");

                preparedStatement.executeUpdate();
            }
            System.out.println("Data Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
