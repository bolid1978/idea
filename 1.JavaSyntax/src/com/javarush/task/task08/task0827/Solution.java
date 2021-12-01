package com.javarush.task.task08.task0827;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/*January - январь
February - февраль
March - март
April - апрель
May - май
June - июнь
July - июль
August - август
September - сентябрь
October - октябрь
November - ноябрь
December - декабр
* */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("January 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date myData=new Date(date);
        Calendar myCalendar=new GregorianCalendar();

        myCalendar.setTime(myData);
        if((myCalendar.get(Calendar.DAY_OF_YEAR))%2==0) return false;

       // System.out.println(myCalendar.get(Calendar.DAY_OF_YEAR)*24);
       // System.out.println(myData);
       // System.out.println(myCalendar.getTime());


        return true;
    }
}
