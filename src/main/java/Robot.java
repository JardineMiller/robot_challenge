public class Robot {
    private int xPos;
    private int yPos;
    private String position;
    private String orientation;
    private String lastValidPosition;
    private boolean lost;

    public Robot(int xPos, int yPos, String orientation) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.orientation = orientation;
        this.lost = false;
        this.position = null;
        this.lastValidPosition = null;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public boolean isLost() {
        return lost;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public String getOrientation() {
        return orientation;
    }

    public String getPosition() {
        if(this.isLost()){
            return getLastValidPosition() + " LOST";
        } else {
            return getxPos() + " " + getyPos() + " " + getOrientation();
        }

    }

    public boolean isValidPosition(Map map) {
        if (this.xPos >= 0 &&
            this.yPos >= 0 &&
            this.xPos <= map.getxMax() &&
            this.yPos <= map.getyMax() ) {
            return true;
        } else {
            return false;
        }
    }

    public void validatePosition(Map map) {
        if(isValidPosition(map)){
            setLastValidPosition(this.getPosition());
        } else {
            setLost(true);
            if (!map.getLostRobots().contains(getLastValidPosition())) {
                map.addLostRobot(getLastValidPosition());
            }
        }
    }

    public void setLastValidPosition(String lastValidPosition) {
        this.lastValidPosition = lastValidPosition;
    }

    public String getLastValidPosition() {
        return lastValidPosition;
    }

    public void activate(String instructions, Map map) {
        String[] instructionsArray = instructions.split("(?!^)");
            for (String instruction : instructionsArray) {
                validatePosition(map);
                if (isValidPosition(map)) {
                    switch (instruction) {
                        case "L":
                            turnLeft();
                            break;
                        case "R":
                            turnRight();
                            break;
                        case "F":
                            goForward();
                            break;
                        default:
                            System.out.println("Invalid instruction");
                            break;
                    }
                }
            }
    }

    public void turnLeft() {
        switch(this.orientation){
            case "N":
                this.orientation = "W";
                break;
            case "E":
                this.orientation = "N";
                break;
            case "S":
                this.orientation = "E";
                break;
            case "W":
                this.orientation = "S";
                break;
            default:
                break;
        }
    }

    public void turnRight() {
        switch(this.orientation){
            case "N":
                this.orientation = "E";
                break;
            case "E":
                this.orientation = "S";
                break;
            case "S":
                this.orientation = "W";
                break;
            case "W":
                this.orientation = "N";
                break;
            default:
                break;
        }
    }

    public void goForward() {
        switch(this.orientation){
            case "N":
                this.yPos += 1;
                break;
            case "E":
                this.xPos += 1;
                break;
            case "S":
                this.yPos -= 1;
                break;
            case "W":
                this.xPos -= 1;
                break;
            default:
                break;
        }
    }
}
