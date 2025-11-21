import java.util.Scanner;

public class Main {
    public static void buildQueues(Queue<Integer> qu1, Queue<Integer> qu2)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        int num = scanner.nextInt();
        while (num != -999)
        {
            if (num % 2 == 0)
                qu1.Insert(num);
            else
                qu2.Insert(num);
            num = scanner.nextInt();
        }
    }
    public static Queue<Integer> buildInputIntQueue()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        int num = scanner.nextInt();
        Queue<Integer> integerQueue = new Queue<>();
        while (num != -999)
        {
            integerQueue.Insert(num);
            num = scanner.nextInt();
        }
        return integerQueue;
    }
    public static Node<Integer> findMin(Queue<Integer> q){
        Node<Integer> cur = q.getFirst();
        Node<Integer> min = cur;
        while (cur != null){
            if (cur.getValue() <= min.getValue()){
                min = cur;
            }
            cur = cur.getNext();
        }
        return min;
    }
    public static Node<Integer> findMax(Queue<Integer> q){
        Node<Integer> cur = q.getFirst();
        Node<Integer> max = cur;
        while (cur != null){
            if (cur.getValue() >= max.getValue()){
                max = cur;
            }
            cur = cur.getNext();
        }
        return max;
    }

    public static Queue<Integer> buildInputSortedIntQueue()
    {
        Queue<Integer> integerQueue = buildInputIntQueue();
        Queue<Integer> q = new Queue<>();
        while (!integerQueue.isEmpty()){
            Node<Integer> min = findMin(integerQueue);
            q.Insert(min.getValue());
            integerQueue.remove(min.getValue());
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = buildInputSortedIntQueue();
        System.out.println(q1.toString());
    }
}