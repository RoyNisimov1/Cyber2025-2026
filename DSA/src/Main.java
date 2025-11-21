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
                qu1.insert(num);
            else
                qu2.insert(num);
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
            integerQueue.insert(num);
            num = scanner.nextInt();
        }
        return integerQueue;
    }
    public static int findMin(Queue<Integer> q){
        Queue<Integer> temp = new Queue<>();
        int min = q.head();
        while (!q.isEmpty()){
            int o = q.remove();
            temp.insert(o);
            if (o <= min) min = o;

        }
        while (!temp.isEmpty()){
            q.insert(temp.remove());
        }
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

    public static void printQueue(Queue<Integer> q){
        String s = "h[";
        Node<Integer> cur = q.getFirst();
        while (cur != null){
            s += cur.getValue();
            if (cur.getNext() != null) s+=", ";
            cur = cur.getNext();
        }
        s+="]";
        System.out.println(s);
    }



    public static boolean haveSameElements(Queue<Integer> q1, Queue<Integer> q2){
        while (!q1.isEmpty()){
            if (q2.isEmpty()) return false;
            int minQ1 = findMin(q1);
            int minQ2 = findMin(q2);
            if (minQ1 != minQ2) return false;
            q1.remove(minQ1);
            q2.remove(minQ2);
        }
        if (!q2.isEmpty()) return false;
        return true;
    }


    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2){
        while (!q2.isEmpty()){
            q1.insert(q2.remove());
        }
        return q1;
    }


    public static void main(String[] args) {
        Queue<Integer> q1 = buildInputSortedIntQueue();
        printQueue(q1);
    }
}