package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static class  MyClassLoader extends ClassLoader{

        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException {
            Class clazz = null;

            try {
                byte[] buffer = Files.readAllBytes(Paths.get(name));
                clazz = defineClass(null, buffer, 0, buffer.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return clazz;
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }


    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException {
        File file = new File(pathToAnimals);
        File [] files = file.listFiles();
        Set<Animal> set = new HashSet<>();
        for (File el:files){
            if(el.isFile() && el.getPath().contains(".class")){
                MyClassLoader myClassLoader = new MyClassLoader();
                Class<?> clazz = myClassLoader.loadClass(el.getAbsolutePath());
                if(Animal.class.isAssignableFrom(clazz)){
                    try {
                        Constructor<?> constructor = clazz.getConstructor();
                        set.add((Animal) constructor.newInstance());
                    }
                    catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return set;
    }

}
