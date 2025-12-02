import Queues.Node;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void append(T value){
        if (this.head == null) {
            this.head = new Node<>(value);
            this.tail = this.head;
        }
        else {
            Node<T> curr = head;
            while (curr.getNext() != null){
                curr = curr.getNext();
            }
            curr.setNext(new Node<>(value));
            this.tail = curr.getNext();
        }
    }

    @Override
    public String toString(){
        String s = "";
        Node<T> curr = this.head;
        while (curr != null){
            s += curr.toString() + " -> ";
            curr = curr.getNext();
        }
        return s;
    }



}
