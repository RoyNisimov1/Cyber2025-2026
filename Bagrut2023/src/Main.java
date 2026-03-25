

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,9, -3, 17, 0, 29, -20, -40, 29};
        System.out.println(posOrder(arr));

        int[] arr2 = {6,8,12,14,16,18};
        System.out.println(missingNum(arr2));

        Queue<Integer> q = new Queue<>();
        q.insert(5);
        q.insert(4);
        q.insert(1);
        q.insert(4);
        q.insert(3);
        q.insert(15);
        q.insert(9);
        System.out.println(twoSum(q, 9));

        OrderedList o = new OrderedList(new Node<>(new NumCount(3, 4)));
        o.insertNum(5);
        o.insertNum(8);
        o.insertNum(8);
        o.insertNum(8);
        System.out.println(o);
        o.insertNum(10);
        System.out.println(o);
        System.out.println(o.valueN(7));


    }

    public static boolean posOrder(int[] arr){
        int lastPosInt = 1;
        for (int j : arr) {
            if (j >= 1) {
                if (j < lastPosInt) {
                    return false;
                }
                lastPosInt = j;
            }
        }
        return true;
    }

    public static int missingNum(int[] arr){
        int diff1 = arr[1] - arr[0];
        int diff2 = arr[2] - arr[1];
        int diff3 = arr[3] - arr[2];
        int delta = diff1;
        if (diff1 != diff2 && diff1 != diff3){
            return arr[0] + diff2;
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i-1] != delta){
                return arr[i-1] + delta;
            }
        }
        return 0;
    }

    public static boolean twoSum(Queue<Integer> q, int x){
        int i = 0;
        while (!q.isEmpty() && i <= q.size()){
            int h = q.remove();
            Queue<Integer> tmp = new Queue<>();
            while (!q.isEmpty()){
                tmp.insert(q.remove());
            }
            while (!tmp.isEmpty()){
                if (tmp.head() + h == x) return true;
                q.insert(tmp.remove());
            }
            q.insert(h);
            i++;
        }
        return false;
    }



}