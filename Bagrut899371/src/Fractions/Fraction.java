package Fractions;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public int findGCF(){
        return findGCF(this.numerator, this.denominator);
    }
    public static int findGCF(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return findGCF(b, a % b);
    }

    public Fraction copy(){
        return new Fraction(this.getNumerator(), this.getDenominator());
    }

    public void multiplyBy1(int mult){
        this.setNumerator(mult * this.getNumerator());
        this.setDenominator(mult * this.getDenominator());
    }

    public static Fraction add(Fraction a, Fraction b){
        a = a.copy();
        b = b.copy();
        int aDNum = a.getDenominator();
        a.multiplyBy1(b.getDenominator());
        b.multiplyBy1(aDNum);
        Fraction f = new Fraction(a.getNumerator() + b.getNumerator(), a.getDenominator());
        f.reduce();
        return f;
    }
    public static Fraction add3(Fraction a, Fraction b, Fraction c){
        return add(a, add(b, c));
    }

    public void reduce(){
        int gcd = this.findGCF();
        setNumerator(getNumerator() / gcd);
        setDenominator(getDenominator() / gcd);
    }

    @Override
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if(denominator < 0) {
            setNumerator(getNumerator() * -1);
            denominator *= -1;
        }
        this.denominator = denominator;
    }
}
