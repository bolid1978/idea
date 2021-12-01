package com.javarush.task.task16.task1630;

import java.io.*;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public  static boolean flagRun = false;

    static{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = bufferedReader.readLine();//"c:\1\one.txt";
            secondFileName =bufferedReader.readLine(); //"c:\1\two.txt";
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);


         f.start();
          f.join();
        //add your code here - добавьте код тут
       System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }

    public static class  ReadFileThread  extends Thread implements ReadFileInterface {

        String setFileName;

        @Override
        public void setFileName(String fullFileName) {
            this.setFileName = fullFileName;
        }

        @Override
        public String getFileContent() throws IOException {
            if(flagRun == false) return "";
           FileReader fileReader =new FileReader(setFileName);
           BufferedReader bufferedReader =new BufferedReader(fileReader);
           String inputFile="";
           String s="";

           while(bufferedReader.ready()){
               s = bufferedReader.readLine();
               if(s!=null)
                   inputFile += " "+s;
               else break;

           }
           bufferedReader.close();
           fileReader.close();

           return inputFile;
        }




        public void run() {
            //System.out.println(Thread.currentThread().getName());
            try {
              flagRun = true;
              getFileContent();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } //add your code here - добавьте код тут
}
