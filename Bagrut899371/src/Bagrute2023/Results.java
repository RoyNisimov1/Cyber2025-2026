package Bagrute2023;

public class Results {
    private int[] arr;
    private String name;

    public static void main(String[] args){
        int[] arr = {45, 52, 50, 53, 38, 38, 42};
        Results r = new Results(arr, "Test");
        System.out.println(r.deltas(true));
        System.out.println(r.deltas(false));
        System.out.println(r.improving());
    }

    public Results(int[] arr, String name) {
        this.arr = arr;
        this.name = name;
    }

    public int deltas(boolean isLonger){
        int s = 0;
        if(isLonger){
            for (int i = 0; i < this.arr.length - 1; i++) {
                if((arr[i+1] - arr[i]) > 0) s+=(arr[i+1] - arr[i]);
            }
        }else {
            for (int i = 0; i < this.arr.length - 1; i++) {
                if((arr[i+1] - arr[i]) < 0) s+=(arr[i+1] - arr[i])*-1;
            }
        }
        return s;
    }

    public boolean improving(){
        return this.deltas(false) - this.deltas(true) > 0;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
