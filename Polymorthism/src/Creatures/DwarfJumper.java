package Creatures;

public class DwarfJumper extends Dwarf{

    private int jumpHeight;

    public DwarfJumper(String name, boolean isBoy, double height, int jumpHeight){
        super(name, isBoy, height);
        this.jumpHeight = jumpHeight;
    }
    public DwarfJumper meet(DwarfJumper dwarfJumper){
        if(this.getHeight() <= dwarfJumper.getHeight()) return this;
        return dwarfJumper;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    @Override
    public String toString(){
        return super.toString() + " power=" + this.jumpHeight;
    }
}
