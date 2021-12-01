package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName) ;


        String str = fileName;
      //  str.endsWith("txt");
     //   str = String.valueOf(fileName.charAt(fileName.length()-3)) +
       //         String.valueOf(fileName.charAt(fileName.length()-2))
        //        +String.valueOf(fileName.charAt(fileName.length()-1));
      //  System.out.println(str);
        FileInputStream res;
       if(str.endsWith(".txt")) {

          res =  new FileInputStream(fileName);
       }
       else {
           super.close();
           throw new UnsupportedFileNameException();
       }


    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
      //  String one = "c:\\1\\one.txt";
       // System.out.println(one);
       // TxtInputStream txtInputStream =new TxtInputStream(one);
    }
}

