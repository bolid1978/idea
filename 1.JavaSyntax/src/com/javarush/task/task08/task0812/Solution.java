package com.javarush.task.task08.task0812;

import java.io.IOException;
import java.util.Arrays;

/* 
Cамая длинная последовательность
2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
*/
public class Solution {
    public static void main(String[] args) throws IOException {
         byte [] c =new byte[256];
         System.in.read(c);
         char[] cChar=new char[256];
        for (int i = 0; i < c.length; i++) {
            cChar[i]=(char)c[i];
        }
        System.out.println(Arrays.toString(cChar));
        /*List<Integer> myList=new ArrayList<Integer>(); //напишите тут ваш код
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);
        for (int i = 0; i < 10; i++) {
            myList.add(Integer.parseInt(bufferedReader.readLine()));
        }


        int counter=1;
        int countertemp=1;
        for (int i = 0; i < myList.size()-1; i++) {
            if(myList.get(i).equals(myList.get(i+1))) countertemp++;
            else{
                countertemp=1;
            }
            if(countertemp>counter) counter=countertemp;

        }
        System.out.println(counter);*/



    }
}