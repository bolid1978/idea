package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
          //  File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("c:\\1\\one.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;
           //  if (!name.equals(human.name)) return false;
              if (name != null ? !name.equals(human.name) : human.name != null) return false;
              return assets != null ? assets.equals(human.assets) : human.assets == null;
          //  return assets.equals(human.assets);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            String str ="";
            if(name != null && assets != null){
                str = "Yes";
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.write(name);
                bufferedWriter.newLine();
                for (Asset element: assets
                     ) {
                    bufferedWriter.write(element.getName());
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(element.getPrice()));
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }




            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String s =  bufferedReader.readLine();
                if(s.equals("Yes")){
                name = bufferedReader.readLine();

                while (bufferedReader.ready()){
                    String  nameAsset = bufferedReader.readLine();
                    Double priceAsset = Double.parseDouble(bufferedReader.readLine());

                    assets.add( new Asset(nameAsset, priceAsset));
                }

                bufferedReader.close();
            }
            //implement this method - реализуйте этот метод
        }
    }
}
