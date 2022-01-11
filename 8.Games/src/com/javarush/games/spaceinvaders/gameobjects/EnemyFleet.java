package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyFleet {
     private static final  int ROWS_COUNT = 3;
     private static final  int COLUMNS_COUNT = 10;
     private static final  int STEP = ShapeMatrix.ENEMY.length + 1;
     private List<EnemyShip> ships;
     private Direction direction = Direction.RIGHT;

     public EnemyFleet(){
          createShips();
     }

     private void createShips(){
         ships =  new ArrayList<EnemyShip>();
          for (int i = 0; i < COLUMNS_COUNT; i++) {
               for (int j = 0; j < ROWS_COUNT; j++) {
                    ships.add(new EnemyShip(i*STEP,j*STEP +12));
               }
          }
     }

     public void draw(Game game){
          for (EnemyShip el:ships){
               el.draw(game);
          }

     }

     private double getLeftBorder(){
         double min = 64;
          for (EnemyShip el: ships){
               if(el.x < min) min = el.x;
          }
          return  min;
     }

     private double getRightBorder(){
          double max = 0;
          for (EnemyShip el: ships){
               if(el.x + el.width > max) max  = el.x + el.width ;
          }
          return  max;
     }

     private double getSpeed(){

       if(3.0/ships.size() < 2.0) return  3.0/ships.size();else return 2.0;
     }

     public void move(){
         if(ships.isEmpty()) return;
         double reseltGetSpeed = getSpeed();

         if(direction == Direction.LEFT && getLeftBorder() < 0) {
             direction = Direction.RIGHT;
             //moveShips(Direction.DOWN, reseltGetSpeed);
             for (EnemyShip el:ships){
                 el.move(Direction.DOWN, reseltGetSpeed);
             }
             return;}
         if(direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
             direction = Direction.LEFT;
           //  moveShips(Direction.DOWN, reseltGetSpeed);
             for (EnemyShip el:ships){
                 el.move(Direction.DOWN, reseltGetSpeed);
             }
             return;}
         for (EnemyShip el:ships){
             el.move(direction, reseltGetSpeed);
         }

     }

     public Bullet fire(Game game){
         if(ships.isEmpty()) return null;
         if(game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0) return null;
         int index = game.getRandomNumber(ships.size());
         return ships.get(index).fire();

     }

     public void verifyHit(List<Bullet> bullets){
         for (Ship el:ships){
             for (Bullet element:bullets){
                 if(el.isCollision(element) && el.isAlive && element.isAlive){
                     el.kill();
                     element.kill();
                 }
             }
         }
     }

     public void deleteHiddenShips(){
         Iterator iterator = ships.iterator();
         while (iterator.hasNext()){
             Ship ship = (Ship) iterator.next();
             if(ship.isVisible() == false) iterator.remove();
         }
     }

}
