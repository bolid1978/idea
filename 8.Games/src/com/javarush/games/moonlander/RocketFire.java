package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

import java.util.List;

public class RocketFire extends GameObject{
   

    public RocketFire( List<int[][]> frameList) {
        super(0, 0, frameList.get(0));
        this.frames = frameList;
        frameIndex = 0;
        isVisible = false;
    }

    private List<int[][]> frames;
    private int  frameIndex;
    private boolean  isVisible;

    private void nextFrame(){
        frameIndex++;
        if(frameIndex >= frames.size()) frameIndex = 0;
        matrix = frames.get(frameIndex) ;
    }

    @Override
    public void draw(Game game) {
         if(isVisible == false) return;
        nextFrame();
        super.draw(game);
    }

    public void show(){
        isVisible =  true;
    }

    public void hide(){
        isVisible = false;
    }


}
