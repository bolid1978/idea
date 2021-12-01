package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;


        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            if(true) throw new CloneNotSupportedException();
            return super.clone();
        }
    }

    public static class C extends B {
        @Override
        protected Object clone()  {

           C c = new C(getI(), getJ(), getName());

           return c;

        }

        public C(int i, int j, String name) {

            super(i, j, name);

        }
    }

    public static void main(String[] args) {

    }
}
