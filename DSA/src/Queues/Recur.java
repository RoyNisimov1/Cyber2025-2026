package Queues;
import java.util.Scanner;

public class Recur {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.insert(4);
        q.insert(5);
        q.insert(3);
        q.insert(2);
        q.insert(6);
        q.insert(6);
        System.out.println(countQueueElements(q));
    }

    public static <T> int countQueueElements(Queue<T> q) {
        Queue<T> temp = q.clone();
        if (temp.isEmpty()) return 0;
        temp.remove();
        return 1 + countQueueElements(temp);
    }
}

