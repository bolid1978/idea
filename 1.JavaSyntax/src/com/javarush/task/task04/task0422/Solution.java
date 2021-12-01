package com.javarush.task.task04.task0422;

/* 
18+
*/

import javax.imageio.stream.ImageOutputStream;
import java.io.*;
import java.util.concurrent.ScheduledExecutorService;

public class Solution {
    public static void main(String[] args) throws Exception {
      InputStream in=System.in;
      Reader IoStreamReader=new InputStreamReader(in);
      BufferedReader bufferedReader=new BufferedReader(IoStreamReader);
        String name= bufferedReader.readLine();
       int ageOne= Integer.parseInt(bufferedReader.readLine());



        if(ageOne<18) {
            //System.out.println(name);
            System.out.println("Подрасти еще");
        }
       // if(ageTwo<18) System.out.println("Подрасти еще");

    }
}
