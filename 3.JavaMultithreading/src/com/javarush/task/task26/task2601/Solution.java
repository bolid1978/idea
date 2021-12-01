package com.javarush.task.task26.task2601;

/*
Почитать в инете про медиану выборки
*/

import java.util.*;

public class Solution {
    static Integer [] mass = {1, 2, 3, 4, 5};
    static Integer [] result ;


    public static void main(String[] args) {

       sort(mass);
    }

    public static Integer[] sort(Integer[] array) {
//        Integer[] mass = array;
//        ArrayList<Integer>  numbers = new ArrayList<>();
//        HashMap<Integer,Double> hashMap = new HashMap<>();
//
//
//
//        double mediana = 0;
//        Arrays.sort(mass);
//        int l = mass.length;
//        if(l%2 != 0 )
//            mediana = mass[l/2];
//        else
//            mediana = (double)(mass[(l/2)] + mass[l/2-1])/2;
//         System.out.println(Arrays.toString(mass));
//        System.out.println(mediana);
//
//
//
//        for (Integer el:mass
//             ) {
//
//            double temp = Math.abs(mediana - el);
//
//
//                hashMap.put(el,temp);
//        }
//       // System.out.println(hashMap);
//        ArrayList<Double> value = new ArrayList<>(hashMap.values());
//        value.sort(new Comparator<Double>() {
//            @Override
//            public int compare(Double o1, Double o2) {
//                if(o1 == o2) return 0;
//                if(o1 > o2) return 1;
//                else  return -1;
//            }
//        });
//      //  System.out.println(value);
//        for (int i = 0; i < value.size(); i++) {
//            for (Map.Entry<Integer,Double> el: hashMap.entrySet()
//                 ) {
//                if(el.getValue()==value.get(i)) numbers.add(el.getKey());
//            }
//
//        }
//
//         //System.out.println(numbers);
//
//        Integer[] resultArray = numbers.toArray(new Integer[0]);
//        System.out.println(Arrays.toString(resultArray));
//        //implement logic here
//        return resultArray;
 //   }


        final double k = mediana(array);
        Arrays.sort(array, Comparator.comparingDouble(n -> Math.abs( k- n)));
       // System.out.println(Arrays.toString(array));
            return array;

    }
    static final double mediana(Integer[] array ){
        Integer[] mass = array;
        double mediana = 0;
        Arrays.sort(mass);
        int l = mass.length;
        if(l%2 != 0 )
            mediana = mass[l/2];
        else
            mediana = (double)(mass[(l/2)] + mass[l/2-1])/2;
        return mediana;
    }
}


