package Creatures;

public class DwarfJumper extends Dwarf{

    public DwarfJumper(String name, boolean isBoy, double height){
        super(name, isBoy, height);
    }
    public DwarfJumper meet(DwarfJumper dwarfJumper){
        if(this.getHeight() <= dwarfJumper.getHeight()) return this;
        return dwarfJumper;
    }

}
