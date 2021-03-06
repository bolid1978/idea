package com.javarush.task.task26.task2603;

/*
Убежденному убеждать других не трудно
*/

import java.util.Comparator;

public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T>

    {

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T> ...vararg ) {
            this.comparators = vararg;
        }


        @Override
        public int compare(T o1, T o2) {
            for (Comparator element:comparators
                 ) {
                  int result = element.compare(o1,o2);
                  if(result!= 0) return result;
            }
             return 0;
        }
    }


    public static void main(String[] args) {

    }
}
