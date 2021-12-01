package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {

    static private final String MINE = "\uD83D\uDCA3";
    static private final String FLAG = "\uD83D\uDEA9";
    static private final String CELL = "";
    private Color COLOR_FIELD= Color.AQUAMARINE;
    private Color COLOR_MINE = Color.RED;
    private Color COLOR_NONEIGHBORMINE = Color.LIGHTCORAL;
    private Color COLOR_CLEARCELL = Color.GREEN;
    private Color COLOR_FLAG = Color.YELLOW;
    private int PROBABILITY_CONST = 10; // 1/10
    private int countClosedTiles = SIDE*SIDE;

    static private final int SIDE = 9;
    private int countMinesOnField;
    private int countFlags;
    private boolean isGameStopped;
    private  int score;



    private GameObject gameField[][] = new GameObject[SIDE][SIDE];

    @Override
    public void initialize() {
        // Тут выполняем все действия по инициализации игры и ее объектов
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if(isGameStopped) {
            restart();return;
        }
        openTile(x,y);
    }
    @Override
    public void onMouseRightClick(int x, int y) {

           markTile(x,y);

    }
    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE*SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.AQUA, "Game Win", Color.BLACK,100);
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.RED, "Game Over", Color.BLACK,100);
    }
    //    gameField[y][x]
    private void createGame() {
        if(isGameStopped){
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellValue(j,i,"");

            }
        }
        }
        boolean isMine;
        countMinesOnField = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                isMine = (getRandomNumber(PROBABILITY_CONST)) == 1;
                gameField[j][i] = new GameObject(i, j, isMine);
                setCellColor(i, j, COLOR_FIELD);
                setCellValue(i, j, CELL);
                countMinesOnField = isMine ? countMinesOnField + 1 : countMinesOnField;
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }
    private List<GameObject> getNeighbors(GameObject gameObject){
        int a,b,c,d;
        List<GameObject> list = new ArrayList<>();
        a = (gameObject.x == 0) ? 0 : gameObject.x - 1 ;
        b = (gameObject.x == SIDE-1) ? SIDE-1 : gameObject.x + 1 ;
        c = (gameObject.y == 0) ? 0 : gameObject.y - 1  ;
        d = (gameObject.y == SIDE-1) ? SIDE-1 : gameObject.y + 1 ;


        for (int j = c; j <= d; j++) {
            for (int i = a; i <= b; i++) {
                if(!(i == gameObject.x & j == gameObject.y)){
                    list.add(gameField[j][i]);
                }
            }
        }
        return list;
    }

    private void countMineNeighbors() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                GameObject gameObject = gameField[i][j];
                if(!gameObject.isMine){
                    List<GameObject> neighbors = getNeighbors(gameObject);
                    int countMine = 0;
                    for (GameObject neighbor : neighbors) {
                        countMine = neighbor.isMine ? countMine+1 : countMine;
                    }
                    gameObject.countMineNeighbors = countMine;
                }


            }
        }
    }

    private void openTile(int x, int y){

        GameObject gameObject = gameField[y][x];

        if(gameObject.isOpen) return;
        if(gameObject.isFlag) return;
        if(isGameStopped) return;
        gameObject.isOpen = true;
        if(gameObject.isMine) {
//            setCellValue(x, y, MINE);
//            setCellColor(x, y, COLOR_MINE);
            setCellValueEx(x,y, Color.RED, MINE);
            gameOver();
        }
        else {
            if(gameObject.countMineNeighbors==0){
                setCellValue(x, y, CELL);
                setCellColor(x, y, COLOR_NONEIGHBORMINE);
                List<GameObject> neighbors = getNeighbors(gameObject);
                for (GameObject neighbor: neighbors) {
                    if(!neighbor.isOpen & !neighbor.isMine ){
                        openTile(neighbor.x,neighbor.y);
                    }
                }
            }
            else {
                setCellNumber(x, y, gameObject.countMineNeighbors);
                setCellColor(x, y, COLOR_CLEARCELL);
            }
        }
         if(gameObject.isOpen && !gameObject.isMine) {
             score += 5; setScore(score);
         }

         if(gameObject.isOpen) countClosedTiles--;
         if(countClosedTiles == countMinesOnField && !gameObject.isMine) {
            win();
            return;
        }

    }
    private void markTile(int x, int y){
        GameObject gameObject = gameField[y][x];
        if(isGameStopped) return;
        if(gameObject.isOpen ) {return;}
        if(countFlags == 0 && !gameObject.isFlag) {return;}
        if (gameObject.isFlag){
            gameObject.isFlag = false;
            countFlags ++ ;
            setCellValue(x, y, "");
            setCellColor(x, y, COLOR_FIELD);
            return;
        }
        if(!gameObject.isFlag) {
            gameObject.isFlag = true;
            countFlags -- ;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, COLOR_FLAG);
        }
    }


}
