package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        try {

            Path path = Paths.get(fileName);

            FileInputStream file = new FileInputStream(path.toString());

            Properties properties = new Properties();

            if (path.toString().endsWith(".xml")) {
                properties.loadFromXML(file);
                return properties;
            }
            else {
                properties.load(file);
                return properties;
            }

        } catch (Exception e) {
            return new Properties();
        }
}
}
