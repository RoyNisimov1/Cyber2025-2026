package Creatures;

public class Main {
    public static void main(String[] args){
        Creature[] cArr = new Creature[4];
        cArr[0] = new WizardProgrammer("One", true, 100,true);
        cArr[1] = new Wizard("Two", true, 80);
        cArr[2] = new Dwarf("Three", false, 120);
        cArr[3] = new DwarfJumper("Four", true, 170, 210);
        for(Creature c : cArr){
            if(c.isBoy) System.out.println(c);
        }
        System.out.println("---------------------------------------------");
        for(Creature c : cArr){
            System.out.println(c);
        }
        System.out.println("---------------------------------------------");

        Creature c = cArr[1];
        System.out.println(c);
        System.out.println(cArr[1]);
        System.out.println("---------------------------------------------");

        Wizard w1 = (Wizard)c;
        w1.setPower(90);
        System.out.println(c);
        System.out.println(cArr[1]);
        System.out.println(w1);
        System.out.println("---------------------------------------------");
        Creature c1 = new Creature("Five", true);
        Wizard w2 = (Wizard)c1;
        System.out.println(w2);
    }
}
