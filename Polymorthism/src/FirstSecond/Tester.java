package FirstSecond;

public class Tester
{
    public static void main(String[] args)
    {
        First f1 = new First (40);
        First f2 = new First (40, 50);
        First f3 = new Second (100);
        Second s1 = new Second (100);
        Second s2 = new Second (100);
        System.out.println ("Total = " + First.getCount());
        System.out.println ("Total = " + Second.getCount());
        System.out.println ("sum = " + s1.sum());
        System.out.println ("sum = " + f3.sum());
        //s1=new First (100);
        f1.add (s2);
        s1.add (s2);
        s2.add (f3);
        ((First)s1).add (f1);
        //s1=new Second (100, 100);
    }
}
