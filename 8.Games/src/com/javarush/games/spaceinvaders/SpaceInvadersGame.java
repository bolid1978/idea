package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {

    public static final int  WIDTH = 64;
    public static final int  HEIGHT = 64;

    private List<Star> stars ;


    public void initialize(){
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        createStars();
        drawScene();
    }
    private void drawScene(){
        drawField();
    }
    private void drawField(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(j, i, Color.BLACK, "");
            }
        }
        for (Star element: stars
             ) {
            element.draw(this);
        }

    }
    private void createStars(){
        stars = new ArrayList<Star>();
        stars.add(new Star(2, 2));
        stars.add(new Star(4, 2));
        stars.add(new Star(6, 2));
        stars.add(new Star(8, 2));
        stars.add(new Star(10, 2));
        stars.add(new Star(12, 2));
        stars.add(new Star(14, 2));
        stars.add(new Star(16, 2));



    }

}
