package com.javarush.task.task06.task0606;

/* 
Чётные и нечётные циферки
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {

    public static int even=0;
    public static int odd=0;

    public static void main(String[] args) throws IOException {

       Reader in =new InputStreamReader(System.in);
       BufferedReader bufferedReader=new BufferedReader(in);

       String a=bufferedReader.readLine();
       int b=Integer.parseInt(a);
       // for (int i = 0; i <a.length() ; i++) {
        //    if(Character.getNumericValue(a.charAt(i))%2==0) even++;else odd++;
      //  }
        while (b > 0) {
            if ((b%10)%2==0) even++;
            else odd++;
            b = b/10;
        }
        System.out.printf("Even: %d Odd: %d" ,even,odd);
       //напишите тут ваш код
    }
}
