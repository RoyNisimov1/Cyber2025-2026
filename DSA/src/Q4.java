import Queues.Node;
import java.util.Random;
import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {
        Node<Integer> r = new Node<>(1);
        r.setNext(new Node<>(2));
        Node<Integer> c = r.getNext();
        c.setNext(new Node<>(3));
        c = c.getNext();
        c.setNext(new Node<>(4));
        c = c.getNext();
        c.setNext(new Node<>(5));
        c = c.getNext();
        c.setNext(new Node<>(4));
        c = c.getNext();
        c.setNext(new Node<>(5));
        c = c.getNext();
        c.setNext(new Node<>(4));
        c = c.getNext();
        c.setNext(new Node<>(5));

        printList(r);
        r = exc14(r, 3);
        printList(r);

    }
    public static <T> void printList(Node<T> list){
        String s = "";
        Node<T> curr = list;
        while (curr != null){
            s += curr.toString() + " -> ";
            curr = curr.getNext();
        }
        s+="Null (EOL)";
        System.out.println(s);
    }

    public static int exc2(Node<Integer> list, int target){
        int seqs = 0;
        boolean inAseq = false;
        Node<Integer> root = list;
        while (root.getNext() != null){
            if(root.getValue() == target){
                if(!inAseq) seqs++;
                inAseq=true;
            }
            else {
                inAseq=false;
            }
            root = root.getNext();
        }
        return seqs;
    }

    public static void exc3(Node<Integer> list, int l, int r){
        int i = 0;
        while (list != null){
            if(i<= r && i>= l) System.out.println(list.getValue());
            i++;
            list = list.getNext();
        }
    }

    public static char exc4(Node<Integer> list){
        int numOdd = 0;
        int numEven = 0;
        while (list!=null){
            if(list.getValue() % 2 == 0) numEven++;
            else numOdd++;
            list = list.getNext();
        }
        if(numEven == numOdd) return 's';
        if(numEven > numOdd) return 'e';
        return 'o';
    }

    public static Node<Integer> exc5(Node<Integer> list, int num){
        while (list.getValue() == num){
            list = list.getNext();
        }
        Node<Integer> dummy = list;
        while (list!=null && list.getNext()!=null){
            while(list.getNext() != null && list.getNext().getValue() == num){
                list.setNext(list.getNext().getNext());
            }
            list = list.getNext();
        }
        return dummy;
    }


    public static <T> boolean isInList(Node<T> list, T target){
        while (list!=null){
            if (list.getValue() == target) return true;
            list = list.getNext();
        }
        return false;
    }


    public static Node<Integer> exc6(Node<Integer> list){
        Node<Integer> root = list;
        Node<Integer> newList = new Node<>(root.getValue());
        Node<Integer> newListRoot = newList;
        while (root!=null){
            if(!isInList(newList, root.getValue())){
                newListRoot.setNext(new Node<>(root.getValue()));
                newListRoot = newListRoot.getNext();
            }
            root = root.getNext();
        }
        return newList;
    }

    public static Node<Integer> exc7(){
        Random random = new Random();
        Node<Integer> dummy = new Node<>(random.nextInt());
        Node<Integer> root = dummy;
        for (int i = 0; i < 49; i++) {
            root.setNext(new Node<>(random.nextInt()));
            root = root.getNext();
        }
        return exc6(dummy);
    }

    public static boolean exc8(Node<Integer> list){

        while (list.getNext()!= null){
            if(list.getNext().getValue() < list.getValue()) return false;
            list = list.getNext();
        }
        return true;
    }
    public static void exc9(Node<Integer> list){

        while (list.getNext()!= null){
            if(list.getNext().getValue() > list.getValue()) System.out.println(list.getValue());;
            list = list.getNext();
        }

    }
    public static Node<Integer> exc10(int beginner, int num){
        Node<Integer> dummy = new Node<>(beginner);
        Node<Integer> root = dummy;
        num = num - beginner;
        beginner++;
        int i = 0;
        while (i <= num){
            dummy.setNext(new Node<>(beginner));
            beginner++;
            dummy = dummy.getNext();
            i++;
        }
        return root;
    }

    public static Node<Integer> exc11(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        Node<Integer> dummy = null;
        while (a != -999){
            dummy = new Node<>(a, dummy);
            a = scanner.nextInt();
        }
        return dummy;
    }

    public static double findAvg(Node<Integer> list){
        int s = 0;
        int i = 0;
        while (list!=null){
            i++;
            s+=list.getValue();
            list = list.getNext();
        }
        return (double) s /i;
    }

    public static boolean exc12(Node<Integer> list){
        double avg = findAvg(list);
        int bigger = 0;
        int smaller = 0;
        while (list!=null){
            if (list.getValue()>avg) bigger++;
            if(list.getValue()<avg) smaller++;
            list = list.getNext();
        }
        return bigger == smaller;
    }

    public static int size(Node<Integer> root){
        int i = 0;
        while (root!=null){
            i++;
            root=root.getNext();
        }
        return i;
    }

    public static Node<Integer> exc13(Node<Integer> list){
        int sizeOfList = size(list);
        if (sizeOfList==2){
            if(list.getValue()>list.getNext().getValue()){
                return list.getNext();
            }
            else {
                list.setNext(null);
                return list;
            }
        }
        Node<Integer> head = list;
        if(sizeOfList%2==0){
            int i = 0;
            int halfOfList = sizeOfList / 2 - 1;

            while(list.getNext()!=null){
                if(i == halfOfList - 1){
                    if(list.getNext().getValue() > list.getNext().getNext().getValue()){
                        list.setNext(list.getNext().getNext());
                    }else {
                        list.getNext().setNext(list.getNext().getNext().getNext());
                    }
                }
                i++;
                list = list.getNext();
            }
        }
        else {
            head = head.getNext();
            int i = 0;
            while (list!=null && list.getNext()!=null){
                if(i == sizeOfList-2){
                    list.setNext(list.getNext().getNext());
                }
                i++;
                list = list.getNext();
            }
        }
        return head;
    }

    public static Node<Integer> insertSortedBigToSmall(Node<Integer> list, int num){
        Node<Integer> head = list;
        if(num>=list.getValue()){
            return new Node<>(num, head);
        }
        while (list!=null && list.getNext()!=null){
            if(num>=list.getNext().getValue()){
                list.setNext(new Node<>(num, list.getNext()));
                return head;
            }
            list = list.getNext();
        }
        list.setNext(new Node<>(num));
        return head;
    }

    public static <T> void keepNFirstNums(Node<T> list, int num){
        int i = 0;
        while (list!=null){
            if(i==num){
                list.setNext(null);
                return;
            }
            i++;
            list=list.getNext();
        }
    }

    public static Node<Integer> exc14(Node<Integer> list, int n){
        n=n-1;
        Node<Integer> sortedMaxes = new Node<>(list.getValue());
        Node<Integer> head = list;
        list=list.getNext();
        while (list!=null){
            sortedMaxes = insertSortedBigToSmall(sortedMaxes, list.getValue());
            list=list.getNext();
        }
        list = head;
        keepNFirstNums(sortedMaxes, n);
        while (isInList(sortedMaxes, list.getValue())){
            list = list.getNext();
        }
        head = list;
        while (list!=null&&list.getNext()!=null){
            while (list.getNext()!=null&&isInList(sortedMaxes, list.getNext().getValue())){
                list.setNext(list.getNext().getNext());
            }
            list=list.getNext();
        }
        return head;
    }


}
