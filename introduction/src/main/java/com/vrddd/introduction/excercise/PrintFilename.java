package com.vrddd.introduction.excercise;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 练习四：递归打印文件中引用到的fileName
 */
public class PrintFilename {

    private static void print(String path) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String p;
        while( (p = bufferedReader.readLine()) != null){
            System.out.println(p);
            print(p);
        }
    }

    public static void main(String[] args) throws Exception {
        String path = "D:\\01worklog\\190929-递归\\first.txt";
        print(path);
    }

}
