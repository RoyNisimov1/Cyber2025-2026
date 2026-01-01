package Queues.QueuesWithObjects;

public class Patient {
    private int id;
    private int priority;
    public Patient(int id, int priority){
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Patient {id= " + this.getId() + ", priority=" + this.getPriority() + "}";
    }
}
