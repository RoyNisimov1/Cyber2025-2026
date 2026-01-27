package USAF;

public class AirCraft{
    protected String id;
    protected int maxSpeed;
    protected int maxHeight;
    public AirCraft(String id, int maxSpeed, int maxHeight){
        this.id = id;
        this.maxSpeed = maxSpeed;
        this.maxHeight = maxHeight;
    }
    @Override
    public String toString(){
        return "ID: " + this.id + ", Max Speed: " + this.maxSpeed + ", Max Height: " + this.maxHeight;
    }
}
