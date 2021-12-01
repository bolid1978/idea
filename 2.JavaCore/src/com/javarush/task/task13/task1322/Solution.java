package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        SimpleObject<String,Integer> stringObject = new StringObject();
    }

    public static  class StringObject implements SimpleObject<String,Integer>{




        @Override
        public SimpleObject<String, Integer> getInstance(Integer[] h) {
            return null;
        }
    }

    interface SimpleObject<T,K> {
        SimpleObject<T,K> getInstance(K[] h);
    }

}
