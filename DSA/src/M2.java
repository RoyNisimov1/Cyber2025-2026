import Queues.Node;

public class M2 {
    public static void main(String[] args){
        Node<Integer> r = new Node<>(10, new Node<>(10, new Node<>(11, new Node<>(9))));
        System.out.println(isBalanced(r));
    }
    public static boolean isBalanced(Node<Integer> ls){
        Node<Integer> root = ls;
        int len = 0;
        int sum = 0;
        while (root != null){
            len++;
            sum += root.getValue();
            root = root.getNext();
        }
        double avg = (double) sum /len;
        root = ls;
        int numOfHigher = 0;
        int numOfLower = 0;
        while (root != null){
            if (root.getValue() > avg) numOfHigher++;
            if (root.getValue() < avg) numOfLower++;
            root = root.getNext();
        }
        return numOfHigher == numOfLower;

    }
}
