package Bagrute2024;

public class TourPackage {
    private int id;
    private int price;
    private int maxTime;
    private int maxData;
    private int extra;


    public TourPackage(int id, int price, int maxTime, int maxData) {
        this.id = id;
        this.price = price;
        this.maxTime = maxTime;
        this.maxData = maxData;
        this.extra = 0;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }
    public void setExtra(int minutes, int usage) {
        this.extra = 0;
        if (minutes > maxTime) extra += maxTime - minutes;
        if (usage > maxData) extra += (maxTime - minutes) * 2;
    }

    public int getMaxData() {
        return maxData;
    }

    public void setMaxData(int maxData) {
        this.maxData = maxData;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public static int calculate(TourPackage[] packages){
        int n = 0;
        for (int i = 0; i < packages.length; i++) {
            if(packages[i].getExtra() > 0) n++;
        }
        return n;
    }
    public static int[] customers(TourPackage[] packages){
        int[] ids = new int[calculate(packages)];
        int j = 0;
        for (int i = 0; i < packages.length; i++) {
            if(packages[i].getExtra() > 0){
                ids[j] = packages[i].getId();
                j++;
            }
        }
        return ids;
    }


}
