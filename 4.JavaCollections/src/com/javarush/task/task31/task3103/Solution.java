package com.javarush.task.task31.task3103;

import java.io.IOException;
import java.util.List;


/* 
Своя реализация
*/

public class Solution {

        public static byte[] readBytes(String fileName) throws IOException {
            java.io.File files = new java.io.File(fileName);
            java.nio.file.Path endFile = files.toPath() ;
            java.io.InputStream inputStream = files.toURL().openStream();

            return java.nio.file.Files.readAllBytes(endFile);


        }

        public static List<String> readLines(String fileName) throws IOException {

            java.io.File files = new java.io.File(fileName);
            java.io.InputStream inputStream = files.toURL().openStream();
            java.nio.file.Path endFiles = files.toPath();



            return java.nio.file.Files.readAllLines(endFiles);
        }

        public static void writeBytes(String fileName, byte[] bytes) throws IOException {

            java.nio.file.Files.write(java.nio.file.Paths.get(fileName), bytes );
        }

        public static void copy(String resourceFileName, String destinationFileName) throws IOException {



            java.nio.file.Files.copy(java.nio.file.Paths.get(resourceFileName),java.nio.file.Paths.get(destinationFileName) );

        }
    }

