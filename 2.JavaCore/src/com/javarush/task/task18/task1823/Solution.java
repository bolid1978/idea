package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = "";
        while (true) {
            nameFile = reader.readLine();
            if (nameFile.equals("exit")) break;
            Thread one = new Thread(new ReadThread(nameFile));
            one.start();

        }

    }
/*
    public static class ReadThread extends Thread {

       String nameFile="";

        public ReadThread(String fileName) {
           nameFile = fileName; //implement constructor body
        }

          public void run() {
              //   System.out.println(nameFile + " "+currentThread());

              try {
                  FileInputStream file = new FileInputStream(nameFile);
                  int l = file.available();
                  byte [] allBytaFile = new byte[l];
                  file.read(allBytaFile);

             //     Arrays.toString(allBytaFile);

                  ArrayList<Integer> nallBytaFile = new ArrayList<Integer>();
                  ArrayList<Integer> freqByte = new ArrayList<Integer>();

                  for (byte el:allBytaFile
                       ) {
                      nallBytaFile.add((int)el);
                  }
              //    System.out.println(nallBytaFile);
                  for (Integer el: nallBytaFile
                       ) {
                      freqByte.add(Collections.frequency(nallBytaFile, el));
                  }
               //   System.out.println(freqByte);
                  int max = 1;


                  for (Integer el :freqByte
                       ) {
                      if(el > max) max = el;
                  }

                  Integer maxByteCount = nallBytaFile.get(max-1);
              //    System.out.println(maxByteCount);
                     synchronized (Solution.class) {
                         resultMap.put(nameFile, maxByteCount);
                     }
                //  System.out.println(resultMap);
                     file.close();



              } catch (FileNotFoundException fileNotFoundException) {
                  fileNotFoundException.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }


        }

  */


    public static class ReadThread extends Thread {
        FileInputStream fileInputStream;
        String fileName;

        public ReadThread(String fileName) throws FileNotFoundException, InterruptedException {
            //implement constructor body
            super(fileName);
            this.fileName = fileName;

        }

        @Override
        public void run() {
          //  HashMap<String, Integer> resultMap = new HashMap<>();
            FileInputStream fileReader = null;
            try {
                fileReader = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            HashMap<Integer, Integer> bytesOften = new HashMap<>();

            while (true) {
                try {
                    if (!(fileReader.available() > 0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int data = 0;
                try {
                    data = fileReader.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (bytesOften.containsKey(data)) {
                    bytesOften.put(data, bytesOften.get(data) + 1);
                } else bytesOften.put(data, 1);
            }

            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int max = Collections.max(bytesOften.values());

            synchronized (Solution.class) {
                for (HashMap.Entry<Integer, Integer> pair : bytesOften.entrySet())
                    if (pair.getValue().equals(max))
                        resultMap.put(fileName, pair.getKey());

            }
        }
    }
}