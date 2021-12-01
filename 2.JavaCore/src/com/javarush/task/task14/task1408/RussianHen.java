package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    int egg=4;
    @Override
    int getCountOfEggsPerMonth() {
        return this.egg;

    }
    String getDescription(){
        return super.getDescription()+" Моя страна - "+RUSSIA+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}