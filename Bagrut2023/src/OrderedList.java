public class OrderedList {

    private Node<NumCount> first;
    public OrderedList(Node<NumCount> first){
        this.first = first;
    }



    // Time complexity is O(N) where N is the length of the linked list. this is because we loop through the entire linked list
    public void insertNum(int x){
        Node<NumCount> root = this.first;
        while (root != null && root.getNext() != null){
            if(root.getValue().getNum() == x){
                root.getValue().setCount(root.getValue().getCount()+1);
                return;
            }
            if(root.getValue().getNum() < x && x < root.getNext().getValue().getNum()){
                root.setNext(new Node<>(new NumCount(x, 1), root.getNext()));
                return;
            }
            root = root.getNext();
        }
        if(root.getValue().getNum() == x){
            root.getValue().setCount(root.getValue().getCount()+1);
            return;
        }
        root.setNext(new Node<>(new NumCount(x, 1)));
    }

    public int valueN(int n){
        int i = 0;
        Node<NumCount> root = this.first;
        while (root != null){
            if(i < n && i + root.getValue().getCount() > n) return root.getValue().getNum();
            i+=root.getValue().getCount();
            if(root.getNext() == null && i == n) return root.getValue().getNum();
            root = root.getNext();
        }
        return -1;
    }


    @Override
    public String toString(){
        String s = "";
        Node<NumCount> root = this.first;
        while (root != null){
            s += "(" + root.getValue().getNum() + ", " + root.getValue().getCount()+ ") -> ";
            root = root.getNext();
        }
        return s;
    }


}
