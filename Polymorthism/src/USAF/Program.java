package USAF;

public class Program {


    public static void main(String[] args){
        AirForce USAF = new AirForce("USAF");
        USAF.addAircraft(new FighterJet("FJ", 1, 1, 1));
        USAF.addAircraft(new FighterJet("FJ2", 2, 2, 2));
        USAF.addAircraft(new Helicopter("H", 2, 2, 2));
        USAF.addAircraft(new HelicopterGunship("HC", 2, 2, 2, 10));
        USAF.addAircraft(new HelicopterGunship("HC2", 3, 2, 2, 10));
        USAF.addAircraft(new Uav("UAV", 3, 2));

        AirForce IAF = new AirForce("IAF");
        IAF.addAircraft(new FighterJet("FJ", 1, 1, 1));
        IAF.addAircraft(new FighterJet("FJ2", 1, 1, 1));
        IAF.addAircraft(new FighterJet("FJ3", 1, 1, 1));
        IAF.addAircraft(new HelicopterGunship("FJ3", 1, 1, 1, 100));
        IAF.addAircraft(new Uav("UAV", 3, 2));
        IAF.addAircraft(new Uav("UAV2", 3, 2));
        IAF.addAircraft(new Uav("UAV3", 3, 2));

        AirCraft[] airCrafts = IAF.getAirCraft();
        for (int i = 0; i < airCrafts.length; i++) {
            if(airCrafts[i] instanceof HelicopterGunship) ((HelicopterGunship) airCrafts[i]).addMissile(3);
        }
        airCrafts = USAF.getAirCraft();
        for (int i = 0; i < airCrafts.length; i++) {
            if(airCrafts[i] instanceof FighterJet) ((FighterJet) airCrafts[i]).addTank();
        }

        System.out.println(report(USAF, IAF));

    }

    public static String report(AirForce USAF, AirForce IAF){
        int numOfFJ = 0;
        int numOfH = 0;
        int numOfHG = 0;
        int numOfUAV = 0;
        AirCraft[] usafAC = USAF.getAirCraft();
        AirCraft[] iafAC = IAF.getAirCraft();
        for (AirCraft ac: usafAC) {
            if(ac instanceof FighterJet) numOfFJ++;
            if(ac instanceof Helicopter) numOfH++;
            if(ac instanceof HelicopterGunship) numOfHG++;
            if(ac instanceof Uav) numOfUAV++;
        }
        for (AirCraft ac: iafAC) {
            if(ac instanceof FighterJet) numOfFJ++;
            if(ac instanceof Helicopter) numOfH++;
            if(ac instanceof HelicopterGunship) numOfHG++;
            if(ac instanceof Uav) numOfUAV++;

        }
        return "Number of Fighter Jets: " + numOfFJ + "\nNumber of Helies:"  + numOfH + "\nNumber of HeliesGuns:"  + numOfHG + "\nNumber of UAVs:"  + numOfUAV;
    }
}
