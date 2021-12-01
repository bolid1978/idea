package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        BufferedReader inFile = new BufferedReader(new FileReader(reader.readLine()));
        String s = "";
        String teg = args[0];
        String regOne ="<"+teg+".*<\\/b><\\/"+teg+">";
        String regTwo ="<"+teg+">.*?<\\/"+teg+">";
      /*  while(inFile.ready()){
        s = s +  inFile.readLine();
        }*/
       // inFile.close();
        reader.close();
        String line;
        StringBuilder sb =new StringBuilder();
        while ((line = inFile.readLine()) != null) {
            sb.append(line);
        }
        inFile.close();

        String tag = args[0];

     //   Document document = Jsoup.parse(sb.toString(), "", Parser.xmlParser());
     //   System.out.println(document.toString());
     //   Elements element = document.select(tag);
     //   element.forEach(System.out::println);
    }












        //  System.out.println(s);
      //  Pattern pOne = Pattern.compile(regOne);
      //  Pattern pTwo = Pattern.compile(regTwo,Pattern.MULTILINE);
     //   Pattern pFree = Pattern.compile("<span>\\w*<\\/span>$");
     //   Pattern pFour = Pattern.compile("<span>\\w*<\\/span>$");
      //  Matcher m;
      //  m = pOne.matcher(s);
      //  while (m.find()){
       //     System.out.println(m.group(0));
      //  }
     //  m = pTwo.matcher(s);
     //   while (m.find()){
     //      System.out.println(m.group());
     //   }


}
