package com.example.sacms;

import java.util.regex.Pattern;

public class Regex {
    private String email;
    private String name;
    private String password;
    private static final String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String regexName = "^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)";
    private static final String regexName2 = "^[A-Za-z]+$";
    private static final String regexPass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d).{8,}$";

    public static boolean emailPatternMatches(String email) {
        return Pattern.compile(regexEmail)
                .matcher(email)
                .matches();
    }

    public static boolean namePatternMatches(String name) {
        return Pattern.compile(regexName2)
                .matcher(name)
                .matches();
    }

    public static boolean passwordPatternMatches(String password) {
        return Pattern.compile(regexPass)
                .matcher(password)
                .find();
    }

    public static void main(String[] args) {
        if(passwordPatternMatches("Sdsdfs3wq")){
            System.out.println("Success");
        }else {
            System.out.println("nop");
        }
    }

}
