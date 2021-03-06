package com.javarush.games.racer;

public class FinishLine extends GameObject{


    public FinishLine() {
        super(RacerGame.ROADSIDE_WIDTH, -1 * ShapeMatrix.FINISH_LINE.length, ShapeMatrix.FINISH_LINE);
    }

    private boolean isVisible = false;
    public void show(){
        isVisible =  true;
    }
    public void move(int boost){
        if(isVisible == false) return;
        y += boost;

    }
    public boolean isCrossed(PlayerCar playerCar){
        if(playerCar.y <= this.y) return true; else return false;
    }
}
