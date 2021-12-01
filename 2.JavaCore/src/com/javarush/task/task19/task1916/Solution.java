package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();



    public static void main(String[] args) throws IOException {

        ArrayList<String> one = new ArrayList<>();
        ArrayList<String> two = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();

        reader.close();
        BufferedReader inFileOne = new BufferedReader(new FileReader(fileOne));
        while (inFileOne.ready()){

            one.add(inFileOne.readLine());
        }
        inFileOne.close();
        BufferedReader inFileTwo = new BufferedReader(new FileReader(fileTwo));
        while (inFileTwo.ready()){

            two.add(inFileTwo.readLine());
        }
           inFileTwo.close();

        while (true) {
            if(one.size() == 0 && two.size() == 0){
                break;
            }
            if (one.get(0).equals(two.get(0))) {
                lines.add(new LineItem(Type.SAME, one.get(0)));
                one.remove(0);
                two.remove(0);
            } else if (one.get(1).equals(two.get(0))){
                lines.add(new LineItem(Type.REMOVED, one.get(0)));
                one.remove(0);
            } else if(one.get(0).equals(two.get(1))){
                lines.add(new LineItem(Type.ADDED, two.get(0)));
                two.remove(0);
            }
            if (one.size() == 0 && !(two.size()==0)) {
                lines.add(new LineItem(Type.ADDED, two.get(0)));
                two.remove(0);
            }
            if (two.size() == 0 && !(two.size()==0)) {
                lines.add(new LineItem(Type.REMOVED, one.get(0)));
                one.remove(0);
            }
        }



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
