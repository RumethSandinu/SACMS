package com.example.sacms;

import java.sql.*;

public class DBConnect {

    private static final String url = "jdbc:mysql://localhost:3306/sacms";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void insertStudent(String studentId, String firstName, String lastName, String email, DateOfBirth dateOfBirth, String password) {
        if (!isStudentExists(studentId)) {
            try (Connection connection = getConnection()) {
                String query = "INSERT INTO student (student_id, student_firstname, student_lastname, student_email, student_dateofbirth, student_password) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, studentId);
                    preparedStatement.setString(2, firstName);
                    preparedStatement.setString(3, lastName);
                    preparedStatement.setString(4, email);
                    preparedStatement.setString(5, dateOfBirth.toString());
                    preparedStatement.setString(6, password);

                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Student with ID " + studentId + " already exists.");
        }
    }

    public static void insertAdvisor(String advisorId, String firstName, String lastName, String email, DateOfBirth dateOfBirth, String password) {
        if (!isAdvisorExists(advisorId)) {
            try (Connection connection = getConnection()) {
                String query = "INSERT INTO advisor (advisor_id, advisor_firstname, advisor_lastname, advisor_email, advisor_dateofbirth, advisor_password) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, advisorId);
                    preparedStatement.setString(2, firstName);
                    preparedStatement.setString(3, lastName);
                    preparedStatement.setString(4, email);
                    preparedStatement.setString(5, dateOfBirth.toString());
                    preparedStatement.setString(6, password);

                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Advisor with ID " + advisorId + " already exists.");
        }
    }

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
//    public static void updateStudent(String studentId, String newFirstName, String newLastName, String newEmail, String newDateOfBirth, String newPassword) {
//        try (Connection connection = getConnection()) {
//            String query = "UPDATE student SET student_firstname = ?, student_lastname = ?, student_email = ?, student_dateofbirth = ?, student_password = ? WHERE student_id = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, newFirstName);
//                preparedStatement.setString(2, newLastName);
//                preparedStatement.setString(3, newEmail);
//                preparedStatement.setString(4, newDateOfBirth);
//                preparedStatement.setString(5, newPassword);
//                preparedStatement.setString(6, studentId);
//
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void updateStudent(String studentId, String newFirstName, String newLastName, String newEmail, DateOfBirth newDateOfBirth, String newPassword) {
//        try (Connection connection = getConnection()) {
//            String query = "UPDATE student SET student_firstname = ?, student_lastname = ?, student_email = ?, student_dateofbirth = ?, student_password = ? WHERE student_id = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, newFirstName);
//                preparedStatement.setString(2, newLastName);
//                preparedStatement.setString(3, newEmail);
//                preparedStatement.setString(4, newDateOfBirth.toString());
//                preparedStatement.setString(5, newPassword);
//                preparedStatement.setString(6, studentId);
//
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void updateAdvisor(String advisorId, String newFirstName, String newLastName, String newEmail, String newDateOfBirth, String newPassword) {
//        try (Connection connection = getConnection()) {
//            String query = "UPDATE advisor SET advisor_firstname = ?, advisor_lastname = ?, advisor_email = ?, advisor_dateofbirth = ?, advisor_password = ? WHERE advisor_id = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, newFirstName);
//                preparedStatement.setString(2, newLastName);
//                preparedStatement.setString(3, newEmail);
//                preparedStatement.setString(4, newDateOfBirth);
//                preparedStatement.setString(5, newPassword);
//                preparedStatement.setString(6, advisorId);
//
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

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

    private static boolean isStudentExists(String studentId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT COUNT(*) FROM student WHERE student_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, studentId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1) > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isAdvisorExists(String advisorId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT COUNT(*) FROM advisor WHERE advisor_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, advisorId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1) > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

        DateOfBirth AdDate = new DateOfBirth(4,9,2002);
        DateOfBirth StDate = new DateOfBirth(6, 3, 2002);

//        insertStudent("ST553", "Mr", "Shutdown", "horopathaan@shutdown.com", StDate, "dhammissaragamma");

        insertStudent("ST202", "Mr", "Shutdown", "horopathaan@shutdown.com", StDate, "dhammissaragamma");
    }
}
