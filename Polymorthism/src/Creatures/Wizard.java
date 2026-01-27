package Creatures;

public class Wizard extends Creature {
    protected int power;

    public Wizard(String name, boolean isBoy, int power){
        super(name, isBoy);
        this.setPower(power);
    }

    public Wizard meet(Wizard wizard){
        if(this.power >= wizard.power) return this;
        return wizard;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
//        if (power<1) power = 1;
//        if (power>10) power = 10;
        this.power = power;
    }

    @Override
    public String toString(){
        return super.toString() + " power=" + this.power;
    }
}
