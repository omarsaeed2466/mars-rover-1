package com.omar.marsrover;

import java.util.List;

public class Coordinates {
    private Point x ;
    private Point y;
             private Direction direction ;
    public List<Obstacle>obstacles ;
    private boolean foundObstacle = false;

    public Point getX() {
        return x;
    }

    public void setX(Point x) {
        this.x = x;
    }

    public Point getY() {
        return y;
    }

    public void setY(Point y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public Coordinates(Point xValue, Point yValue, Direction directionValue, List<Obstacle> obstaclesValue) {

        setX(xValue);
        setY(yValue);
        setDirection(directionValue);
        setObstacles(obstaclesValue);
    }


public boolean moveForward(){
        return move(direction);
}
public boolean moveBackward(){
        return move(direction.getBackwardDirection());
}



public void changeDirection(Direction directionValue,int directionStep){
        int directions = Direction.values().length;
        int index = (directions+directionValue.getValue()+directionStep)%directions ;
        direction =  Direction.values()[index];

}
public void changeDirectionLeft(){
changeDirection(direction,-1);

}
    public void changeDirectionRight() {
        changeDirection(direction, 1);
    }








    protected  boolean move(Direction directionValue){
        int xLocation = x.getLocation();
        int yLocation = y.getLocation();
        switch (directionValue){
            case NORTH:
                yLocation = y.getForwardLocation();
                break;
            case EAST:
                xLocation = x.getForwardLocation();
break;
            case SOUTH:
          yLocation =       y.getBackwardLocation();
          break;
            case WEST:
                xLocation = x.getBackwardLocation();
                break;
        }if (!hasObstacle(xLocation,yLocation)){
            x.setLocation(xLocation);
            y.setLocation(yLocation);
            return true;
        }else {
            return false;
        }
    }
    private boolean hasObstacle(int xLocation, int yLocation){
        for (Obstacle obstacle : obstacles){
            if (obstacle.getX()==xLocation && obstacle.getY()==yLocation){
                foundObstacle = true ;
                return true ;
            }
        }
        return false ;
    }

    @Override
    public String toString() {
        String status = "" ;
        if (foundObstacle){
            status = "OK" ;
        }
        return getX().getLocation()+ " X " + getY().getLocation() + " " + getDirection().getShortName() + status ;
    }
}
