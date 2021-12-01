package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        try(InputStream inFile = new FileInputStream(args[0]);
            BufferedWriter outFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]))))
        {
        Charset charsetIn = Charset.forName("windows-1251");
        Charset charsetOut = Charset.forName("UTF-8");
       byte[] buffer = new byte[inFile.available()];

            buffer = inFile.readAllBytes();
            String strNew = new String(buffer, charsetIn);
            buffer  = strNew.getBytes();
            strNew = new String(buffer,charsetOut);
            outFile.write(strNew);



    }
        catch (IOException ex){

        }
    }
}
