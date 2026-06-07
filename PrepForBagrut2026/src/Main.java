public class Main{
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        System.out.println(q);
        System.out.println(up(q));
        move1(q);
        System.out.println(q);
        System.out.println(up(q));
        System.out.println(upOnMove(q));

        System.out.println(sod(5777887));

        BinNode<Integer> tree = new BinNode(new BinNode(new BinNode(null, 10, new BinNode<>(5)),1, null), 1, new BinNode(new BinNode<>(4), 3, new BinNode<>(2)));
        System.out.println(tree);
        System.out.println(maxInLevel(tree, 3));
        q = new Queue<>();
        q.insert(3);
        q.insert(9);
        q.insert(5);
        q.insert(2);
        System.out.println(q);
        move(q, 4);
        System.out.println(q);
        moveBack(q);
        System.out.println(q);

        Node<String> list = new Node<>("abc", new Node<>("bac", new Node<>("caad", new Node<>("cmb", new Node<>("ba")))));
        System.out.println(list);
        System.out.println(delCollision(list));

    }

    public static <T> void move1(Queue<T> q){
        q.insert(q.remove());
    }

    public static boolean up(Queue<Integer> q){
        Queue<Integer> temp = new Queue<>();
        boolean ret = true;
        while (!q.isEmpty()){
            int x = q.remove();
            if(!q.isEmpty() && q.head() < x) ret = false;
            temp.insert(x);
        }
        while (!temp.isEmpty()){
            q.insert(temp.remove());
        }
        return ret;
    }

    public static <T> int size(Queue<T> q){
        int i = 0;
        Queue<T> temp = new Queue<>();
        while (!q.isEmpty()){
            i++;
            temp.insert(q.remove());
        }
        while (!temp.isEmpty()){
            q.insert(temp.remove());
        }
        return i;
    }

    public static <T> Queue<T> clone(Queue<T> q){
        Queue<T> temp = new Queue<>();
        Queue<T> ret = new Queue<>();
        while (!q.isEmpty()){
            ret.insert(q.head());
            temp.insert(q.remove());
        }
        while (!temp.isEmpty()){
            q.insert(temp.remove());
        }
        return ret;
    }

    // O(n^2)
    public static boolean upOnMove(Queue<Integer> q){
        for (int i = 0; i < size(q); i++) {
            if (up(q)) return true;
            move1(q);
        }
        return false;
    }


    // returns the maximum amount of sequance
    // O(n)
    public static int sod(int num) {
        int n = sod(num,1);
        return n;
    }
    public static int sod(int num, int c) {
        if(num < 10)return c;
        if(num%10 == (num/10)%10) {
            return sod(num/10, c+1);
        }
        return Math.max(c, sod(num/10, 1));
    }

    public static int maxInLevel(BinNode<Integer> tree, int lvl){

        if (tree == null) return Integer.MIN_VALUE;
        if(lvl > 0){
            return Math.max(maxInLevel(tree.getLeft(), lvl-1), maxInLevel(tree.getRight(), lvl-1));
        }
        return tree.getValue();
    }

    public static <T> void moveBack(Queue<T> q){
        Queue<T> temp = new Queue<>();
        T h = q.head();
        while (!q.isEmpty()){
            h = q.remove();
            if(!q.isEmpty()) temp.insert(h);
        }
        q.insert(h);
        while (!temp.isEmpty()) q.insert(temp.remove());
    }

    public static void move(Queue<Integer> q, int n){
        for(int i=1; i<=n; i++){
            moveBack(q);
        }
    }

    public static Node<String> delCollision(Node<String> l){
        Node<String> root = l;
        Node<String> head = l;
        while (root != null && root.getNext() != null){
            if(root.getValue().charAt(root.getValue().length()-1) == root.getNext().getValue().charAt(0)){
                Node<String> temp = root.getNext().getNext();
                root.getNext().setNext(null);
                root.setNext(temp);
                root = head;
            }
            else
                root = root.getNext();
        }
        return head;
    }




}