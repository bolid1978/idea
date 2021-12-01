package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
     static{
        countries.put("UA","Ukraine" );
        countries.put("RU","Russia" );
        countries.put("CA","Canada" );

     }
    public static void main(String[] args) {

         Man man = new Man();
         IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(man);
         System.out.println(incomeDataAdapter.getCompanyName());
         System.out.println(incomeDataAdapter.getName());
         System.out.println(incomeDataAdapter.getPhoneNumber());
         System.out.println(incomeDataAdapter.getCountryName());

    }

    public static class IncomeDataAdapter implements Customer,Contact{

         private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
           this.data = incomeData;
        }


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phone = data.getPhoneNumber()+"";

            String zero = "0000000000";
            zero = zero.substring(0, 10-phone.length());
            phone = zero + phone;
            // System.out.println(phone);
            String phoneOne = phone.substring(0, 3);
            String phoneTwo = phone.substring(3, 6);
            String phoneThree = phone.substring(6, 8);
            String phoneFour = phone.substring(8, 10);


            String s = "+"+String.valueOf(data.getCountryPhoneCode())+"("+phoneOne + ")" +
                    phoneTwo + "-" + phoneThree +"-" + phoneFour;


            return s;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }

    public static class Man implements IncomeData {


        @Override
        public String getCountryCode() {
            return "UA";
        }

        @Override
        public String getCompany() {
            return "JavaRush Ltd";
        }

        @Override
        public String getContactFirstName() {
            return "Ivan";
        }

        @Override
        public String getContactLastName() {
            return "Ivanov";
        }

        @Override
        public int getCountryPhoneCode() {
            return 38;
        }

        @Override
        public int getPhoneNumber() {
            return 501234567;
        }
    }
}