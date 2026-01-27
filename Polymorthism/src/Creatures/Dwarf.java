package Creatures;

public class Dwarf extends Creature {
    protected double height; //in cm

    public Dwarf(String name, boolean isBoy, double height){
        super(name, isBoy);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString(){
        return super.toString() + " height=" + this.height;
    }
}
