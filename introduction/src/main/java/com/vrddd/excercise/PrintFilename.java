package com.vrddd.excercise;

import java.io.BufferedReader;
import java.io.FileReader;

public class PrintFilename {

    private static void print(String path) throws Exception {
        System.out.println(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String p;
        while( (p = bufferedReader.readLine()) != null){
            print(p);
        }
    }

    public static void main(String[] args) throws Exception {
        String path = "H:\\alibaba\\01worklog\\190929-\\first.txt";
        print(path);
    }

}
