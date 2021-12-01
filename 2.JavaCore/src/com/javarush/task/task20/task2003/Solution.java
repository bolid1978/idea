package com.javarush.task.task20.task2003;

/*
Знакомство с properties
*/
/*
* website = https://ru.wikipedia.org/
language : Russian
* */

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties properties = new Properties();

        for (Map.Entry<String ,String> pair: runtimeStorage.entrySet()
             ) {
            properties.setProperty(pair.getKey(), pair.getValue());
            properties.store(outputStream, "Comments about people");
        }

    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();

        properties.load(inputStream);

        for (String name : properties.stringPropertyNames()) {
            runtimeStorage.put(name, properties.getProperty(name));
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine())) {
            save(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}


