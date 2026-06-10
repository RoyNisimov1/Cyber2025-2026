package Bagrute2023;

public class Transport {
    private String name;
    private boolean toSchool;
    private int num;
    private int day;

    public Transport(String name, int num, int day) {
        this.name = name;
        this.num = num;
        this.day = day;
        this.toSchool = true;

    }

    public Transport(int num){
        this.num = 1;
        setNum(num);
        this.toSchool = false;
        this.name = "Aviv";
        this.day = 4;

    }

    public static int dayReport(Transport[] arr, int day, boolean forward){
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getDay() == day && arr[i].isToSchool() == forward) s += arr[i].num;
        }
        return s;
    }

    public static void moreForward(Transport[] arr){
        for (int i = 1; i < 7; i++) {
            if(dayReport(arr, i, true) > dayReport(arr, i, false)) System.out.println(i);
        }
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isToSchool() {
        return toSchool;
    }

    public void setToSchool(boolean toSchool) {
        this.toSchool = toSchool;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        if (num < 1) num = 1;
        if (num > 50) num = 50;
        this.num = num;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1) day = 1;
        if (day > 6) day = 6;
        this.day = day;
    }
}
