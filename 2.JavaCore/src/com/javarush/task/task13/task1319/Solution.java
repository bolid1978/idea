package com.javarush.task.task13.task1319;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();

      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));

        OutputStream outputStream=new FileOutputStream(str);
       // outputStream.write(12);
       // outputStream.write(Character.getDirectionality('\n'));
        outputStream.write((char)5);

        outputStream.close();
           /*

        while(true){
            str=bufferedReader.readLine();
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            if(str.equals("exit")) break;
        }
        bufferedWriter.close();
*/
    }
}
