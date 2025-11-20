public class minAlg {
    public static void main(String[] args) {
        int[] arr = {1, 2, -2, 3 ,5};
        System.out.println(findMin(arr, 1));
    }


    public static int findMin(int[] arr, int index){
        if (arr.length <= 1) return arr[0];

        int[] newArr = new int[arr.length- index];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i + index];
        }

        int[] arr2 = new int[newArr.length-1];

        arr2[0] = Math.min(newArr[0], newArr[1]);
        for (int i = 2; i < newArr.length; i++) {
            arr2[i-1] = newArr[i];
        }

        return findMin(arr2, 0);


    }



}
