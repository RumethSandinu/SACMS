package com.example.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;


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
    public static void allAvailables() throws SQLException {
        String url= "jdbc:mysql://localhost:3306/Club_Management";
        String user="root";
        String password="";

        Connection con=null;
        Statement stmt=null;

        con=DriverManager.getConnection(url,user,password);
        String query = "SELECT * FROM Club";
        stmt=con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        while (rs.next()){
            String[] Name=rs.getString(4).split("\\s+");
            availableClubs.add(new Club(rs.getString(1) ,rs.getString(2),rs.getString(3),new ClubAdvisor(Name[0],Name[1]),rs.getInt(5),rs.getDate(6)));
        }

        query="SELECT * FROM Club_Advisor";
        stmt=con.createStatement();
        rs=stmt.executeQuery(query);
        while (rs.next()){
            availableClubAdvisor.add(new ClubAdvisor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
        }

        query="SELECT * FROM Club_Members";
        stmt=con.createStatement();
        rs=stmt.executeQuery(query);
        while (rs.next()){
            availableMembers.add(new ClubMember(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getString(6)));
        }




//        String sql= "INSERT INTO Club "+
//                "VALUES(\"C001\",\"Gryffindor\",\"Red house\",\"CA1\",40,\"2023-11-13\")," +
//                "                (\"C002\",\"Hufflepuff\",\"Yellow house\",\"CA2\",35,\"2023-11-13\")," +
//                "        (\"C003\",\"Ravenclaw\",\"Blue house\",\"CA3\",45,\"2023-11-13\")," +
//                "        (\"C004\",\"Slytherin\",\"Green house\",\"CA4\",50,\"2023-11-13\")," +
//                "        (\"C005\",\"Brutalking\",\"Black house\",\"CA5\",30,\"2023-11-13\");";
//        try{
//        stmt.executeUpdate(sql);
//            System.out.println("Successfully inserted to club");
//        }catch (SQLIntegrityConstraintViolationException ignored){
//            System.out.println("Constraint fails");
//        }
//
//        sql= "INSERT INTO Club_Advisor "+
//                "VALUES (\"ClbAvr01\",\"Harry\",\"Potter\",\"harry.p@gmail.com\",\"0547386373\"),\n" +
//                "        (\"ClbAvr02\",\"Ron\",\"Weasely\",\"ron.w@gmail.com\",\"5483905724\"),\n" +
//                "        (\"ClbAvr03\",\"Hermione\",\"Granger\",\"hermione.g@gmail.com\",\"7548356274\"),\n" +
//                "        (\"ClbAvr04\",\"Neville\",\"Longbottom\",\"neville.l@gmail.com\",\"4378265473\"),\n" +
//                "        (\"ClbAvr05\",\"Seamus\",\"Finnegan\",\"seamus.f@gmail.com\",\"5749365435\");";
//        try{
//            stmt.executeUpdate(sql);
//            System.out.println("Successfully inserted to club advisor");
//        }catch (SQLIntegrityConstraintViolationException ignored){
//            System.out.println("Constraint fails");
//        }
//
//
//        sql = "INSERT INTO Club_Members "+
//                "VALUES  (\"CM0001\",\"Katie\",\"Bell\",\"2000-3-4\", \"2022-5-3\",\"437854343\"),\n" +
//                "        (\"CM0002\",\"Alisa\",\"Johnson\",\"2000-6-4\", \"2022-4-3\",\"4354354655\"),\n" +
//                "        (\"CM0003\",\"Albus\",\"Dumbledore\",\"2000-9-7\", \"2022-5-3\",\"5435435434\"),\n" +
//                "        (\"CM0004\",\"Severus\",\"Snape\",\"2000-3-04\", \"2022-05-03\",\"4872624542\"),\n" +
//                "        (\"CM0005\",\"Minerva\",\"McGonagoll\",\"2000-03-04\", \"2022-05-03\",\"4736435455\"),\n" +
//                "        (\"CM0006\",\"Rubeus\",\"Hagrid\",\"2000-03-04\", \"2022-05-03\",\"5894323265\"),\n" +
//                "        (\"CM0007\",\"Tom\",\"Riddle\",\"2000-03-04\", \"2022-05-03\",\"9148324847\"),\n" +
//                "        (\"CM0008\",\"Barty\",\"Crouch\",\"2000-03-04\", \"2022-05-03\",\"5644337823\"),\n" +
//                "        (\"CM0009\",\"Sirius\",\"Black\",\"2000-03-04\", \"2022-05-03\",\"3214764343\"),\n" +
//                "        (\"CM0010\",\"Cedric\",\"Diggory\",\"2000-03-04\",\"2022-05-03\",\"4327643276\");";
//        try{
//            stmt.executeUpdate(sql);
//            System.out.println("Successfully inserted to club members");
//        }catch (SQLIntegrityConstraintViolationException ignored){
//            System.out.println("Constraint fails");
//        }
//
//
//
//        ClubAdvisor ca1=new ClubAdvisor("ClbAvr01","Harry","Potter","harry.p@gmail.com","054738637");
//        ClubAdvisor ca2=new ClubAdvisor("ClbAvr02","Ron","Weasely","ron.w@gmail.com","548390572");
//        ClubAdvisor ca3=new ClubAdvisor("ClbAvr03","Hermione","Granger","hermione.g@gmail.com","754835627");
//        ClubAdvisor ca4=new ClubAdvisor("ClbAvr04","Neville","Longbottom","neville.l@gmail.com","4378265473");
//        ClubAdvisor ca5=new ClubAdvisor("ClbAvr05","Seamus","Finnegan","seamus.f@gmail.com","5749365");
//
//        availableClubAdvisor.add(ca1);
//        availableClubAdvisor.add(ca2);
//        availableClubAdvisor.add(ca3);
//        availableClubAdvisor.add(ca4);
//        availableClubAdvisor.add(ca5);
//
//
//        Club c1=new Club("C001","Gryffindor","Red house",ca1,40,LocalDate.now());
//        Club c2=new Club("C002","Hufflepuff","Yellow house",ca2,35,LocalDate.now());
//        Club c3=new Club("C003","Ravenclaw","Blue house",ca3,45,LocalDate.now());
//        Club c4=new Club("C004","Slytherin","Green house",ca4,50,LocalDate.now());
//        Club c5=new Club("C005","Brutalking","Black house",ca5,30,LocalDate.now());
//
//        availableClubs.add(c1);
//        availableClubs.add(c2);
//        availableClubs.add(c3);
//        availableClubs.add(c4);
//        availableClubs.add(c5);
//
//
//        ClubMember cm1=new ClubMember("CM0001","Katie","Bell",LocalDate.of(2000,3,4), LocalDate.of(2022,5,3),"437854343");
//        ClubMember cm2=new ClubMember("CM0002","Alisa","Johnson",LocalDate.of(2000,6,4), LocalDate.of(2022,4,3),"4354354655");
//        ClubMember cm3=new ClubMember("CM0003","Albus","Dumbledore",LocalDate.of(2000,9,7), LocalDate.of(2022,5,3),"5435435434");
//        ClubMember cm4=new ClubMember("CM0004","Severus","Snape",LocalDate.of(2000,3,04), LocalDate.of(2022,05,03),"4872624542");
//        ClubMember cm5=new ClubMember("CM0005","Minerva","McGonagoll",LocalDate.of(2000,03,04), LocalDate.of(2022,05,03),"4736435455");
//        ClubMember cm6=new ClubMember("CM0006","Rubeus","Hagrid",LocalDate.of(2000,03,04), LocalDate.of(2022,05,03),"5894323265");
//        ClubMember cm7=new ClubMember("CM0007","Tom","Riddle",LocalDate.of(2000,03,04), LocalDate.of(2022,05,03),"9148324847");
//        ClubMember cm8=new ClubMember("CM0008","Barty","Crouch",LocalDate.of(2000,03,04), LocalDate.of(2022,05,03),"5644337823");
//        ClubMember cm9=new ClubMember("CM0009","Sirius","Black",LocalDate.of(2000,03,04), LocalDate.of(2022,05,03),"3214764343");
//        ClubMember cm10=new ClubMember("CM0010","Cedric","Diggory",LocalDate.of(2000,03,04), LocalDate.of(2022,05,03),"43276432764112341");
//        ArrayList<ClubMember> cms=new ArrayList<ClubMember>(List.of(cm1,cm2,cm3,cm4,cm5,cm6,cm7,cm8,cm9,cm10));
//
//        availableMembers.addAll(cms);
//        c1.setClubMembers(List.of(cm1,cm2,cm3));
//        c2.setClubMembers(List.of(cm4,cm5,cm6));
//        c3.setClubMembers(List.of(cm7,cm8,cm9));
//        c4.setClubMembers(List.of(cm10,cm1,cm4));
//        c5.setClubMembers(List.of(cm2,cm7,cm3));

    }


}
