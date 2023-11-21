package com.example.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<Club> availableClubs=new ArrayList<>();
    public static List<ClubAdvisor> availableClubAdvisor=new ArrayList<>();
    public static List<ClubMember> availableMembers=new ArrayList<>();

    public static List<Club> getAvailableClubs(){

        return availableClubs;
    }

    public static List<ClubAdvisor> getAvailableClubAdvisor(){

        return Storage.availableClubAdvisor;
    }
    public static List<ClubMember> getAvailableClubMembers(){

        return Storage.availableMembers;
    }
    public static void allAvailables(){
        for (int i=1;i<6;i++) {
            ClubAdvisor advisor = new ClubAdvisor("CA" + i, "Harry" + i, "Potter" + i, "043254354" + i);
            availableClubAdvisor.add(advisor);
            Club club=new Club("C00"+i,"Club"+i,advisor,i+10,LocalDate.now());
            availableClubs.add(club);
            ClubMember member=new ClubMember("CM00"+i,"Member"+i,"84957"+i);
            availableMembers.add(member);
        }
    }


}
