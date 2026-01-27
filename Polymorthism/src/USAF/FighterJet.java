package USAF;

public class FighterJet extends AirCraft{
    private int maxBombsWeight;
    private boolean extraTank;
    public FighterJet(String id, int maxSpeed, int maxHeight, int
            maxBombsWeight){
        super(id, maxSpeed, maxHeight);
        this.maxBombsWeight = maxBombsWeight;
        this.extraTank = false;
    }
    public void addTank(){
        this.extraTank = true;
    }
    @Override
    public String toString(){
        return super.toString() + ", Max Bombs Weight: " + this.maxBombsWeight + ", Extra Tank: " + this.extraTank;
    }
}
