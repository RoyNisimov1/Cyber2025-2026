package Queues;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q1 = buildInputIntQueue();
        Queue<Integer> q2 = buildInputIntQueue();
        printQueue(q1);
        printQueue(q2);
        System.out.println(haveSameElements(q1, q2));
        printQueue(q1);
        printQueue(q2);
    }

    // Q3
    public static void printQueue(Queue<Integer> q){
        String s = "h[";
        Queue<Integer> t = new Queue<>();
        while (!q.isEmpty()){
            int cur = q.remove();
            t.insert(cur);
            s += cur + "";
            if (!q.isEmpty()) s+=", ";
        }
        s+="]";
        System.out.println(s);
        while (!t.isEmpty()){
            q.insert(t.remove());
        }
    }

    // Q4
    public static Queue<Integer> buildInputIntQueue()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        int num = scanner.nextInt();
        Queue<Integer> integerQueue = new Queue<>();
        while (num != -999)
        {
            integerQueue.insert(num);
            num = scanner.nextInt();
        }
        return integerQueue;
    }


    public static void buildQueues(Queue<Integer> qu1, Queue<Integer> qu2)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        int num = scanner.nextInt();
        while (num != -999)
        {
            if (num % 2 == 0)
                qu1.insert(num);
            else
                qu2.insert(num);
            num = scanner.nextInt();
        }
    }



    public static int findMin(Queue<Integer> q){
        Queue<Integer> t = new Queue<>();
        int min = q.head();
        while (!q.isEmpty()){
            if (q.head() <= min){
                min = q.head();
            }
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return min;
    }


    public static void removeFromQueue(Queue<Integer> q, int value){
        Queue<Integer> t = new Queue<>();
        boolean found = false;
        while (!q.isEmpty()){
            int cur = q.remove();
            if (!found){
                if (cur == value) {
                    found = true;
                }
                else t.insert(cur);
            } else {
                t.insert(cur);
            }
        }

        while (!t.isEmpty()){
            q.insert(t.remove());
        }
    }

    // Q5
    public static Queue<Integer> buildInputSortedIntQueue()
    {
        Queue<Integer> integerQueue = buildInputIntQueue();
        Queue<Integer> q = new Queue<>();
        while (!integerQueue.isEmpty()){
            int min = findMin(integerQueue);
            q.insert(min);
            removeFromQueue(integerQueue,min);
        }
        return q;
    }

    //Q5 different sol
    public static Queue<Integer> buildInputSortedIntQueue2()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        int num = scanner.nextInt();
        Queue<Integer> integerQueue = new Queue<>();
        Queue<Integer> sortedIntegerQueue = new Queue<>();
        while (num != -999)
        {
            if (sortedIntegerQueue.isEmpty()) sortedIntegerQueue.insert(num);
            else {
                while (!sortedIntegerQueue.isEmpty() && num > sortedIntegerQueue.head()){
                    integerQueue.insert(sortedIntegerQueue.remove());
                }
                integerQueue.insert(num);
                while (!sortedIntegerQueue.isEmpty()){
                    integerQueue.insert(sortedIntegerQueue.remove());
                }
                while (!integerQueue.isEmpty()){
                    sortedIntegerQueue.insert(integerQueue.remove());
                }
            }
            num = scanner.nextInt();
        }
        return sortedIntegerQueue;
    }


    //Q6
    public static boolean isExist(Queue<Integer> q, int num){
        Queue<Integer> t = new Queue<>();
        boolean ret = false;
        while (!q.isEmpty()){
            int cur = q.remove();
            t.insert(cur);
            if (cur == num) ret = true;
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return ret;
    }
    //Q7
    public static boolean isNumInSeq(Queue<Integer> q, int num){
        int count = 0;
        Queue<Integer> t = new Queue<>();
        while (!q.isEmpty()){
            int cur = q.remove();
            if (cur == num){
                count++;
            }else if (count < 2) count = 0;
            t.insert(cur);
        }
        while (!t.isEmpty()) q.insert(t.remove());

        return count >= 2;
    }
    //Q8
    public static boolean haveSameElements(Queue<Integer> q1, Queue<Integer> q2){
        if (size(q1) != size(q2)) return false;

        Queue<Integer> q2Copy = new Queue<>();
        Queue<Integer> t1 = new Queue<>();

        while (!q2.isEmpty()){
            q2Copy.insert(q2.head());
            t1.insert(q2.remove());
        }
        while (!t1.isEmpty()){
            q2.insert(t1.remove());
        }
        boolean ret = true;
        while (!q1.isEmpty()){
            if (!isInQueue(q2Copy, q1.head())) ret = false;
            removeFromQueue(q2Copy, q1.head());
            t1.insert(q1.remove());
        }
        while (!t1.isEmpty()){
            q1.insert(t1.remove());
        }
        return ret;
    }
    public static int size(Queue<Integer> q){
        Queue<Integer> t = new Queue<>();
        int ret = 0;
        while (!q.isEmpty()){
            ret++;
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return ret;
    }

    public static boolean isInQueue(Queue<Integer> q, int target){
        Queue<Integer> t = new Queue<>();
        boolean ret = false;
        while (!q.isEmpty()){
            if (q.head() == target) ret = true;
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return ret;

    }


    //Q9
    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2){
        Queue<Integer> q = new Queue<>();
        while (!q1.isEmpty() || !q2.isEmpty()){
            if (q1.isEmpty()) q.insert(q2.remove());
            else if (q2.isEmpty()) q.insert(q1.remove());
            else {
                if (q1.head() <= q2.head()) {
                    q.insert(q1.remove());
                }
                else {
                    q.insert(q2.remove());
                }
            }
        }
        return q;
    }



}