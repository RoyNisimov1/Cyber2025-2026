package Creatures;

public class WizardProgrammer extends Wizard{
    private boolean codesInJava;
    public WizardProgrammer(String name, boolean isBoy, int power, boolean codesInJava){
        super(name, isBoy, power);
        this.codesInJava = codesInJava;
    }

    public boolean isCodesInJava() {
        return codesInJava;
    }

    public void setCodesInJava(boolean codesInJava) {
        this.codesInJava = codesInJava;
    }
}
