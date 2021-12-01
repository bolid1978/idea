package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
           // File yourFile = File.createTempFile("your_file_name", null);
            File yourFile = new File("c:\\1\\one.txt");

            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Ira");
            user.setLastName("Lohan");
            user.setBirthDate(new Date(2004 ,10, 2));
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            String s = "";
            if (users != null ) {
                s = "Yes";
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            bufferedWriter.write(s);
            bufferedWriter.newLine();
                for (User element:users
                     ) {
                     bufferedWriter.write(element.getFirstName());
                     bufferedWriter.newLine();

                    bufferedWriter.write(element.getLastName());
                    bufferedWriter.newLine();

                    bufferedWriter.write(String.valueOf(element.getBirthDate().getTime()));
                    bufferedWriter.newLine();

                    bufferedWriter.write(String.valueOf(element.isMale()));
                    bufferedWriter.newLine();

                    bufferedWriter.write(element.getCountry().getDisplayName());
                    bufferedWriter.newLine();
                }
                 bufferedWriter.close();

            }
            else s = "No";
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            if(bufferedReader.readLine().equals("Yes"))
            {
              while(bufferedReader.ready()){
                  User user = new User();
                  user.setFirstName(bufferedReader.readLine());

                  user.setLastName(bufferedReader.readLine());
                  long time = Long.parseLong(bufferedReader.readLine());
                  user.setBirthDate(new Date(time));

                  user.setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                  String country = bufferedReader.readLine();
                  switch (country){
                      case "Ukraine":{user.setCountry(User.Country.UKRAINE);break;}
                      case "Russia":{user.setCountry(User.Country.RUSSIA);break;}
                      case "Other":{user.setCountry(User.Country.OTHER);break;}
                  }



                   users.add(user) ;

              }
              bufferedReader.close();
            }


            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
