package USAF;

public class HelicopterGunship extends Helicopter{
    private int numOfMissiles;
    public HelicopterGunship(String id, int maxSpeed, int maxHeight, int
            numOfStaffMembers, int numOfMissiles){
        super(id, maxSpeed, maxHeight, numOfStaffMembers);
        this.numOfMissiles = 0;
    }
    public void addMissile(int numOfMissiles){
        this.numOfMissiles += numOfMissiles;
    }
    @Override
    public String toString() {
        return super.toString() + ", Num Of Missiles: " +
                this.numOfMissiles;
    }
}
