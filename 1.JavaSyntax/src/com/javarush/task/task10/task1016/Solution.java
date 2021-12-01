package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ThreadLocalRandom cifra=ThreadLocalRandom.current();
        ArrayList<String> words = new ArrayList<String>();
     /*   for (int i = 0; i < 100000; i++) {
            words.add(String.valueOf(cifra.nextInt(0,10000)));

        }*/
        words.add("1");
        words.add("1");
        words.add("4");
        words.add("2");
        words.add("1");
        words.add("1");
        words.add("2");
        words.add("1");

        Date start=new Date();
        Map<String, Integer> map = countWords(words);
        Date stop=new Date();
       for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        System.out.println(stop.getTime()-start.getTime()+"..................");
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        /*list.sort(new Comparator<String>() {

            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });*/
       String [] strings= list.toArray(new String[0]);
      // Arrays.sort(strings);
     //   System.out.println(Arrays.toString(strings));

        int l=strings.length;
        int i=0,j=0;

        while(i<l-1){
            i=j;
           int counter=0;
           String temp="";
            for ( j = i; j <l ; j++) {
                if (strings[i].equals(strings[j]))  {
                    counter++;temp=strings[i];
                }else{
                   break;
                }

            }

            result.put(temp,counter);

        }





     //   System.out.println(list);
      //  System.out.println(result.toString());

        return result;
    }

}

