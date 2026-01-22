package Creatures;

public class Main {
    public static void main(String[] args){
        Wizard wizardBoy = new Wizard("Adam", true, 6);
        Wizard wizardGirl = new Wizard("Eve", false, 7);
        Wizard wizardWinner = wizardBoy.meet(wizardGirl);
        System.out.println("The winning wizard's name is: " + wizardWinner.name);
        DwarfJumper dwarfJumperBoy = new DwarfJumper("Shmebulock", true, 45);
        DwarfJumper dwarfJumperGirl = new DwarfJumper("Dwarfit", false, 50);
        DwarfJumper dwarfJumperWinner = dwarfJumperBoy.meet(dwarfJumperGirl);
        System.out.println("The winning dwarf jumper's name is: " + dwarfJumperWinner.name);

        System.out.println("Can match between winners?: " + dwarfJumperWinner.canMatch(wizardWinner));

    }
}
