package Bagrute2025;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] arr = {7, -2, -5, 61, 4, -1, 0, 33};
        arrange(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(isNarc(407));
        System.out.println(isNarc(58));
        theNarc(407);
        int[] friends1 = {2, 3, 4, 5};
        int[] friends2 = {1, 3, 4};
        User u = new User("U", 1, friends1);
        User u1 = new User("U1", 2, friends2);
        System.out.println(u.mutual(u1));
        System.out.println(u1.mutual(u));
        System.out.println(isPerfect(6));
        System.out.println(isPerfect(8));
        thePerfects(4, 10);
        System.out.println(noOdd());
    }

    public static void arrange(int[] arr){
        int[] arrPos = new int[arr.length];
        int[] arrNeg = new int[arr.length];
        int p = 0;
        int n = 0;
        for (int j : arr) {
            if (j >= 0) {
                arrPos[p] = j;
                p++;
            } else {
                arrNeg[n] = j;
                n++;
            }
        }
        int j = 0;
        for (int i = 0; i < p; i++) {
            arr[j] = arrPos[i];
            j++;
        }
        for (int i = 0; i < n; i++) {
            arr[j] = arrNeg[i];
            j++;
        }
    }

    public static boolean isNarc(int num){
        if(num <=0) return false;
        String s = Integer.toString(num);
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum += (int) Math.pow((s.charAt(i) - '0'), s.length());
        }
        return sum == num;
    }

    public static void theNarc(int num){
        for (int i = 1; i < num+1; i++) {
            if(isNarc(i)) System.out.println(i);
        }
    }

    public static boolean isPerfect(int num){
        int s = 0;
        for (int i = 1; i < num; i++) {
            if(num % i == 0) s+=i;
        }
        return s == num;
    }
    public static void thePerfects(int low, int high){
        for (int i = low; i < high+1; i++) {
            if(isPerfect(i)) System.out.println(i);
        }
    }
    public static boolean noOdd(){
        for (int i = 3; i < 1000000; i+=2) {
            if(isPerfect(i)) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

}
