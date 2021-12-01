package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.RUSSIA);
        hen.getCountOfEggsPerMonth();
       /* System.out.println(hen.getDescription());
        Hen henB = HenFactory.getHen(Country.BELARUS);
        henB.getCountOfEggsPerMonth();
        System.out.println(henB.getDescription());
        Hen henU = HenFactory.getHen(Country.UKRAINE);
        henU.getCountOfEggsPerMonth();
        System.out.println(henU.getDescription());
        Hen henM = HenFactory.getHen(Country.MOLDOVA);
        henM.getCountOfEggsPerMonth();
        System.out.println(henM.getDescription());*/
    }

    public  static class HenFactory {

        public static Hen getHen(String country) {
            Hen hen = null;
            if (country.equals(Country.UKRAINE)) {
                hen = new UkrainianHen();

            } else if  (country.equals(Country.BELARUS)){
                hen = new BelarusianHen();

            }else if(country.equals(Country.MOLDOVA)){
                hen= new MoldovanHen();
            } else if((country.equals(Country.RUSSIA)))
                hen=new RussianHen();

            return hen;
        }
    }

}
