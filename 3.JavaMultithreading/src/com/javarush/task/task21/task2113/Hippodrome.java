package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static    Hippodrome game;
    private List<Horse> horses ;



    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse element: horses
             ) {
            element.move();
        }
    }

    public void print(){
        for (Horse element:horses
             ) {
            element.print();
        }
        for (int i = 0;  i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double maxDistanse = 0;
        Horse res =  null;
        for (Horse element:horses
             ) {
            if(element.distance > maxDistanse) maxDistanse = element.distance;
        }
        for (Horse element : horses
             ) {
            if (element.distance == maxDistanse) {
                res = element;
                break;
            }
        }
        return res;
    }






    public void printWinner(){

        System.out.println("Winner is " + getWinner().name +"!");
    }

    public static void main(String[] args) throws InterruptedException {
        //--------создаем список лошадей
        ArrayList<Horse> horse = new ArrayList<>();
        horse.add(new Horse("Лиза", 3, 0));
        horse.add(new Horse("Катя", 3, 0));
        horse.add(new Horse("Света", 3, 0));

        //---------создаем объек иподром со списком лошадей и присваиваем его в гейм
        game = new Hippodrome(horse);

        game.run();
        game.printWinner();

    }
}
