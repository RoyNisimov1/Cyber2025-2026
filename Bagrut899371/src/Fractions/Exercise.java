package Fractions;

public class Exercise {
    private Fraction frac1;
    private Fraction frac2;
    private Character action;


    public Exercise(Fraction frac1, Fraction frac2, Character action) {
        this.frac1 = frac1;
        this.frac2 = frac2;
        this.action = action;
    }

    public Fraction calc(){
        if(action != '+'){
            System.out.println("Not Supported");
            return null;
        }
        return Fraction.add(frac1, frac2);
    }

    public Fraction getFrac1() {
        return frac1;
    }

    public void setFrac1(Fraction frac1) {
        this.frac1 = frac1;
    }

    public Fraction getFrac2() {
        return frac2;
    }

    public void setFrac2(Fraction frac2) {
        this.frac2 = frac2;
    }

    public Character getAction() {
        return action;
    }

    public void setAction(Character action) {
        this.action = action;
    }
}
