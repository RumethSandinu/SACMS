package com.example.sacms;

public class Student implements Member{
    private String studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private DateOfBirth dateOfBirth;
    private String studentPassword;

    public Student() {
    }

    public Student(String studentId, String studentFirstName, String studentLastName, String studentEmail, DateOfBirth dateOfBirth, String studentPassword) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentEmail = studentEmail;
        this.dateOfBirth = dateOfBirth;
        this.studentPassword = studentPassword;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
