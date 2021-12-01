package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandFatherone =new Human("Рудольф", true,59 );
        Human grandFathertwo =new Human("Petr", true,59 );

        Human grandMatherone =new Human("Olga", true,57 );
        Human grandMathertwo =new Human("Tany", true,57 );

        Human father =new Human("Olga", true,57,grandFatherone,grandMatherone );
        Human mather =new Human("Olga", true,57, grandFathertwo,grandMathertwo);

        Human sonOne =new Human("Olga", true,57, father,mather);
        Human sonTwo =new Human("Olga", true,57, father,mather);
        Human sonFree =new Human("Olga", true,57, father,mather);

        System.out.println(grandFatherone);
        System.out.println(grandMatherone);
        System.out.println(grandFatherone);
        System.out.println(grandMathertwo);
        System.out.println(father);
        System.out.println(mather);
        System.out.println(sonOne);
        System.out.println(sonTwo);
        System.out.println(sonFree);

        // напишите тут ваш код
    }

    public static class Human {
        public String name;
        public boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        // напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}