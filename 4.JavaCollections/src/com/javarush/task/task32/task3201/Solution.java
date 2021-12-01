package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String... args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(args[0]), "rw");

//        long i = 0;
//
//        while ( randomAccessFile.read()> 0)
//        {
//            i++;
//        }

        if(randomAccessFile.length() < Long.valueOf(args[1])) {
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(args[2].getBytes(StandardCharsets.UTF_8));
        }
        else
        {
            randomAccessFile.seek(Long.valueOf(args[1]));
            randomAccessFile.write(args[2].getBytes(StandardCharsets.UTF_8));
        }

    }
}
