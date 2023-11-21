package com.example.sacms.EventScheduling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventValidator implements EventValidation
{

    public boolean validateClubID(String clubID)
    {
        System.out.println("clubid");
        return true;
    }

    public boolean validateEventID(String eventID)
    {
        System.out.println("eventid");
        return true;
    }


    public boolean validateDate(String year)
    {
        //If the item purchase year if empty or space
        if (year.isEmpty() || year.equals(" "))
        {
            System.out.println("\u001B[31mYear can not be empty\u001B[39m");
            return false;
        }
        //If the item purchase year if not empty and not space
        else
        {
            try
            {
                //Convert item purchase year to integer
                int yearInt = Integer.parseInt(year);
                //If item purchase year greater than 2021 and less than 2031
                if (yearInt >= 2022 && yearInt < 2031)
                {
                    return true;
                }
                //If item purchase year less than 2022 or greater than 2030
                else
                {
                    System.out.println("\u001B[31myears less than 2022 or greater than 2030 are declined\u001B[39m");
                    return false;
                }
            }
            catch (Exception e)
            {
                return false;
            }
        }
    }


    public boolean validateDate(String year, String month)
    {
        //If item purchase month is not empty and not space
        if (!month.isEmpty() || !month.equals(" "))
        {
            try
            {
                //Convert item purchase moth to integer
                int monthInt = Integer.parseInt(month);
                //If the month is greater than 0 and less than 13
                if (monthInt >= 1 && monthInt <= 12)
                {
                    return true;
                }
                else
                {
                    System.out.println("\u001B[31mMonth must be greater than 0 and less than 13\u001B[39m");
                    return false;
                }
            }
            catch (NumberFormatException em)
            {
                return false;
            }
        }
        else
        {
            System.out.println("\u001B[31mMonth can not be empty\u001B[39m");
            return false;
        }
    }
    public boolean validateDate(String yearStr, String monthStr, String day)
    {
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);

        //If the item purchase day is not empty and not space
        if (!day.isEmpty() || !day.equals(" "))
        {
            try
            {
                //Convert item purchase day to integer
                int dayInt = Integer.parseInt(day);
                //Check the day ranges
                if (year % 4 == 0)
                {
                    if (month == 2)
                    {
                        if (dayInt > 0 && dayInt < 30)
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    if (month == 2)
                    {
                        if (dayInt> 0 && dayInt < 29)
                        {
                            return true;
                        }
                    }
                }
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
                        month == 10 || month == 12)
                {
                    if (dayInt > 0 && dayInt < 32)
                    {
                        return true;
                    }
                }
                else if (month == 4 || month == 6 || month == 9 || month == 11)
                {
                    if (dayInt > 0 && dayInt < 31)
                    {
                        return true;
                    }
                }
            }
            catch (NumberFormatException ed)
            {
                return false;
            }
        }//If the item purchase day is empty or space
        else
        {
            System.out.println("\u001B[31mDay can not be empty\u001B[39m");
            return false;
        }
        return false;
    }

    public boolean validateHour(String hour)
    {
        double hourDouble = Double.parseDouble(hour);
        int hourInt = Integer.parseInt(hour);
        return (hourInt > -1) && (hourInt < 25) && (hourDouble - hourInt == 0.0);
    }
    public boolean validateMinute(String minute)
    {
        double minDouble = Double.parseDouble(minute);
        int minInt = Integer.parseInt(minute);
        return (minInt > -1) && (minInt < 61) && (minDouble - minInt == 0.0);
    }

    public synchronized boolean validateString(String str)
    {
        String regex = "^[a-zA-Z0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public boolean validateLink(String link)
    {
        String urlRegex = "^(https?|ftp)://[a-zA-Z0-9+&@#/%?=~_|!:,.;]*[a-zA-Z0-9+&@#/%=~_|]$";

        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(link);
        return matcher.matches();
    }
}


