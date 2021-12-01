package com.javarush.task.task19.task1905;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* 
Закрепляем адаптер
*/

public class Solution {



    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public void save(PrintWriter writer) throws Exception {
        writer.println("erwr");


        writer.flush();
    }

    public static void main(String[] args) throws Exception {




        Man man = new Man();
        DataAdapter adapter = new DataAdapter(man, man);

        System.out.println(adapter.getCompany());
        System.out.println(adapter.getContactFirstName());
        System.out.println(adapter.getContactLastName());
        System.out.println(adapter.getDialString());
        System.out.println(adapter.getCountryCode());

    }



    public static class DataAdapter implements RowItem{

        private Customer customer;
        private Contact contact;
        private RowItem rowItem;
        public DataAdapter(Customer customer, Contact contact) {
        this.contact = contact;
        this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            Iterator iterator = countries.entrySet().iterator();
            String a ="";
            while(iterator.hasNext()){
                Map.Entry<String,String> pair ;
                pair = (Map.Entry<String, String>) iterator.next();
                if(pair.getValue().equals(customer.getCountryName())){
                    a = pair.getKey();
                }
            }


            return a;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {

            Pattern p = Pattern.compile("\\s");
            String [] a = p.split(contact.getName());
            return a[1];
        }

        @Override
        public String getContactLastName() {
            Pattern p = Pattern.compile(",");
            String [] a = p.split(contact.getName());
            return a[0];
        }

        @Override
        public String getDialString() {
            Pattern p = Pattern.compile("\\D");
            String [] a = p.split(contact.getPhoneNumber());
            String b = "";
            for (int i = 0,l= a.length; i < l ; i++) {
                b += a[i];
            }

            return "callto://+" + b;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }

    public static class Man implements Customer,Contact{

        String getCompanyName = "JavaRush LtdJavaRush Ltd";
        String getName = "Ivanov, Ivan";
        String getCountryName = "Canada";
        String getPhoneNumber = "+380(50)123-4567";

        public String getCompanyName() {
            return getCompanyName;
        }

        @Override
        public String getCountryName() {
            return getCountryName;
        }

        @Override
        public String getName() {
            return getName;
        }

        @Override
        public String getPhoneNumber() {
            return getPhoneNumber;
        }
    }
}