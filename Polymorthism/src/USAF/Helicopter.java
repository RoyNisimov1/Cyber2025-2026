package USAF;

public class Helicopter extends AirCraft{
    protected int numOfStaffMembers;
    public Helicopter(String id, int maxSpeed, int maxHeight, int
            numOfStaffMembers){
        super(id, maxSpeed, maxHeight);
        this.numOfStaffMembers = numOfStaffMembers;
    }
    @Override
    public String toString(){
        return super.toString() + ", Num Of Staff Members: " + this.numOfStaffMembers;
    }
}
