package RobotFactory;

public class Factory {

    private String name;
    private Robot[] robots;
    public static int robotsCount;

    public Factory(String name) {
        this.name = name;
        this.robots = new Robot[1000];
        Factory.robotsCount = 0;
    }
    // Adds a robot to the factory
    public void addRobot(Robot robot) {
        if (robotsCount < 1000) {
            this.robots[robotsCount++] = robot;
        }
    }
    public void disableAllAi(){
        for (Robot r : this.robots){
            if(r instanceof SmartRobot) ((SmartRobot) r).disableAi();
        }
    }
    public Robot[] getRobots() {
        return this.robots;
    }

    @Override
    public String toString(){
        String s = this.name + "\n";
        for (int i = 0; i < robotsCount; i++) {
            s+=robots[i].toString() + "\n";
        }
        return s+"\nThe number of robots is: " + robotsCount;
    }
}

