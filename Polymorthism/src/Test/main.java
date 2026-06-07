package Test;

public class main {
    public static void main(String[] args){
        A a1 = new A();
        A a2 = new B();
        B b = new B();

        b = (B)a1;
        System.out.println(b.x);
    }
}
