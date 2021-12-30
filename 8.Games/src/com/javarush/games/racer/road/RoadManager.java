package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoadManager {
     public final static int  LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
     public final static int  RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
     private final static int  FIRST_LANE_POSITION = 16;
     private final static int  FOURTH_LANE_POSITION = 44;
     private final static int  PLAYER_CAR_DISTANCE = 12;

     private int passedCarsCount = 0;

    public int getPassedCarsCount() {
        return passedCarsCount;
    }

    private List<RoadObject> items = new ArrayList<>();



     private void addRoadObject(RoadObjectType type, Game game){

         int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
         int y = -1 * RoadObject.getHeight(type);

         RoadObject roadObject = createRoadObject(type, x, y);
         if(isRoadSpaceFree(roadObject)) items.add(roadObject);


     }



    private RoadObject createRoadObject(RoadObjectType type, int x, int y){
         if(type ==  RoadObjectType.DRUNK_CAR) return new MovingCar(x,y);
         if(type == RoadObjectType.THORN) return new Thorn(x,y);else return new Car(type, x, y);
    }

    public void draw(Game game){
         for(RoadObject el:items){
             el.draw(game);
         }
    }

    public void move(int boost){

        for(RoadObject el:items){
            el.move(boost + el.speed,items);
        }
        deletePassedItems();
    }

    private boolean isThornExists(){
         boolean tr = false;
        for(RoadObject el:items){
            if(el instanceof Thorn) tr = true;
        }
        return tr;
    }

    private void generateThorn(Game game){
         int randomNumber = game.getRandomNumber(100);
         if(randomNumber < 10 && !isThornExists()) addRoadObject(RoadObjectType.THORN,game);
    }

    public void generateNewRoadObjects(Game game){
        generateMovingCar(game);
        generateThorn(game);
        generateRegularCar(game);
    }

    private void deletePassedItems(){
        Iterator iterator = items.iterator();

        while(iterator.hasNext()){
            RoadObject roadObject = (RoadObject) iterator.next();
            if(roadObject.y >= RacerGame.HEIGHT) {
                if(!(roadObject instanceof Thorn)) passedCarsCount ++ ;
                iterator.remove();
            }
        }

         }

    public boolean checkCrush(PlayerCar playerCar){
        boolean checkPlaer = false;
         for (RoadObject el:items){
             if(el.isCollision(playerCar)) checkPlaer = true;
         }
         return checkPlaer;
    }

    private void generateRegularCar(Game game){
         int carTypeNumber = game.getRandomNumber(4);
         if(game.getRandomNumber(100) < 30) addRoadObject(RoadObjectType.values()[carTypeNumber], game);
    }

    private boolean  isRoadSpaceFree(RoadObject object){
          boolean is = true;
         for (RoadObject el:items){
             if(el.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)) is = false;
         }
         return is;
    }

    private boolean   isMovingCarExists(){
         boolean is = false;
         for (RoadObject el:items){
             if(el instanceof MovingCar) is = true;
         }
         return is;
    }

    private void generateMovingCar(Game game ){
         if(game.getRandomNumber(100) < 10 && !isMovingCarExists())  addRoadObject(RoadObjectType.DRUNK_CAR, game);
    }



}
