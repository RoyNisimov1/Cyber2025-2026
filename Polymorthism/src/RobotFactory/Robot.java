package RobotFactory;

public class Robot {

    protected String id;

    public Robot(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }
    @Override
    public String toString() {
        return "ID=" + this.id;
    }
}

