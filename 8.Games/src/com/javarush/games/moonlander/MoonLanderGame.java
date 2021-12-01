package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;


public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private boolean isGameStopped;
    private GameObject platform;
    private int score;

    private void createGameObjects(){
        rocket = new Rocket(WIDTH/2, 0);
        landscape = new GameObject(0, 25,ShapeMatrix.LANDSCAPE);
        platform = new GameObject(23, MoonLanderGame.HEIGHT - 1, ShapeMatrix.PLATFORM);
    };

    public void initialize(){
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.BLACK);
            }
        }
        rocket.draw(this);
        landscape.draw(this);

    }

    private void createGame(){

         isUpPressed = false;
         isLeftPressed = false;
         isRightPressed = false;
         isGameStopped = false;
        createGameObjects();
        drawScene();
        setTurnTimer(50);
        score = 1000;
    }

    @Override
    public void onTurn(int step) {
       // super.onTurn(step);
        rocket.move(isUpPressed,isLeftPressed,isRightPressed);
        check();

        drawScene();
        if (score > 0 ) score--;
        setScore(score);

    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if( x >= WIDTH || y >= HEIGHT) return;
        if (x <= 0 || y <= 0) return;
        super.setCellColor(x, y, color);
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key){
            case UP: {
                isUpPressed = true; isRightPressed = false;isLeftPressed = false;return;
            }
            case RIGHT:{
                isRightPressed = true;isLeftPressed = false;isUpPressed = false;return;
            }
            case LEFT:{
                isLeftPressed = true;isUpPressed = false;isRightPressed = false;return;
            }
            case SPACE:{
                if (isGameStopped) createGame();else return;
            }
        }
        //super.onKeyPress(key);
    }

    @Override
    public void onKeyReleased(Key key) {
        if(key == Key.UP) isUpPressed = false;
        if(key == Key.RIGHT) isRightPressed = false;
        if(key == Key.LEFT) isLeftPressed = false;
    }

    private void check(){
        if(rocket.isCollision(landscape) && !rocket.isCollision(platform) ) {
            gameOver();
        }
        if(rocket.isCollision(platform)&&rocket.isStopped()) {
            win();
        }

    }

    private  void win(){
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.BLACK,"Game win",Color.AQUA,120);
        stopTurnTimer();
    }

    private  void  gameOver(){
        rocket.crash();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "Game Over", Color.AQUA, 123);
        stopTurnTimer();
        score = 0;
    }




}
