package com.javarush.task.task18.task1819;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String oneFile = reader.readLine();
        String twoFile = reader.readLine();

        FileInputStream one = new FileInputStream(oneFile);
        FileInputStream two = new FileInputStream(twoFile);

        byte [] dataOneFile =new byte[one.available()];
        byte [] dataTwoFile =new byte[two.available()];
        one.read(dataOneFile);
        two.read(dataTwoFile);
        one.close();
        two.close();


        byte[] dataAll = new byte[dataOneFile.length+dataTwoFile.length];

        for (int i = 0, l = dataTwoFile.length; i < l; i++) {
            dataAll[i] = dataTwoFile[i];
        }
        for (int i = dataTwoFile.length ,l = dataOneFile.length + dataTwoFile.length, j = 0; i < l; i++,j++) {
            dataAll[i] = dataOneFile[j];
        }
     //   System.out.println(Arrays.toString(dataOneFile));
     //   System.out.println(Arrays.toString(dataTwoFile));
     //   System.out.println(Arrays.toString(dataAll));



      //  ByteArrayOutputStream b = new ByteArrayOutputStream();

       //  b.writeBytes(dataTwoFile);
      //   b.writeBytes(dataOneFile);
       //  dataAll = b.toByteArray();

      //  System.out.println(Arrays.toString(dataOneFile));
     //   System.out.println(Arrays.toString(dataTwoFile));
     //   System.out.println(Arrays.toString(dataAll));

        FileOutputStream oneOut = new FileOutputStream(oneFile);
        oneOut.write(dataAll);
        oneOut.close();

    }
}
