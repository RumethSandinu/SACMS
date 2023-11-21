package com.example.sacms.EventScheduling;

public class Activity extends EventParent
{
    private String type;
    private String link;

    public Activity(){}

    public Activity(String clubID, String eventID, String year, String month, String day, String hour, String minute,
                    String type, String link)
    {
        super(clubID, eventID, year, month, day, hour, minute);
        this.type = type;
        this.link = link;
        createEvent();
    }

    @Override
    void createEvent()
    {
        EventValidator validate = new EventValidator();
        Thread thread1 = new Thread(() -> validate.validateClubID(clubID));
        Thread thread2 = new Thread(() -> validate.validateEventID(eventID));
        Thread thread3 = new Thread(() -> validate.validateDate(year));
        Thread thread4 = new Thread(() -> validate.validateDate(year, month));
        Thread thread5 = new Thread(() -> validate.validateDate(year, month, day));
        Thread thread6 = new Thread(() -> validate.validateHour(hour));
        Thread thread7 = new Thread(() -> validate.validateMinute(minute));
        Thread thread8 = new Thread(() -> validate.validateString(type));
        Thread thread9 = new Thread(() -> validate.validateLink(link));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
    }
}
