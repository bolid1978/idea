package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Solution {
    public static void main(String[] args) throws IOException {


            FileInputStream fIn = new FileInputStream(args[1]);
            FileOutputStream fOut = new FileOutputStream(args[2]);




            switch (args[0]) {

                case "-e" :
                    byte [] mass = new byte[fIn.available()];
                    fIn.read(mass);
                    Base64.Encoder enc = Base64.getEncoder();
                    byte[] encbytes = enc.encode(mass);
                    fOut.write(encbytes);
                    fOut.close();
                    fIn.close();
                    break;
                /*String s = Base64.getEncoder().encodeToString(args[1].getBytes());
                 */

                case  "-d" :
                    byte [] massone = new byte[fIn.available()];
                    fIn.read(massone);
                 //   Base64.Encoder enc1 = Base64.getEncoder();
                 //   byte[] encbytes1 = enc1.encode(massone);
                    Base64.Decoder dec = Base64.getDecoder();
                    byte[] decbytes = dec.decode(massone);
                    fOut.write(decbytes);
                    fOut.close();
                    fIn.close();
                    break;


            }


        }



    }

