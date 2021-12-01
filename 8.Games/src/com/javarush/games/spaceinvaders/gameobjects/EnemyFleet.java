package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.ShapeMatrix;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    final static  private int ROWS_COUNT =  3;
    final static private int COLUMNS_COUNT =  10;
    final static private int STEP =  ShapeMatrix.ENEMY.length + 1;

    private List<EnemyShip> ships;
    private void createShips(){
        ships =  new ArrayList<EnemyShip>();
    }


}
