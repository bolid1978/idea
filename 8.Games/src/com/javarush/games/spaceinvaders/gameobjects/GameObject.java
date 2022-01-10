package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.*;

public class GameObject {
    public double x;
    public double y;
    public  int[][] matrix ;
    public int width;
    public int height;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setMatrix(int[][] matrixOne){
        width = matrixOne[0].length;
        height = matrixOne.length;

        matrix = matrixOne;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                this.matrix[i][j] = matrixOne[i][j];
//            }
//        }
    }

    public void draw(Game game){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                game.setCellValueEx((int)(this.x + j) , (int)(this.y + i), Color.values()[matrix[i][j]], "");
            }
        }
    }
}
