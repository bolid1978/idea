package com.javarush.games.racer;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;
import com.javarush.games.racer.road.RoadManager;


public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;
    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private FinishLine finishLine;
    private ProgressBar progressBar;
    private int score;

    private boolean isGameStopped;

    public void initialize(){
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);

    }

    private void createGame(){
        score = 3500;
        progressBar =  new ProgressBar(RACE_GOAL_CARS_COUNT);
        finishLine =  new FinishLine();
        isGameStopped = false;
        roadManager = new RoadManager();
        player =  new PlayerCar();
        roadMarking =  new RoadMarking();
        drawScene();
        setTurnTimer(40);
    }
    private void drawScene(){

        drawField();
        progressBar.draw(this);
        finishLine.draw(this);
        roadManager.draw(this);
        roadMarking.draw(this);
        player.draw(this);
    }

    private void drawField(){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if(j == CENTER_X ) { setCellColor(CENTER_X, i, Color.WHITE);continue;}
                if(j >= ROADSIDE_WIDTH && j < WIDTH - ROADSIDE_WIDTH){ setCellColor(j, i, Color.DIMGREY);continue;}
                setCellColor(j, i, Color.GREEN);
            }
                                }
        }

    private void moveAll(){
        progressBar.move(roadManager.getPassedCarsCount());
        finishLine.move(player.speed);
        roadManager.move(player.speed);
        player.move();
        roadMarking.move(player.speed);
    }

    private  void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.RED, "Game Over", Color.AQUA,100);
        stopTurnTimer();
        player.stop();
    }

    private void  win(){
        isGameStopped = true;
        showMessageDialog(Color.RED, "WIN", Color.AQUA, 100);
        stopTurnTimer();
    }



    @Override
    public void setCellColor(int x, int y, Color color) {
        if(x < WIDTH && x >= 0 && y >= 0 && y < HEIGHT) super.setCellColor(x, y, color);
    }

    @Override
    public void onTurn(int step) {
        score -= 5;
        setScore(score);
        if(roadManager.checkCrush(player)) {
            gameOver();drawScene();return;
        }
        if(roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) finishLine.show();
        roadManager.generateNewRoadObjects(this);
        if(finishLine.isCrossed(player)) {
            win();drawScene();return;
        }
        moveAll();
        drawScene();

    }
    ///

    @Override
    public void onKeyPress(Key key) {
        if(key == Key.RIGHT) player.setDirection(Direction.RIGHT);
        if(key == Key.LEFT) player.setDirection(Direction.LEFT);
        if(key == Key.SPACE && isGameStopped == true) createGame();
        if(key == Key.UP) player.speed = 2;
    }

    @Override
    public void onKeyReleased(Key key) {
        if(key == Key.RIGHT && player.getDirection() == Direction.RIGHT ) player.setDirection(Direction.NONE);
        if(key == Key.LEFT && player.getDirection() == Direction.LEFT ) player.setDirection(Direction.NONE);
        if(key == Key.UP) player.speed = 1;
    }

}
