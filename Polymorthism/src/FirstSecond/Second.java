package FirstSecond;

public class Second extends First{
    private int z;
    public Second (int num) {
        super (num);
        this.z = num;
        System.out.println ("Second");
    }
    public int sum() {
        return super.sum() + this.z;
    }
    public void add (First other) {
        this.x += other.getX();
        this.y += other.getY();
        if (other instanceof Second)
            this.z +=

                    ((Second)other).z;
        System.out.println("x = "+
                this.x + " y = "+ this.y+ " z = " + this.z);
    }
}
