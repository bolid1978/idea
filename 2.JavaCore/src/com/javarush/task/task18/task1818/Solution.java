package com.javarush.task.task18.task1818;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String oneFile = reader.readLine();
        String twoFile = reader.readLine();
        String freeFile = reader.readLine();

        BufferedWriter fileOne = new BufferedWriter(new FileWriter(oneFile,true));
        Reader reader1 = new InputStreamReader(new FileInputStream(twoFile),"Windows-1251");
        BufferedReader fileTwo = new BufferedReader(reader1);
        Reader reader2 = new InputStreamReader(new FileInputStream(twoFile),"Windows-1251");
        BufferedReader fileFree = new BufferedReader(reader2);

        FileOutputStream fileOne = new FileOutputStream(oneFile,true);

         FileInputStream fileTwo =new FileInputStream(twoFile);
         FileInputStream fileFree =new FileInputStream(freeFile);

         byte [] massTwo = new byte [fileTwo.available()];
         fileTwo.read(massTwo);
         byte [] massFree = new byte [fileFree.available()];
         fileFree.read(massFree);
         System.out.println();
         fileOne.write(massTwo);
         fileOne.write(massFree);


        fileFree.close();
        fileOne.close();
        fileTwo.close();
*/
        InputStream one = new FileInputStream("c:\\1\\two.txt");
        OutputStream two = new FileOutputStream("c:\\1\\one.txt");
        while (one.available()>0){
            int data =one.read();
            System.out.println((char)data);
            two.write(data);
        }


         two.close();
        one.close();

    }
}
