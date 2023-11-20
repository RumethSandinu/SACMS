package com.example.sacms.EventScheduling;

abstract class EventParent
{
    private String clubID;
    private String eventID;
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;

    private boolean validationCheckYear;
    private boolean validationCheckMonth;
    private boolean validationCheckDay;
    public EventParent(){}

    public EventParent(String clubID, String eventID, String year, String month, String day, String hour, String minute) {
        this.clubID = clubID;
        this.eventID = eventID;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }


    abstract void createEvent();
}
