package Fractions;

public class Main {
    public static void main(String[] args){
        Fraction f1 = new Fraction(2, 4);
        Fraction f2 = new Fraction(1, 4);
        f1.reduce();
        Fraction f1Copy = f1.copy();
        System.out.println(Fraction.add3(f1, f2, f1Copy));
        Exercise ex = new Exercise(f1, f2, '+');
        System.out.println(ex.calc());
        Exercise ex1 = new Exercise(f1, f2, '*');
        System.out.println(ex1.calc());
    }
}
