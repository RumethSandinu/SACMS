package com.example.sacms;

import java.util.regex.Pattern;

public class Regex {
    private String email;
    private final String regexEmail = "^(.+)@(\\S+)$";

    public static boolean patternMatches(String email, String regexEmail) {
        return Pattern.compile(regexEmail)
                .matcher(email)
                .matches();
    }
}
