package omar.marsrover;

import com.omar.marsrover.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
public class RoverSpace {


   private Rover rover ;
    private Coordinates roverCoordinates ;
    private final Direction direction = Direction.EAST ;
    private Point x;
    private Point y;
    private List<Obstacle> obstacles;

    @Before
    public void beforeRoverTest() {
        x = new Point(1, 9);
        y = new Point(2, 9);
        obstacles = new ArrayList<>();
        roverCoordinates = new Coordinates(x, y, direction, obstacles);
        rover = new Rover(roverCoordinates);
    }
@Test
    public void TheNewInstanceMustEstablishCoordinatesAndDirectionOfRover(){
    assertThat(rover.getCoordinates()).isEqualToComparingFieldByField(roverCoordinates);
    }

    @Test
    public void receiveSingleCommandShouldMoveForwardWhenCommandIsF() throws Exception {
        int expected = y.getLocation() + 1;
        rover.receiveSingleCommands('F');
        assertThat(rover.getCoordinates().getY().getLocation()).isEqualTo(expected);
    }

    @Test
    public void receiveSingleCommandShouldMoveBackwardWhenCommandIsB() throws Exception {
        int expected = y.getLocation() - 1;
        rover.receiveSingleCommands('B');
        assertThat(rover.getCoordinates().getY().getLocation()).isEqualTo(expected);
    }

    @Test
    public void receiveSingleCommandShouldTurnLeftWhenCommandIsL() throws Exception {
        rover.receiveSingleCommands('L');
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void receiveSingleCommandShouldTurnRightWhenCommandIsR() throws Exception {
        rover.receiveSingleCommands('R');
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void receiveSingleCommandShouldIgnoreCase() throws Exception {
        rover.receiveSingleCommands('r');
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
    }

    @Test(expected = Exception.class)
    public void receiveSingleCommandShouldThrowExceptionWhenCommandIsUnknown() throws Exception {
        rover.receiveSingleCommands('X');
    }

    @Test
    public void receiveCommandsShouldBeAbleToReceiveMultipleCommands() throws Exception {
        int expected = x.getLocation() + 1;
        rover.receiveCommands("RFR");
        assertThat(rover.getCoordinates().getX().getLocation()).isEqualTo(expected);
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void receiveCommandShouldWhatFromOneEdgeOfTheGridToAnother() throws Exception {
        int expected = x.getMaxLocation() + x.getLocation() - 2;
        rover.receiveCommands("LFFF");
        assertThat(rover.getCoordinates().getX().getLocation()).isEqualTo(expected);
    }

    @Test
    public void receiveCommandsShouldStopWhenObstacleIsFound() throws Exception {
        int expected = x.getLocation() + 1;
        rover.getCoordinates().setObstacles(Arrays.asList(new Obstacle(expected + 1, y.getLocation())));
        rover.getCoordinates().setDirection(Direction.EAST);
        rover.receiveCommands("FFFRF");
        assertThat(rover.getCoordinates().getX().getLocation()).isEqualTo(expected);
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void positionShouldReturnXYAndDirection() throws Exception {
        rover.receiveCommands("LFFFRFF");
        assertThat(rover.getPosition()).isEqualTo("8 X 4 N");
    }

    @Test
    public void positionShouldReturnNokWhenObstacleIsFound() throws Exception {
        rover.getCoordinates().setObstacles(Arrays.asList(new Obstacle(x.getLocation() + 1, y.getLocation())));
        rover.getCoordinates().setDirection(Direction.EAST);
        rover.receiveCommands("F");
        assertThat(rover.getPosition()).endsWith(" NOK");
    }
}
