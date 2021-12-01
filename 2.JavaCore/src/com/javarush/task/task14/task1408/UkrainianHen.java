package com.javarush.task.task14.task1408;

public class UkrainianHen extends  Hen{
    int egg=3;
    @Override
    int getCountOfEggsPerMonth() {
        return this.egg;
    }
    String getDescription(){
        return super.getDescription()+" Моя страна - "+UKRAINE+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}