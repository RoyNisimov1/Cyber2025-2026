package USAF;

public class AirForce{
    private String airForceName;
    private AirCraft[] aircraft;
    private int numOfAirCrafts;
    private static int total;
    public AirForce(String name){
        this.aircraft = new AirCraft[10];
        this.airForceName = name;
        this.numOfAirCrafts = 0;
    }
    public void addAircraft(AirCraft a){
        this.aircraft[numOfAirCrafts] = a;
        this.numOfAirCrafts++;
        total++;
    }
    @Override
    public String toString(){
        String str = "\n";
        str += "Air Force Name: " + this.airForceName + "\nAircraft:\n";
        for (int i = 0; i < aircraft.length; i++)
        if (aircraft[i] != null)
            str += this.aircraft[i].toString() + "\n";
        str += "Num Of AirCrafts: " + this.numOfAirCrafts;
        return str;
    }
    public AirCraft[] getAirCraft(){
        return this.aircraft;
    }

    public AirCraft getAirCraft(int i){
        return this.aircraft[i];
    }
}
