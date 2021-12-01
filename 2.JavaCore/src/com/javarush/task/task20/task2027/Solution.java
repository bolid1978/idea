package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
     //   System.out.println((char)crossword[1][0]);

        for (Word element: detectAllWords(crossword, "home", "same")
             ) {
            System.out.println(element);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
       //String [] wordsTest = words ;
        String[] str = null;
        ArrayList<Word> myList = new ArrayList<>();

       String s ="";
      // String s = "nu";

        for (int iwords =0,lwords = words.length;iwords < lwords ;iwords++)   {
               s = words[iwords];
           for (int k = 0, kl = crossword.length; k < kl; k++) {
               for (int j = 0, jl = crossword[k].length; j < jl; j++) {
                   //       System.out.print((char)crossword[k][j]);
                   if (crossword[k][j] == (int) s.charAt(0)) {
                       if (s.length() == 1) {
                          Word res = new Word("m");
                          res.setEndPoint(j, k);
                          res.setStartPoint(j, k);
                          myList.add(res);
                       }
                        else
                       {
                           str = consisit(k, j, s, crossword);
                       //    System.out.println("========================");
                        //   System.out.println(Arrays.toString(str));
                           for (int i = 0; i < str.length; i++) {
                               if (str[i].matches(s + "\\w*")) {
                                   myList.add(creatWord(s, i, j, k));
                               }
                           }

                       }
                   }
               //    System.out.println();
               }
           }
       }


        return myList;

    }
      public static String [] consisit(int k,int j,String s,int[][] crossword){
        String[] str = {"","","","","","","",""};
        int y = k;
        int x = j;
       // int[][] analis = crossword;
        // строка о
         String nordNord = "";
         while(y >= 0){
             nordNord = nordNord + (char)crossword[y][x];
             y--;
         }
          str[0] = nordNord;
       //   System.out.println(nordNord);
          // строка 4
          y = k;
          x = j;

          String southSouth = "";
          while(y < crossword.length){
              southSouth = southSouth + (char)crossword[y][x];
              y++;
          }
          str[4] = southSouth;
       //   System.out.println(southSouth);

          // строка 6
          y = k;
          x = j;

          String easthEast = "";
          while(x >= 0){
              easthEast = easthEast + (char)crossword[y][x];
              x--;
          }
          str[6] = easthEast;
       //   System.out.println(easthEast);

          // строка 2
          y = k;
          x = j;

          String westWest = "";
          while(x < crossword[y].length){
              westWest = westWest + (char)crossword[y][x];
              x++;
          }
          str[2] = westWest;
        //  System.out.println(westWest);

          //строка 1
          y = k;
          x = j;

          String nordWest = "";
          while (y >= 0&& x<=crossword[y].length-1){
              nordWest = nordWest + (char)crossword[y][x];
              x++;
              y--;
          }
          str[1] = nordWest;

          //строка 7
          y = k;
          x = j;

          String nordEast = "";
          while (y >= 0 && x >= 0){
              nordEast = nordEast + (char)crossword[y][x];
              x--;
              y--;
          }
          str[7] = nordEast;

          //строка 3
          y = k;
          x = j;

          String southWest = "";
          while (y <= crossword.length-1 && x <= crossword[y].length-1){
              southWest = southWest + (char)crossword[y][x];
              x++;
              y++;
          }
          str[3] = southWest;

          //строка 5
          y = k;
          x = j;

          String southEast = "";
          while (y <= crossword.length-1 && x >=0){
              southEast = southEast + (char)crossword[y][x];
              x--;
              y++;
          }
          str[5] = southEast;


        //  System.out.println("========================");
        //  System.out.println(Arrays.toString(str));



        return str;
      }

      public static Word creatWord(String s,int indexStr,int startX,int strartY){

        Word word =new Word(s);
        word.startX = startX;
        word.startY = strartY;
        int l = s.length()-1;
        //------определяем координаты конца строки
          switch (indexStr){
              case 0:{
                  word.endX = word.startX;
                  word.endY = word.startY - l;
                  break;
              }
              case 4:{
                  word.endX = word.startX;
                  word.endY = word.startY + l;
                  break;
              }

              case 2:{
                  word.endX = word.startX + l;
                  word.endY = word.startY;
                  break;
              }
              case 6:{
                  word.endX = word.startX - l;
                  word.endY = word.startY;
                  break;
              }
              case 1:{
                  word.endX = word.startX + l;
                  word.endY = word.startY - l;
                  break;
              }
              case 3:{
                  word.endX = word.startX + l;
                  word.endY = word.startY + l;
                  break;
              }
              case 5:{
                  word.endX = word.startX - l;
                  word.endY = word.startY + l;
                  break;
              }
              case 7:{
                  word.endX = word.startX - l;
                  word.endY = word.startY - l;
                  break;
              }
          }


        return word;
      }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
