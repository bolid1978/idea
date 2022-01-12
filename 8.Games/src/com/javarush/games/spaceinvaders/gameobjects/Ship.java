package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class Ship extends GameObject{

    public boolean isAlive = true;
    private List<int[][]> frames;
    private int frameIndex ;
    private  boolean loopAnimation =  false;


    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame){
        super.setMatrix(viewFrame);
        frames = new ArrayList<int[][]>();
        frames.add(viewFrame);
        frameIndex = 0 ;
    }

    public Bullet fire(){
        return null;
    }

    public void kill()
    {
        isAlive = false;
    }

/*    public void setAnimatedView(int[][]... viewFrames){
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;

        super.setMatrix(viewFrames[0]);
    }*/

    public  void nextFrame(){


        frameIndex ++;
        if(frameIndex > frames.size() && loopAnimation == false) return;
        if(frameIndex >= frames.size() && loopAnimation == true) {frameIndex = 0;}
        if(frameIndex >= frames.size()) return;
        matrix = frames.get(frameIndex);
    }

    public boolean isVisible(){
        return (!isAlive && frameIndex >= frames.size()) ? false:true;
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames){
        loopAnimation = isLoopAnimation;
    }

    @Override
    public void draw(Game game) {
       super.draw(game);
        nextFrame();
    }
}
