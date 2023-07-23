package com.omar.marsrover;

public class Rover {
    private Coordinates coordinates ;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }




    public Rover(Coordinates coordinatesValue) {
        setCoordinates(coordinatesValue);
    }


public void receiveCommands(String commands) throws Exception {
for (char command :commands.toCharArray()){
    if (!receiveSingleCommands(command)){
        break;
    }
}





}


    public boolean receiveSingleCommands(char commands)throws Exception{
switch (Character.toUpperCase(commands)){
    case 'F':
        return getCoordinates().moveForward();

    case 'B':
        return getCoordinates().moveBackward();

    case 'L':
        getCoordinates().changeDirectionLeft();
        return true;
    case 'R':
        getCoordinates().changeDirectionRight();
        return true;
    default:
        throw new Exception("Command " + commands + " is unknown.");

}
    }


    public String getPosition(){
        return getCoordinates().toString();
    }
}
