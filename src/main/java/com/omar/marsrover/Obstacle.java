package com.omar.marsrover;

public class Obstacle {
    private int x ;
    private int y ;


    public Obstacle(final int xValue, final int yValue) {
       setX(xValue);
       setY(yValue);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
