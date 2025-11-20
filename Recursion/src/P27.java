import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class P27 {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        System.out.println(ex14(3, arr, 0));
        int[] arr1 = {-1, -2, 3, -4, -6, 7, 5, 8};
        System.out.println(ex15(0, arr1, 0));
        System.out.println(ex16(0, arr1, 7));
        System.out.println(ex17(0, arr));
        int[] arr2 = {4,6,8,10,20};
        System.out.println(ex18(0, arr2));
        int[][] arr2d = {{1,2,3,4},{1,3,4}, {0,0,1,3,4,2}};
        System.out.println(ex19(arr2d.length-1, arr2d, 2, 0));
        int[] arr3 = {1,2,3,2,1};
        System.out.println(ex20(arr3));

        String s = "abCdEFg";
        System.out.println(ex21(s, 0));

    }

    public static int ex14(int i, int[] arr, int sum){
        if (i >= arr.length) i = arr.length -1;
        if (i < 0) return sum;
        return ex14(i - 1, arr, sum + arr[i]);
    }

    public static int ex15(int i, int[] arr, int pos_amount){
        if (i >= arr.length) return pos_amount;
        pos_amount = arr[i] > 0 ? (pos_amount+1) : pos_amount;
        return ex15(i+1, arr, pos_amount);
    }
    public static int ex16(int i, int[] arr, int target){
        if (i >= arr.length) return -1;
        if (arr[i] == target) return i;
        return ex16(i+1, arr, target);
    }

    public static boolean ex17(int i, int[] arr){
        if (i<=0) return ex17(1, arr);
        if (i >= arr.length) return true;
        if (arr[i - 1] > arr[i]) return false;
        return ex17(i+1, arr);
    }

    public static boolean ex18(int i, int[] arr) {
        if (i >= arr.length) return true;
        if (arr[i] <= 1) return ex18(i + 1, arr);
        if (P26.ex8(arr[i], 2)){
            return false;
        }
        return ex18(i+1, arr);
    }

    public static int ex19(int i, int[][] arr2d, int target, int s){
        if (i < 0) return s;
        for (int j = 0; j < arr2d[i].length; j++) {
            if (arr2d[i][j] == target) {
                s++;
                break;
            }
        }
        return ex19(i-1, arr2d, target, s);
    }

    public static boolean ex20(int[] arr){
        Random random = new Random();
        int halfLengArr = arr.length / 2;
        int lSubarr = random.nextInt(halfLengArr);
        int rSubarr = random.nextInt(halfLengArr) + halfLengArr;
        int subArrLen = rSubarr - lSubarr;
        int[] palArr = new int[subArrLen];
        for (int i = 0; i < subArrLen; i++) {
            palArr[i] = arr[i + lSubarr];
        }
        return isPalindrome(palArr, 0, palArr.length-1);
    }

    public static boolean isPalindrome(int[] arr, int l, int r){
        if(r <= l) return true;
        if(arr[l] != arr[r]) return false;
        return isPalindrome(arr, l+1, r-1);
    }

    public static int ex21(String s, int lowerCaseNum){
        if (Objects.equals(s, "")) return lowerCaseNum;
        if (Character.isLowerCase(s.charAt(0))) lowerCaseNum++;
        return ex21(s.substring(1), lowerCaseNum);
    }

}
