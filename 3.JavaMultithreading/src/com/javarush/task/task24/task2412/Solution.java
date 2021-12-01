package com.javarush.task.task24.task2412;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Знания - сила!
*/

public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.format(actualDate);
       // System.out.println(dateFormat.toString());
        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"change {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null,null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        list.sort(new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
                String st1 = "";
                String st2 = "";
                st1 =(String) stock1.get("name");
                st2 =(String) stock2.get("name");
                return st1.compareTo(st2);
            }
        }.thenComparing(new Comparator<Stock>() {
            @Override

            public int compare(Stock o1, Stock o2) {
                Date st1Data = (Date) o1.get("date");
                Date st2Data = (Date) o2.get("date");

                long one = st1Data.getTime() - st1Data.getHours()*60*60*1000 - st1Data.getMinutes()*60*1000 - st1Data.getSeconds()*1000 ;
                long two = st2Data.getTime() - st2Data.getHours()*60*60*1000 - st2Data.getMinutes()*60*1000 - st2Data.getSeconds()*1000;
                if (one > two) return -1;
                if (one < two) return 1;
                else return 0;
              //  return st2Data.compareTo(st1Data);
            }
        }.thenComparing(new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                double st1cost = 0;
                double st2cost = 0;

                if(o1.containsKey("last"))
                                     {
                 st1cost = (double) o1.get("last") - (double) o1.get("open");
                                      }
                else {
                    st1cost = (double) o1.get("change");
                }

                if(o2.containsKey("last")){
                   st2cost = (double) o2.get("last") - (double) o2.get("open");
                }
                else{
                    st2cost = (double) o2.get("change");
                }


                if(st1cost > st2cost) return  -1;
                if(st1cost < st2cost) return  1;
                else return  0;


            }
        })));
    }

    public static class Stock extends HashMap<String, Object> {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));


        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
       // stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));
        Date test = getRandomDate(1970);
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", 5, test));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.53, test));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", 56, test));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", 18, test));
       /* Date fg = getRandomDate();
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, fg));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", 6, fg));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", 15, fg));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.05, fg));
*/
        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}

