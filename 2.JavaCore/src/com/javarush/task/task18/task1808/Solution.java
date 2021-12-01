package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Arrays;/*
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {



                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream oneFile = new FileInputStream(reader.readLine());
                FileOutputStream twofile = new FileOutputStream(reader.readLine());
                FileOutputStream trhee = new FileOutputStream(reader.readLine());

                //  int allByteOneFile = oneFile.available();
               byte[] readAllOne = new byte[oneFile.available()];
               int i=0;
                while (oneFile.available()>0) {
                    readAllOne[i] = (byte )oneFile.read();
                    i++;
                }
                //byte [] readAllOne = {1,2,3,4,5,6,7};
                int allByteOneFile = readAllOne.length;
                byte [] recTwo;
                byte  [] recThree;

                if(allByteOneFile%2!=0){
                    recTwo = Arrays.copyOfRange(readAllOne,0,allByteOneFile/2 + 1);
                    recThree = Arrays.copyOfRange(readAllOne, allByteOneFile/2 + 1, allByteOneFile);

                }
                else {
                    recTwo = Arrays.copyOfRange(readAllOne, 0, (allByteOneFile/2) );
                    recThree = Arrays.copyOfRange(readAllOne, (allByteOneFile/2) , allByteOneFile);
                }
                twofile.write(recTwo);
                trhee.write(recThree);
                oneFile.close();
                twofile.close();
                trhee.close();
                reader.close();
                // System.out.println(Arrays.toString(readAllOne));
                // System.out.println(Arrays.toString(recTwo));
                // System.out.println(Arrays.toString(recThree));
            }


        }


