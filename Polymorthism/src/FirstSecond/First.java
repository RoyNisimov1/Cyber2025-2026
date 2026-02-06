package FirstSecond;

public class First{
    private static int count = 0;
    protected int x;
    protected int y;
    public First (int num) {
        this.x = num;
        this.y = num;
        count ++;
        System.out.println ("First 1");
    }
    public First (int num1, int num2) {
        this.x = num1;
        this.y = num2;
        count ++;
        System.out.println ("First 2");
    }
    public static int getCount() {
        return count;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int sum() {
        return this.x + this.y;
    }
    public void add(First other) {
        this.x += other.x;
        this.y += other.y;
        System.out.println("x = "+
                this.x + " y = "+ this.y);
    }
}
