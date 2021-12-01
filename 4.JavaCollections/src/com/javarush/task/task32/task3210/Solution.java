package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
      // RandomAccessFile randomAccessFile = new RandomAccessFile(new File("c:\\1\\1.txt"), "rw") ;
            long number = Long.valueOf(args[1]);
         // long number = 3;
           String str = args[2];
        //  String str = "345";

          randomAccessFile.seek(number);

          int i = 0;
          byte[] mass = new byte[str.length()];

          randomAccessFile.read(mass, 0, str.length());
          System.out.println(Arrays.toString(mass));
          String outMassFile = new String(mass);

          System.out.println(outMassFile);
          long endFile = randomAccessFile.length();
          randomAccessFile.seek(endFile);
          if (str.equals(outMassFile)) {
              byte[] rec = "true".getBytes(StandardCharsets.UTF_8);
              randomAccessFile.write(rec);
          } else {
              byte[] rec = "false".getBytes(StandardCharsets.UTF_8);
              randomAccessFile.write(rec);
          }
          randomAccessFile.close();
      }

}
