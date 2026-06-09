package Bagrute2023;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println(success(5));
        System.out.println(discounts(71, 3, false));
        int[] arr = {3, 4, 2, 1, 0};
        System.out.println(originalText("dyutS", arr));
    }

    public static boolean success(int num){
        Scanner s = new Scanner(System.in);
        int pOver6 = 0;
        int[] points = new int[num];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            points[i] = s.nextInt();
            if(points[i] == 10) return true;
            if(points[i] >= 6) pOver6++;
            sum += points[i];
        }
        double avg = ((double) sum) / num;
        if(avg>5.0) return true;
        return pOver6 > num / 2;
    }

    public static int discounts(int age, int num, boolean city){
        int s = 111;
        if(age < 70) s+=100;
        if(num<3) s+=10;
        if(!city) s+=1;
        return s;
    }


    // Study -> dyutS = [3,4,2,1,0]
    public static String originalText(String txt, int[] arr){
        int curIndex = 0;
        String s = "";
        for (int i = 0; i < txt.length(); i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == curIndex){
                    s += txt.charAt(j);
                    curIndex++;
                }
            }
        }
        return s;
    }


}
