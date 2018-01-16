import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RobotTest {
    Robot robot;

    @Before
    public void before() {
        robot = new Robot(0,0, "N");
    }

    @Test
    public void canGetRobotInfo() {
        assertEquals("N", robot.getOrientation());
        assertEquals(0, robot.getxPos());
        assertEquals(0, robot.getyPos());
    }

    @Test
    public void canTurnLeft() {
        robot.turnLeft();
        assertEquals("W", robot.getOrientation());
    }

    @Test
    public void canTurnRight() {
        robot.turnRight();
        assertEquals("E", robot.getOrientation());
    }

    @Test
    public void canMoveForwardFacingNorth() {
        robot.goForward();
        assertEquals(1, robot.getyPos());
        assertEquals(0, robot.getxPos());
    }

    @Test
    public void canMoveForwardFacingEast() {
        robot.turnRight();
        robot.goForward();
        assertEquals(0, robot.getyPos());
        assertEquals(1, robot.getxPos());
    }

    @Test
    public void canMoveForwardFacingSouth() {
        robot.turnRight();
        robot.turnRight();
        robot.goForward();
        assertEquals(-1, robot.getyPos());
        assertEquals(0, robot.getxPos());
    }

    @Test
    public void canMoveForwardFacingWest() {
        robot.turnLeft();
        robot.goForward();
        assertEquals(0, robot.getyPos());
        assertEquals(-1, robot.getxPos());
    }

    @Test
    public void robotCanActivate() {
        robot.activate("RRF");
        assertEquals(-1, robot.getyPos());
        assertEquals(0, robot.getxPos());
    }

    @Test
    public void robotCanGetPosition() {
        robot.activate("RRF");
        assertEquals("0 -1 S", robot.getPosition());
    }

    @Test
    public void robotCanGetLost() {
        robot.activate("RRF");
        robot.setLost(true);
        assertEquals("0 -1 S LOST", robot.getPosition());
    }
}
