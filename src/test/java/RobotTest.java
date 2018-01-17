import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RobotTest {
    Robot robot;
    Map map;

    @Before
    public void before() {
        robot = new Robot(0,0, "N");
        map = new Map(5, 3);
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
        robot.activate("RRF", map);
        assertEquals(-1, robot.getyPos());
        assertEquals(0, robot.getxPos());
    }

    @Test
    public void robotCanGetPosition() {
        robot.activate("RRF", map);
        assertEquals("0 -1 S", robot.getPosition());
    }

    @Test
    public void robotCanGetLost() {
        robot.activate("FFFF", map);
        assertEquals("0 3 N LOST", robot.getPosition());
    }

    @Test
    public void mapOneInputTest() {
        Robot robotOne = new Robot(1, 1, "E");
        Robot robotTwo = new Robot(3, 2, "N");
        Robot robotThree = new Robot(0, 3, "W");
        robotOne.activate("RFRFRFRF", map);
        robotTwo.activate("FRRFLLFFRRFLL", map);
        robotThree.activate("LLFFFLFLFL", map);
        assertEquals("1 1 E", robotOne.getPosition());
        assertEquals("3 3 N LOST", robotTwo.getPosition());
        assertEquals("2 3 S", robotThree.getPosition());
    }
}
