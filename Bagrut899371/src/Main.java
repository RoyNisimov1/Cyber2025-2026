import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.println(isPalindrome("ACBA"));
        int[] arr = {2, 3, -1, 5, 4, 6, 1, -2};
        System.out.println(sumOfLongestSeq(arr));
        int[] arr2 = {1, 4, 8, 10, 7, 2};
        System.out.println(kSeqEven(arr2, 3));

        int[] arr3 = {2, 5, 1, 8, 9, 3};
        System.out.println(avgSeq(arr3, 3));

        int[] arr4 = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(ex7(arr4));
        System.out.println(ex7(arr3));

    }
    public static void ex9(){
        String s = "";
        Scanner scanner = new Scanner(System.in);
        boolean ok = false;
        while (!ok){
            s = scanner.nextLine();
            ok = true;
            if (s.length() < 6) ok = false;
            boolean hasDigit = false;
            for (int i = 0; i < s.length(); i++) {
                if(Character.isDigit(s.charAt(i))) hasDigit=true;
            }
            boolean hasChar = false;
            for (int i = 0; i < s.length(); i++) {
                if(Character.isLetter(s.charAt(i))) hasChar=true;
            }
            ok = ok && hasChar && hasDigit;
        }
    }
    public static boolean isPalindrome(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

    public static int sumOfLongestSeq(int[] arr){
        int maxLen = 0;
        int currentLen = 0;
        int smax = 0;
        int scurr = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i]>0){
                currentLen++;
                scurr+=arr[i];
            }else {
                currentLen = 0;
                scurr = 0;
            }
            if(currentLen > maxLen) maxLen = currentLen;
            if(scurr > smax) smax = scurr;
        }
        return smax;
    }

    public static boolean kSeqEven(int[] arr, int k){
        int maxLen = 0;
        int currentLen = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i]%2==0){
                currentLen++;
            }else {
                currentLen = 0;
            }
            if(currentLen > maxLen) maxLen = currentLen;
            if(maxLen >= k) return true;
        }
        return false;
    }

    public static int avgSeq(int[] arr, int k){
        int startIndexMax = 0;
        double maxAvg = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int s = 0;
            for (int j = i; j < i + k; j++) {
                s += arr[j];
            }
            if((double) s /k > maxAvg) {
                maxAvg = (double) s /k;
                startIndexMax = i;
            }
        }

        return startIndexMax;
    }

    public static int ex7(int[] arr) {
        return lcsHelper(arr, 0, -1);
    }

    private static int lcsHelper(int[] arr, int index, int prevIndex) {
        if (index == arr.length) {
            return 0;
        }
        int leave = lcsHelper(arr, index + 1, prevIndex);
        int take = 0;
        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            take = 1 + lcsHelper(arr, index + 1, index);
        }
        return Math.max(take, leave);
    }

}