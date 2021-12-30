package com.javarush.games.racer;

import com.javarush.games.racer.road.RoadManager;

public class PlayerCar extends GameObject {
    private static int playerCarHeight = ShapeMatrix.PLAYER.length;
    public int speed = 1;
    private Direction direction;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public PlayerCar() {

        super(RacerGame.WIDTH / 2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
    }

    public void move(){
       if(  x < RoadManager.LEFT_BORDER) x = RoadManager.LEFT_BORDER;
       if(  x  > RoadManager.RIGHT_BORDER - width) x = RoadManager.RIGHT_BORDER - width;
       switch (direction){
           case RIGHT: {x++;break;}
           case LEFT: {x--;break;}

       }
    }

    public void stop(){
        matrix = ShapeMatrix.PLAYER_DEAD;
    }
}
