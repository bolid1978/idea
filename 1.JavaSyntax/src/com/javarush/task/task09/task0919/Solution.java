package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) throws Exception{
        try {
            divideByZero();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void divideByZero(){


        System.out.println(45/0);


    }

}
