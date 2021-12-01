package com.javarush.task.task14.task1408;

public class  BelarusianHen extends  Hen{
    int egg=1;
    @Override
    int getCountOfEggsPerMonth() {
        return this.egg;
    }
    String getDescription(){
        return super.getDescription()+" Моя страна - "+BELARUS+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}