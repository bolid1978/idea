package com.javarush.task.task15.task1527;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.String.valueOf;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        ArrayList<String> strings=new ArrayList<>();
        bufferedReader.close();

        //  String s ="http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo" ;
        //  String s ="http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo" ;
        s=s.substring(s.indexOf('?')+1)+"&&";


        while (s.length()!=0) {
            strings.add(s.substring(0, s.indexOf('&')));
            s = s.substring(s.indexOf('&')+1);

        }
        strings.remove(strings.remove(strings.size()-1));

        LinkedHashMap<String,String> hashMap=new LinkedHashMap	<>();

        for (String element:strings
        ) {
            String a ,b ;
            if(element.contains("=")){
                a = element.substring(0,element.indexOf('='));
                b = element.substring(element.indexOf('=')+1);
            }else {
                a = element;
                b = null;
            }
            hashMap.put(a,b);
        }
      String s1="";
        for (Map.Entry<String,String> pair: hashMap.entrySet()
        ) {
            s1 = s1+(pair.getKey()+" ");
        }
        System.out.println(s1.substring(0,s1.length()-1));
       // System.out.println();
        for (Map.Entry<String,String> pair: hashMap.entrySet()
        ) {
            String a = pair.getKey();
            // if(a==null) continue;
            if(a.equals("obj")) {
              //  if(pair.getValue().contains(".")){

                    try{
                        String s2= pair.getValue();
                         valueOf(pair.getValue());

                        alert(Double.valueOf(s2));
                    }
                    catch (Exception e){
                        alert(pair.getValue());
                    }

              // }
               // else{
               //     alert(pair.getValue());
               // }
            }


        }

        //   System.out.println();
        //  System.out.println(strings);
        //   System.out.println(s);//add your code here
        //   System.out.println(hashMap);//add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
