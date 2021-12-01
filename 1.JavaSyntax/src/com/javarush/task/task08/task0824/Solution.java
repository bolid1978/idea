package com.javarush.task.task08.task0824;


import java.util.ArrayList;

/*
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human onechildren=new Human("Андрей", true, 40);
        Human twochildren=new Human("Вика", false, 40);
        Human freechildren=new Human("Ольга", false, 40);

        ArrayList<Human> cilderparents=new ArrayList<>();

        cilderparents.add(onechildren);
        cilderparents.add(twochildren);
        cilderparents.add(freechildren);

        Human Father=new Human("Папа", true, 40,cilderparents);
        Human Mather=new Human("Мама", false, 40,cilderparents);

        ArrayList<Human> cilderparentsFather=new ArrayList<>();
        cilderparentsFather.add(Father);
        ArrayList<Human> cilderparentsMather=new ArrayList<>();
        cilderparentsMather.add(Mather);

        Human grandFatherFather=new Human("Дедушка Папы", true, 60,cilderparentsFather);
        Human grandMatherFather=new Human("Бабушка Папы", false, 60,cilderparentsFather);

        Human grandFatherMather=new Human("Дудушка Мамы", true, 60,cilderparentsMather);
        Human grandMatherMather=new Human("Бабушка Мамы", false, 60,cilderparentsMather);

        System.out.println(grandFatherFather.toString());
        System.out.println(grandFatherMather.toString());
        System.out.println(grandMatherFather.toString());

        System.out.println(grandMatherMather.toString());


        System.out.println(Father.toString());
        System.out.println(Mather.toString());


        System.out.println( onechildren.toString());
        System.out.println( twochildren.toString());
        System.out.println( freechildren.toString());

    }

    public static class Human {
        //напишите тут ваш код

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        String name;
        boolean sex;
        int age;
        ArrayList<Human> children=new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

