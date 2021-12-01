package com.javarush.task.task14.task1408;

public class MoldovanHen extends  Hen{
    int egg=2;
    @Override
    int getCountOfEggsPerMonth() {
        return this.egg;
    }
    String getDescription(){
        return super.getDescription()+" Моя страна - "+MOLDOVA+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}