import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Program {

    public static int[] leftShift(int[] arr){
        int[] retArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            retArr[i] = arr[(((i+1) % arr.length) + arr.length) % arr.length];
        }
        return retArr;
    }

    public static boolean ex2() {
        int[] arr1 = {0,1,2,3,5};
        int[] arr2 = {0,1,2,3,4};

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 0;
            arr2[i] = 0;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static int[] fGrade(){
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();
        int[] grades1 = new int[numberOfStudents];
        int[] grades2 = new int[numberOfStudents];
        int[] finalGrades = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Grade 1 of student #" + (i+1));
            grades1[i] = scanner.nextInt();
            System.out.println("Grade 2 of student #" + (i+1));
            grades2[i] = scanner.nextInt();
            finalGrades[i] = Math.max(grades1[i], grades2[i]);
        }
        System.out.println(Arrays.toString(grades1));
        System.out.println(Arrays.toString(grades2));
        System.out.println(Arrays.toString(finalGrades));
        return finalGrades;
    }

    public static void PosNeg(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int numOfPos = 0;
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            numbers[i] = n;
            if (n >= 0) numOfPos++;
        }
        int[] positiveNumbers = new int[numOfPos];
        int[] negNumbers = new int[num - numOfPos];
        int negIndex = 0;
        int posIndex = 0;
        for (int i = 0; i < num; i++) {
            if (numbers[i] >= 0) {
                positiveNumbers[posIndex] = numbers[i];
                posIndex++;
            }
            else {
                negNumbers[negIndex] = numbers[i];
                negIndex++;
            }
        }
        System.out.println(Arrays.toString(positiveNumbers));
        System.out.println(Arrays.toString(negNumbers));
        System.out.println(Arrays.toString(numbers));

    }
    public static int[] noDups(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int n1 = scanner.nextInt();
            if (i==0){
                nums.add(n1);
                continue;
            }
            if (n1 == nums.getLast()){
                continue;
            }
            nums.add(n1);
            System.out.println(nums);
        }
        int[] retArr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            retArr[i] = nums.get(i);
        }
        System.out.println(Arrays.toString(retArr));
        return retArr;
    }
    public static int[] noDupsNoArrayList(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            int n1 = scanner.nextInt();
            if (i == 0){
                numbers[0] = n1;
                j++;
                continue;
            }
            if (numbers[j-1] == n1){
                continue;
            }
            numbers[j] = n1;
            j++;
        }
        int[] arr = new int[j];
        for (int i = 0; i < j; i++) {
            arr[i] = numbers[i];
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int[] MergeSort6(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int z = 0;
        int[] numbers = new int[arr1.length + arr2.length];
        while (z <= (arr1.length + arr2.length)){
            if(j >= arr2.length && i >= arr1.length){
                break;
            }
            if (i>=arr1.length){
                numbers[z] = arr2[j];
                j++;
                z++;
                continue;
            }
            if (j>=arr2.length){
                numbers[z] = arr1[i];
                i++;
                z++;
                continue;
            }
            if (arr1[i] <= arr2[j]){
                numbers[z] = arr1[i];
                i++;
            }
            else {
                numbers[z] = arr2[j];
                j++;
            }
            z++;
        }

        System.out.println(Arrays.toString(numbers));
        return numbers;
    }


}
