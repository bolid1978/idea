package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;

    private int[][] gameField = new int[SIDE][SIDE];

    public void initialize(){
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame(){
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
                row [i + 1] = 0;
            }
        }
        return !Arrays.equals(row, clone);
    }
}
