package BinTrees;

public class M3 {
    public static void main(String[] args){
        BinNode<Integer> root = new BinNode<>(5);
        root.setLeft(new BinNode<>(4));
        root.getLeft().setLeft(new BinNode<>(2));
        root.setRight(new BinNode<>(3));
        root.getRight().setLeft(new BinNode<>(4));
        root.getRight().setRight(new BinNode<>(4));
        System.out.println(root);
        System.out.println(ex10(root));

        BinNode<String> r = new BinNode<>(new BinNode<>(new BinNode<>("D"), "B", new BinNode<>("E")), "A", new BinNode<>(new BinNode<>("F"), "C", null));
        printPreOrder(r);
        System.out.println("\n");
        printInOrder(r);
        System.out.println("\n");
        printPostOrder(r);
        System.out.println("\n");


        BinNode<Integer> rr = new BinNode<>(new BinNode<>(new BinNode<>(3), 2, new BinNode<>(2)), 1, new BinNode<>(null, 9, new BinNode<>(5)));
        System.out.println(rr);
        printAll(rr, "");
        printAllNoS(rr);
    }

    public static int ex10(BinNode<Integer> t){
        if(t == null) return 0;
        int leftVal = 0;
        if(t.hasLeft()) leftVal = t.getLeft().getValue();
        int rightVal = 0;
        if(t.hasRight()) rightVal = t.getRight().getValue();

        if(t.getValue() > leftVal+rightVal && leftVal+rightVal != 0) return 1 + ex10(t.getLeft()) + ex10(t.getRight());
        return ex10(t.getLeft()) + ex10(t.getRight());

    }

    public static <T> void printInOrder(BinNode<T> t){
        if(t==null) {
            return;
        }
        printInOrder(t.getLeft());
        System.out.print(t.getValue());
        printInOrder(t.getRight());
    }
    public static <T> void printPostOrder(BinNode<T> t){
        if(t==null) {
            return;
        }
        printPostOrder(t.getLeft());
        printPostOrder(t.getRight());
        System.out.print(t.getValue());
    }
    public static <T> void printPreOrder(BinNode<T> t){
        if(t==null) {
            return;
        }
        System.out.print(t.getValue());
        printPreOrder(t.getLeft());
        printPreOrder(t.getRight());

    }

    public static void printAll(BinNode<Integer> root, String s){
        if (root == null) return;
        s += root.getValue();
        if (!root.hasLeft() && ! root.hasRight()) System.out.println(s);
        printAll(root.getLeft(), s);
        printAll(root.getRight(), s);

    }
    public static void printAllNoS(BinNode<Integer> root){
        if (root == null) return;
        System.out.print(root.getValue());
        if (!root.hasLeft() && ! root.hasRight()) System.out.println("");
        printAllNoS(root.getLeft());
        printAllNoS(root.getRight());

    }

}
