package com.javarush.task.task08.task0801;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

           Set<String> set=new HashSet<String>();

          set.add("арбуз");
          set.add("банан");
          set.add("вишня");
          set.add("груша");
          set.add("дыня");
          set.add("ежевика");
          set.add("женьшень");
          set.add("ирис");
          set.add("земляника");
          set.add("картофель");


          Iterator <String> iterator=set.iterator();
          while (iterator.hasNext()){

          System.out.println(iterator.next());
          }



  }
}
