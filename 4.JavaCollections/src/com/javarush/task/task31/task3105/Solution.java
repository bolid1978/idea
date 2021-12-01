package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) {
        String newFileName = Paths.get(args[0]).getFileName().toString(); //Имя файла, без полного пути
        String newPathInArchive = null;  //Файл в архиве
        newPathInArchive = "new/" + newFileName;

        //Мапа с именем файла и массивом байта файла
        Map<String, ByteArrayOutputStream> filesInArchive = new HashMap<>();

        //Создание потоков чтения архива и чтнеия файла
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry entry; //Объект ахрива
            while ((entry = zin.getNextEntry()) != null) { //если есть объект арихва
                ByteArrayOutputStream baos = new ByteArrayOutputStream(); //Буферный массив
                byte[] bytes = new byte[1024]; //Буферный массив из одного килобайта
                int readByte;
                if (!entry.getName().equals(newFileName)) { //если имя файла не такое как новое
                    while ((readByte = zin.read(bytes)) != -1) {//Записываем значения байтов в
                        // буферный массив и выводим количество прочитанных байтов
                        baos.write(bytes, 0, readByte); // Записываем байты из массива с оперделенным ограничением
                    }
                    filesInArchive.put(entry.getName(), baos); //Записываем элемент в мапу
                } else {
                    newPathInArchive = entry.getName();//Если такой файл существует то заменяем значение нового файла
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(args[1]))) {
            zout.putNextEntry(new ZipEntry(newPathInArchive));//Помещаем файл в архив
            Files.copy(Paths.get(args[0]), zout);//Наполняем файл архива
            zout.closeEntry();//Переходим к следующей записи
            File file = new File(args[0]);
            for (Map.Entry<String, ByteArrayOutputStream> entry : filesInArchive.entrySet()) {//Запись файлов из мапы
                if (entry.getKey().substring(entry.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                zout.putNextEntry(new ZipEntry(entry.getKey()));
                entry.getValue().writeTo(zout);
                //zout.closeEntry();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
