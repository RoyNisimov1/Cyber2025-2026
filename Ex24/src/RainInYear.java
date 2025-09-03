import java.util.ArrayList;

public class RainInYear {
    private int[] yearlyRain = new int[365];
    private String stationName;
    public RainInYear(String stationName, int[] yearlyRain){
        this.stationName = stationName;
        this.yearlyRain = yearlyRain;
    }

    public double rainAv(){
        double s = 0;
        for (int i = 0; i < 365; i++) {
            s+=getYearlyRain()[i];
        }
        return s/365;
    }
    public int daysAboveRainAverageNum(){
        double av = rainAv();
        int n = 0;
        for (int i = 0; i < 365; i++) {
            if (getYearlyRain()[i] > av) n++;
        }
        return n;
    }
    public int noRainNum(){
        int n = 0;
        for (int i = 0; i < 365; i++) {
            if (getYearlyRain()[i] == 0) n++;
        }
        return n;
    }

    public int numberOfRainyPeriods(){
        int n = 0;
        for (int i = 0; i < 365; i++) {
            if (i >= 362) break;
            if (getYearlyRain()[i] != 0 && getYearlyRain()[i+1] != 0 && getYearlyRain()[i+2] != 0) n++;
        }
        return n;
    }
    public int[] rainiestDay(){
        ArrayList<Integer> candidatesIndex = new ArrayList<>();
        candidatesIndex.add(0);
        int candidate = getYearlyRain()[0];
        for (int i = 0; i < 365; i++) {
            if (i != 0 && getYearlyRain()[i]==candidate){
                candidatesIndex.add(i);
            }
            if (getYearlyRain()[i]>candidate){
                candidatesIndex.clear();
                candidatesIndex.add(i);
                candidate = getYearlyRain()[i];
            }

        }
        int[] retArr = new int[candidatesIndex.size() + 1];
        for (int i = 0; i < candidatesIndex.size(); i++) {
            retArr[i] = candidatesIndex.get(i);
        }
        retArr[retArr.length-1] = candidate;
        return retArr;
    }

    public int totalWater(){
        int n = 0;
        for (int i = 0; i < 365; i++) {
            n+=getYearlyRain()[i];
        }
        return n;
    }

    public boolean isDryYear(){
        return (rainAv()*0.55 <= (double)totalWater()); // 55% of average is dry year according to google
    }

    public int[] getYearlyRain() {
        return yearlyRain;
    }

    public void setYearlyRain(int[] yearlyRain) {
        this.yearlyRain = yearlyRain;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
