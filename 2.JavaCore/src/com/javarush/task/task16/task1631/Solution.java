package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;

/* 
Factory method pattern
*/

public class Solution {
       static{

        String secondFileName = "\"c:\\one.txt\"";
        System.out.println(secondFileName);}
    public static void main(String[] args) throws IllegalAccessException {
        ImageReader reader = ImageReaderFactory.getImageReader(null);
    }
}
