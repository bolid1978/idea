package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
     //  FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
       // FileOutputStream outputStream = new FileOutputStream("c:/result.txt");
         FileInputStream inputStream = new FileInputStream("c:\\1\\one.txt");
        FileOutputStream outputStream = new FileOutputStream("c:\\1\\two.txt");
        byte [] buffer = new byte[inputStream.available()];

        if (inputStream.available()>0) {


            int count = inputStream.read(buffer);
            for (byte element:buffer
                 ) {
                System.out.print(element);
            }
            System.out.println();
            outputStream.write(buffer,0 , count);
        }

      //  inputStream.reset();
       // outputStream.flush();
        inputStream.close();
        outputStream.close();
    }
}
