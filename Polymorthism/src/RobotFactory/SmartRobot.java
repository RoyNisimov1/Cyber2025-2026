package RobotFactory;

public class SmartRobot extends Robot {

    private boolean aiEnabled;

    public SmartRobot(String id, boolean aiEnabled) {
        super(id);
        this.aiEnabled = aiEnabled;
    }
    public boolean isAiEnabled() {
        return this.aiEnabled;
    }
    public void disableAi() {
        this.aiEnabled = false;
    }
    @Override
    public String toString() {
        return super.toString() + ", AI enabled = " + this.aiEnabled;
    }
}

