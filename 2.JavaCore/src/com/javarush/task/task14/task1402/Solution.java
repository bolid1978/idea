package com.javarush.task.task14.task1402;

/* 
Bingo-2!
*/

public class Solution {




    public static void main(String[] args) {
       // new Solution();
        TomCat cat = new TomCat();









        boolean isCat = cat instanceof Cat;
        boolean isMovable = cat instanceof CanMove;
        boolean isTom = cat instanceof TomCat;

        if (isCat && isMovable && isTom) System.out.println("Bingo!");
    }

    static interface CanMove {
    }
    public static class TomCat extends Cat {
        public static   int a=12;

    }
    static class Cat implements CanMove {



}
}
