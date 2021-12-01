package com.javarush.task.task31.task3113;

/*
Что внутри папки?
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
Что внутри папки?
*/

public class Solution {
    static int directoriesCount = 0;
    static int filesCount = 0;
    static long bytesCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        Path pth = Paths.get(path);

        if (!Files.isDirectory(pth)) {
            System.out.println(pth.toAbsolutePath().toString() + " - не папка");
            return;

        } else {

            Files.walkFileTree(pth, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    directoriesCount++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    filesCount++;
                    bytesCount = bytesCount + attrs.size();
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Всего папок - " + (filesCount - 1));
            System.out.println("Всего файлов - " + directoriesCount);
            System.out.println("Общий размер - " + bytesCount);
        }
    }
}
