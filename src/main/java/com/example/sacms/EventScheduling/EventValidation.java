package com.example.sacms.EventScheduling;

public interface EventValidation
{
    String validateClubID(String clubID);
    String validateEventID(String eventID);
    boolean validateDate(String year);
    boolean validateDate(String year, String month);
    boolean validateDate(String year, String month, String day);
    int validateHour(String hour);
    int validateMinute(String minute);
    boolean validateString(String str);
    boolean validateLink(String link);

}
