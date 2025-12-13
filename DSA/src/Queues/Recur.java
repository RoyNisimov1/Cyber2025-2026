package Queues;

public class Recur {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);
        q.insert(6);
        q.insert(5);
        q.insert(6);

        System.out.println(countQueueElements(q));
        System.out.println(sumQueuesRecursive(q));
        System.out.println(CountOccurrences(q, 6));
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);
        q.insert(6);
        q.insert(5);
        q.insert(6);
        System.out.println(is_value_in_queue(q, 6));
        Queue<Integer> qu = new Queue<>();
        qu.insert(5);
        qu.insert(77);
        qu.insert(91);
        qu.insert(8);
        System.out.println(isQueueSortedStrictlyIncreasing(qu));

        Queue<Integer> qu1 = new Queue<>();
        qu1.insert(-66666666);
        qu1.insert(-66666666);
        qu1.insert(-66666665);
        qu1.insert(-66666666);
        System.out.println(findMaxInQueue(qu1));

        Queue<Integer> qu2 = new Queue<>();
        qu2.insert(1);
        qu2.insert(2);
        qu2.insert(3);
        qu2.insert(4);
        qu2.insert(3);
        System.out.println(extractLastElement(qu2));
    }

    public static <T> int countQueueElements(Queue<T> q) {
        Queue<T> temp = q.clone();
        if (temp.isEmpty()) return 0;
        temp.remove();
        return 1 + countQueueElements(temp);
    }

    public static int sumQueuesRecursive(Queue<Integer> q){
        if (q.isEmpty()) return 0;
        Queue<Integer> t = q.clone();
        return t.remove() + sumQueuesRecursive(t);
    }

    public static int CountOccurrences(Queue<Integer> q, int n){
        if (q.isEmpty()) return 0;
        int curr = q.remove();
        if (curr == n) return 1 + CountOccurrences(q, n);
        return CountOccurrences(q, n);
    }

    public static boolean is_value_in_queue(Queue<Integer> q, int n){
        if (q.isEmpty()) return false;
        int curr = q.remove();
        if (curr == n) return true;
        return is_value_in_queue(q, n);
    }

    public static boolean isQueueSortedStrictlyIncreasing(Queue<Integer> q){
        if(q.isEmpty()) return true;
        int cur = q.remove();
        if(q.isEmpty()) return true;
        if(cur>q.head()) return false;
        return isQueueSortedStrictlyIncreasing(q);
    }

    public static int findMaxInQueue(Queue<Integer> q){
        if(q.isEmpty()) return -2147483648;
        int c = q.remove();
        return Math.max(c, findMaxInQueue(q));
    }

    public static int extractLastElement(Queue<Integer> q){
        if(q.isEmpty()) return 0;
        int c = q.remove();
        if (q.isEmpty()) return c;
        return extractLastElement(q);
    }

}

