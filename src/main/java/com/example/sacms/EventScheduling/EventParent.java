package com.example.sacms.EventScheduling;

abstract class EventParent {
    protected String clubID;
    protected String eventID;
    protected String year;
    protected String month;
    protected String day;
    protected String hour;
    protected String minute;

    public EventParent() {
    }

    public EventParent(String clubID, String eventID, String year, String month, String day,
                       String hour, String minute) {
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