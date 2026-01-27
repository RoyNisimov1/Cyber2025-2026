package USAF;

public class Uav extends AirCraft{
    private int numOfCameras;
    public Uav(String id, int maxSpeed, int maxHeight){
        super(id, maxSpeed, maxHeight);
        this.numOfCameras = 0;
    }
    public void addCamera(int numOfCameras){
        this.numOfCameras += numOfCameras;
    }
    @Override
    public String toString(){
        return super.toString() + ", Num Of Cameras: " + this.numOfCameras;
    }
}
