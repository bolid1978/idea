package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private boolean isGameStopped = false;
    private int score = 0;

    private int[][] gameField = new int[SIDE][SIDE];

    public void initialize(){

        setScreenSize(SIDE, SIDE);setScore(0);
        createGame();
        drawScene();
    }

    private void createGame(){
        setScore(0);
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();

    }

    private void drawScene(){
        for (int i = 0; i < gameField[0].length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                setCellColoredNumber(j, i, gameField[i][j]);
            }
        }

    }

    private void createNewNumber(){

        if(getMaxTileValue() == 2048) win();

        int y = 0;
        int x = 0;
        while (true){
        y = getRandomNumber(SIDE);
        x = getRandomNumber(SIDE);
        if(gameField[y][x] == 0) break;
    }
        int cifra = getRandomNumber(10);
        gameField[y][x] = cifra == 9 ? 4  : 2;

    }

    private void setCellColoredNumber(int x,int y,int value){


        Color color =  getColorByValue(value );
        // как кастануть??!!
        String v = String.valueOf(value);
        if(value == 0) setCellValueEx (x, y, color, "");
        else setCellValueEx(x, y, color, v);


    }

    private Color getColorByValue(int value){
        Color cell = null;
        switch (value)
        {
            case 0: { cell = Color.WHITE;break;}
            case 2: {cell = Color.PALEVIOLETRED;break;}
            case 4: {cell =Color.PURPLE;break;}
            case 8: {cell = Color.BLUE;break;}
            case 16: {cell = Color.PALETURQUOISE;break;}
            case 32: {cell = Color.PALEGREEN;break;}
            case 64: {cell = Color.GREEN;break;}
            case 128: {cell = Color.YELLOW;break;}
            case 256: {cell = Color.PINK;break;}
            case 512:{ cell = Color.ORANGE;break;}
            case 1024: {cell = Color.CRIMSON;break;}
            case 2048: {cell = Color.RED;break;}

        }
        return cell;
    }

    private boolean compressRow(int[] row) {
        boolean move = false;
        for (int i = 1; i < row.length; i++) {
            if (row[i] == 0) continue;
            if (row[i] != 0 && row[i - 1] == 0) {
                row[i - 1] = row[i];
                row[i] = 0;
                move = true;
                i = 0;
            }
        }
        return move;
    }

    private boolean mergeRow(int[] row){
        int[] clone = row.clone();
        for(int i = 0; i < row.length - 1; i++) {
            if(row[i] != 0 && row[i] == row[i + 1]) {
                row[i] = row[i] + row[i + 1];
                score += row[i];
                setScore(score);
                row [i + 1] = 0;
            }
        }
        return !Arrays.equals(row, clone);
    }

    @Override
    public void onKeyPress(Key key) {

        if(!canUserMove()) {gameOver();return;}
        if(key != Key.SPACE && isGameStopped == true) return;
        switch (key){
            case LEFT:{moveLeft();drawScene();break;}
            case RIGHT:{moveRight();drawScene();break;}
            case UP:{moveUp();drawScene();break;}
            case DOWN:{moveDown();drawScene();break;}
            case SPACE:{
                isGameStopped = false;
                createGame();
                drawScene();
                break;}
        }
    }

    private void moveLeft(){
        boolean compressRow = false;
        boolean mergeRow = false;

        for (int i = 0; i < gameField[0].length; i++) {
            if (compressRow(gameField[i])) {
                compressRow = true;
            }
            if (mergeRow(gameField[i])) {
                mergeRow = true;
            }
            if (compressRow(gameField[i])) {
                compressRow = true;
            }

        } if (compressRow || mergeRow) {
            createNewNumber();
        }

    }

    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();


    }

    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise(){
//        int SIDE = 4;
//        int[][] gameField = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        print(gameField);
        int[][] rotate = new int[SIDE][SIDE];
        int[] temp = new int[SIDE];

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                rotate[i][j] = gameField[i][j];
            }
        }
        for (int i = 0; i < rotate[0].length; i++) {
            for (int j = 0; j < SIDE; j++) {
                temp[j] = rotate[i][j];
            }

            for (int k = 0; k < SIDE; k++) {
                gameField[k][SIDE -1 - i] = temp[k];
            }
        }

    }

    private int getMaxTileValue(){
        int max = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if(gameField[i][j] > max) max = gameField[i][j];
            }
        }
        return max;
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.RED,"Вы выграли", Color.BLUE, 50);
    }

    private boolean canUserMove() {
        boolean zeroMatrix = false;
        boolean maybeSum = false;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] == 0) zeroMatrix = true;
            }
        }


        int[] temp = new int[SIDE];


        for (int i = 0; i < gameField[0].length; i++) {
            for (int j = 0; j < SIDE; j++) {
                temp[j] = gameField[i][j];
            }
            for (int k = 0; k < temp.length -1; k++) {
                if(temp[k] == temp[k +1]) maybeSum = true;
            }
        }
        for (int i = 0; i < gameField[0].length; i++) {
            for (int j = 0; j < SIDE; j++) {
                temp[j] = gameField[j][i];
            }
            for (int k = 0; k < temp.length -1; k++) {
                if(temp[k] == temp[k +1]) maybeSum = true;
            }
        }
        if(zeroMatrix) return true;
        else if (maybeSum) return true;else return false;

        
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.RED, "Game Over", Color.AQUA, 50);
    }

     public void setScore(int score){
        this.score = score;
    }

}
