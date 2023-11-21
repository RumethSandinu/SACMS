package com.example.sacms.EventScheduling;

import java.util.regex.Matcher;

public interface EventValidation
{
    boolean validateClubID(String clubID);
    boolean validateEventID(String eventID);
    boolean validateDate(String year);
    boolean validateDate(String year, String month);
    boolean validateDate(String year, String month, String day);
    boolean validateHour(String hour);
    boolean validateMinute(String minute);
    boolean validateString(String str);
    boolean validateLink(String link);

}
