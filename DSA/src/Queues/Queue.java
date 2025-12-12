package Queues;

public class Queue<T>
{
    private Node<T> first;
    private Node<T> last;
    public Queue(){
        this.first = null;
        this.last = null;
    }
    public void insert(T x){
        Node<T> temp = new Node<T>(x);
        if (first == null)
            first = temp;
        else
            last.setNext(temp);
        last = temp;
    }
    public T remove(){
        T x = first.getValue();
        first = first.getNext();
        if (first == null)
            last = null;
        return x;
    }
    public void remove(T value){
        Node<T> cur = this.getFirst();
        if (cur.getValue() == value){
            this.remove();
            return;
        }
        while (cur.getNext() != null){
            if (cur.getNext().getValue() == value){
                cur.setNext(cur.getNext().getNext());
                return;
            }
            cur = cur.getNext();
        }

    }
    public T head(){
        return first.getValue();
    }
    public Node<T> getFirst(){
        return this.first;
    }

    public boolean isEmpty(){
        return first == null;
    }
    @Override
    public String toString(){
        String s = "h[";
        Node<T> p = this.first;
        while (p != null){
            s = s + p.getValue().toString();
            if (p.getNext() != null)
                s = s + ",";
            p = p.getNext();
        }
        s = s + "]";
        return s;
    }
    public Queue<T> clone(){
        Queue<T> t = new Queue<>();
        Queue<T> c = new Queue<>();
        while (!this.isEmpty()){
            c.insert(this.head());
            t.insert(this.remove());
        }
        while (!t.isEmpty()) this.insert(t.remove());
        return c;
    }
    public void prepend(T obj){
        Queue<T> q = new Queue<>();
        q.insert(obj);
        while (!this.isEmpty()){
            q.insert(this.remove());
        }
        while (!q.isEmpty()){
            this.insert(q.remove());
        }
    }


}