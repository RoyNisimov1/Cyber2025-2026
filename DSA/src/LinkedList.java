import Queues.Node;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void insert(T value, int index){
        if (index>=this.getSize()) {
            this.append(value);
            return;}
        if(index==0){
            Node<T> h = new Node<>(value);
            h.setNext(this.head);
            this.head = h;
        }else {
            Node<T> root = this.head;
            int i = 0;
            while (root != null){
                if (i==index-1){
                    Node<T> temp = root.getNext();
                    root.setNext(new Node<>(value));
                    root.getNext().setNext(temp);
                    break;
                }
                root = root.getNext();
                i++;
            }
        }
        setSize(getSize()+1);
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
        setSize(getSize()+1);
    }

    public void remove(int index){
        if (index>=this.getSize()) return;
        if (index == 0) {
            if (this.getSize()==1) this.tail = null;
            this.head = this.head.getNext();
            setSize(getSize()-1);
            return;
        }
        Node<T> root = this.head;
        int i = 0;
        while (root != null){
            if (i == index - 1){
                Node<T> temp = root.getNext();
                root.setNext(temp.getNext());
                temp.setNext(null);
                break;
            }
            i++;
            root = root.getNext();
        }
        setSize(getSize()-1);

    }

    @Override
    public String toString(){
        String s = "";
        Node<T> curr = this.head;
        while (curr != null){
            s += curr.toString() + " -> ";
            curr = curr.getNext();
        }
        s+="Null (EOL)";
        return s;
    }


    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    public Node<T> getHead(){
        return this.head;
    }
    public void setHead(Node<T> newHead){
        newHead.setNext(this.head.getNext());
        this.head.setNext(null);
        this.head = newHead;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size<0) size = 0;
        this.size = size;
    }
}
