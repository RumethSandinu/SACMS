package com.example.sacms;

import java.sql.*;
import java.io.*;

public class ReportGen {

    static String name = "name1";
    static String email = "email1";

    public static void main(String[] args) throws IOException {
        File sampleFile = new File("sample.csv");
        if (!sampleFile.exists()){
            sampleFile.createNewFile();
        }else {
            System.out.println("file already exists");
        }

        try {
            FileWriter writer = new FileWriter(sampleFile);
            writer.write(name);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }


    }
}
