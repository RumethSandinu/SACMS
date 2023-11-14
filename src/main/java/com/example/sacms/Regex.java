package com.example.sacms;

import java.util.regex.Pattern;

public class Regex {
    private String email;
    private String name;
    private static final String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String regexName = "^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)";

    public static boolean emailPatternMatches(String email) {
        return Pattern.compile(regexEmail)
                .matcher(email)
                .matches();
    }

    public static boolean namePatternMatches(String name) {
        return Pattern.compile(regexName)
                .matcher(name)
                .matches();
    }

    public static void main(String[] args) {
        if (namePatternMatches("test ttt")){
            System.out.println("ok");
        }else{
            System.out.println("no");
        }

    }

}
