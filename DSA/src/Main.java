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
    public static Queue<Integer> buildInputSortedIntQueue()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        int num = scanner.nextInt();
        Queue<Integer> integerQueue = new Queue<>();
        while (num != -999)
        {
            if (integerQueue.isEmpty()){
                integerQueue.Insert(num);
            }
            else {
                if (num >= integerQueue.head()) {
                    integerQueue.Insert(num);
                    System.out.println(num + " " + integerQueue.head());
                }
                else integerQueue.prepend(num);
            }
            num = scanner.nextInt();

        }
        return integerQueue;
    }






//    public static void main(String[] args) {
//        Queue<Integer> q1 = new Queue<Integer>();
//        Queue<Integer> q2 = new Queue<Integer>();
//        buildQueues(q1, q2);
//        System.out.println("q1: " + q1);
//        System.out.println("q2: " + q2);
//    }
    public static void main(String[] args) {
        Queue<Integer> q1 = buildInputSortedIntQueue();
        System.out.println(q1.toString());
    }
}