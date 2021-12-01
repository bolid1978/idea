package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static  void main(String[] args)  {
        String str = "";


        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)) )
        {
            str = bufferedReader.readLine();
        }
        catch (IOException e){

        }
        try(BufferedReader inFile = new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8")))
        {
            str = "";
            while (inFile.ready()){
                str  += inFile.readLine()+" ";
            }
        }
        catch (FileNotFoundException e){

        }
        catch (IOException e){

        }
     //  System.out.println(str);
        String res[] = str.split("\\s");
        for (int i = 0,l = res.length; i < l ; i++) {
                if(res[i] == null) continue;
                for (int j = i+1 ; j < l; j++) {
                    if(res[j] != null){
                    StringBuilder stringBuilder = new StringBuilder(res[j]);
                    if(res[i].equals(stringBuilder.reverse().toString())){
                        Pair one = new Pair();
                        one.first = res[i];
                        one.second = res[j];
                        result.add(one);
                        res[i] =  null;
                        res[j] = null;
                      //System.out.println(Arrays.toString(res));
                        break;
                    }
                }
            }

        }
        for (Pair element: result
             ) {
            System.out.println(element.first + " "+ element.second);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
