package Bagrute2024;
import java.util.Random;
public class Main {
    public static void main(String[] args){
        int[] arr = {1223, 134, 245, 300, 111, 101, 777, 900, 195, 1234};
        System.out.println(getPass(300, arr));
        System.out.println(getPass(8888, arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("-----------------------------------------");
        shuffle(arr);
        System.out.println("-----------------------------------------");
        System.out.println(deepSum(942378));
        System.out.println("-----------------------------------------");
        System.out.println(isCorrect());
        System.out.println("-----------------------------------------");
        System.out.println(inBoth(36, 942378));
    }
    public static boolean getPass(int pass, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == pass) return false;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = pass;
        return true;


    }
    public static void shuffle(int[] arr){
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            int index1 = r.nextInt(0, arr.length);
            int index2 = r.nextInt(0, arr.length);
            while (index1 == index2) index2 = r.nextInt(0, arr.length);
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int digitSum(int num){
        int s = 0;
        while (num != 0){
            s += num % 10;
            num = num / 10;
        }
        return s;
    }
    public static int deepSum(int num){
        while (num / 10 != 0){
            num = digitSum(num);
        }
        return num;
    }

    public static boolean isCorrect(){
        int nEven = 0;
        int nOdd = 0;
        for (int i = 1; i < 1000000; i++) {
            if(deepSum(i) % 2 == 0) nEven++;
            else nOdd++;
        }
        return nEven > nOdd;
    }

    public static boolean digitExists(int num, int d){
        if (num == 0 && num == d) return true;
        while (num != 0){
            if(d == num%10) return true;
            num = num/10;
        }
        return false;
    }
    public static boolean inBoth(int num1, int num2){
        return digitExists(num2, deepSum(num1)) && digitExists(num1, deepSum(num2));
    }
}
