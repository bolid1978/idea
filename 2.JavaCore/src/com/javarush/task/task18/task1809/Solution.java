package com.javarush.task.task18.task1809;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        FileInputStream inFile = null;
        FileOutputStream outFile  = null;
        ArrayList<Byte> file = new ArrayList<Byte>();

        try {
             reader = new BufferedReader(new InputStreamReader(System.in));
            String fileOne = reader.readLine();
            String fileTwo = reader.readLine();

            inFile = new FileInputStream(fileOne);
            outFile = new FileOutputStream(fileTwo);

            while (inFile.available()>0){
                file.add((byte) inFile.read());
            }

            Collections.reverse(file);

            for (Byte element:file
                 ) {
                outFile.write(element);
            }


        }
        catch (Exception e){

        }

        finally {
            reader.close();
            inFile.close();
            outFile.close();
        }
    }
}
