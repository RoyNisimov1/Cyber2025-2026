package BinTrees;

public class Main2 {


    public static void main(String[] args){
        BinNode<Integer> root = new BinNode<>(6);
        root.setLeft(new BinNode<>(2));
        root.setRight(new BinNode<>(8));
        root.getLeft().setLeft(new BinNode<>(1));
        root.getLeft().setRight(new BinNode<>(4));
        root.getLeft().getRight().setLeft(new BinNode<>(3));
        root.getLeft().getRight().setRight(new BinNode<>(5));
        System.out.println("Pre");

        preOrder(root);
        System.out.println();
        System.out.println("In");
        inOrder(root);
        System.out.println();
        System.out.println("Post");
        postOrder(root);
    }
    public static <T> void preOrder(BinNode<T> bt){
        if(bt==null) return;
        System.out.print(bt.getValue() + " ");
        preOrder(bt.getLeft());
        preOrder(bt.getRight());
    }
    public static <T> void inOrder(BinNode<T> bt){
        if(bt==null) return;
        preOrder(bt.getLeft());
        System.out.print(bt.getValue() + " ");

        preOrder(bt.getRight());
    }

    public static <T> void postOrder(BinNode<T> bt){
        if(bt==null) return;
        preOrder(bt.getLeft());
        preOrder(bt.getRight());
        System.out.print(bt.getValue() + " ");
    }

}
