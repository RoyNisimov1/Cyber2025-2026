import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] y1 = new int[365];
        int[] y2 = new int[365];
        String rsY1Name = "Year 1";
        String rsY2Name = "Year 2";
        RainInYear rsY1 = new RainInYear(rsY1Name, y1);
        RainInYear rsY2 = new RainInYear(rsY2Name, y2);
        double y1Av = rsY1.rainAv();
        double y2Av = rsY2.rainAv();
        System.out.println("Station with smallest average:");
        if (y1Av < y2Av){
            System.out.println(rsY1Name);
        } else {
            System.out.println(rsY2Name);
        }
        int[] y1Rainiest = rsY1.rainiestDay();
        int[] y2Rainiest = rsY2.rainiestDay();
        System.out.println("Rainiest days y1" + Arrays.toString(y1Rainiest));
        System.out.println("Rainiest days y2" + Arrays.toString(y2Rainiest));

        int rainPeriodsY1 = rsY1.numberOfRainyPeriods();
        int rainPeriodsY2 = rsY2.numberOfRainyPeriods();
        System.out.println("Station with largest rain periods:");

        if (rainPeriodsY1 > rainPeriodsY2){
            System.out.println(rsY1Name);
        } else if (rainPeriodsY1 < rainPeriodsY2){
            System.out.println(rsY2Name);
        }else System.out.println("Both are the same");

        System.out.println("Station with largest average:");
        if (rsY1.isDryYear()) System.out.println(rsY1Name+" station had a dry year");
        if (rsY2.isDryYear()) System.out.println(rsY2Name+" station had a dry year");
    }
}