import Queues.Node;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(90) + 10;

        Node<Integer> head = new Node<>(randomNumber);
        Node<Integer> root = head;
        for (int i = 0; i < 9; i++) {
            randomNumber = rand.nextInt(90) + 10;
            root.setNext(new Node<>(randomNumber));
            root = root.getNext();
        }

        String s = "List Contents: ";
        Node<Integer> curr = head;
        while (curr != null){
            s += "[" + curr.toString() + "] -> ";
            curr = curr.getNext();
        }
        s+="null";
        System.out.println(s);
        int length = countNodes(head);
        System.out.println("Number of nodes: " + length);

    }
    public static <T> int countNodes(Node<T> head){
        Node<T> root = head;
        int i = 0;
        while (root != null){
            i++;
            root = root.getNext();
        }
        return i;
    }

    public static int longestArithmeticRun(Node<Integer> head){
        if(head==null) return 0;
        if(head.getNext()==null) return 1;
        int currentStreak = 0;
        int maxStreak = 0;
        int diff = head.getNext().getValue() - head.getValue();
        Node<Integer> root = head;
        while (root.getNext() != null){
            int d = root.getNext().getValue() - root.getValue();
            if(d == diff) currentStreak++;
            else {diff = d; currentStreak=1;};
            if(currentStreak>=maxStreak) maxStreak = currentStreak;
            root = root.getNext();
        }
        return maxStreak;
    }


}
