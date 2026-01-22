package Creatures;

public class Creature {

    protected String name;
    protected boolean isBoy;

    public Creature(String name, boolean isBoy){
        this.name = name;
        this.isBoy = isBoy;
    }
    public boolean canMatch(Creature creature){
        return creature.isBoy != this.isBoy;
    }

}
