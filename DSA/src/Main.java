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

    public static boolean isExist(Queue<Integer> q, int num){
        Node<Integer> cur = q.getFirst();
        while (cur != null){
            if (cur.getValue() == num){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    public static boolean isNumInSeq(Queue<Integer> q, int num){
        Node<Integer> cur = q.getFirst();
        int current_seq_length = 0;
        while (cur != null){
            if (cur.getValue() == num){
                current_seq_length++;
                if (current_seq_length>=2) return true;
            } else {
                current_seq_length = 0;
            }

            cur = cur.getNext();
        }
        return false;
    }


    public static boolean haveSameElements(Queue<Integer> q1, Queue<Integer> q2){
        while (!q1.isEmpty()){
            int minQ1 = findMin(q1).getValue();
            Node<Integer> minQ2N = findMin(q2);
            if (minQ2N != null){
                int minQ2 = minQ2N.getValue();
                if (minQ1 != minQ2) return false;
                q1.remove(minQ1);
                q2.remove(minQ2);
            }else return false;

        }
        if (!q2.isEmpty()) return false;
        return true;
    }


    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2){
        while (!q2.isEmpty()){
            q1.Insert(q2.remove());
        }
        return q1;
    }


    public static void main(String[] args) {
        Queue<Integer> q1 = buildInputIntQueue();
        Queue<Integer> q2 = buildInputIntQueue();
        System.out.println(q1.toString());
        System.out.println(q2.toString());
        System.out.println(merge(q1, q2));

    }
}