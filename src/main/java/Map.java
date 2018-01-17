import java.util.ArrayList;

public class Map {
    private int xMax;
    private int yMax;
    private Robot robot;
    private ArrayList<String> lostRobots;

    public Map(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
        this.robot = new Robot(0,0, "N");
        this.lostRobots = new ArrayList<>();
    }

    public void addLostRobot(String coordinates) {
        lostRobots.add(coordinates);
    }

    public ArrayList<String> getLostRobots() {
        return lostRobots;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }
}
