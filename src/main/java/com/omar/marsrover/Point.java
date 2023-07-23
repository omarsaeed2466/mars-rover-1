package com.omar.marsrover;

public class Point {
    private int location;
    private int maxLocation;

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getMaxLocation() {
        return maxLocation;
    }

    public void setMaxLocation(int maxLocation) {
        this.maxLocation = maxLocation;
    }

    public Point(int locationValue,int maxLocation) {

        setLocation(locationValue);
        setMaxLocation(maxLocation);
    }

    public int getForwardLocation(){
        return (getLocation()+1)%(getMaxLocation()+1);
    }



    public int getBackwardLocation() {
        if (getLocation()>0)
            return getLocation()-1 ;
        else return getMaxLocation();
    }
}
