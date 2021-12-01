package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public static void main(String[] args) {
        new Solution().recurse(132);
    }
    public void recurse(int n) {
        int m = 2;
        if(n<=1) return;
        while (true) {

            if (n % m == 0) {
                System.out.print(m + " ");
                if (m == n)
                    return;
                recurse(n/m);
                break;
            }
            m++;
        }

    }
}
