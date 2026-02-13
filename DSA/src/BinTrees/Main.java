package BinTrees;

public class Main {
    public static void main(String[] args){
        BinNode<Integer> root = new BinNode<>(5);
        root.setLeft(new BinNode<>(4));
        root.getLeft().setLeft(new BinNode<>(2));
        root.setRight(new BinNode<>(3));
        root.getRight().setLeft(new BinNode<>(4));
        root.getRight().setRight(new BinNode<>(4));
        System.out.println(ex1(root));
        System.out.println(ex2(root));
        System.out.println(ex3(root));
        System.out.println(ex4(root));
        System.out.println(ex5(root));
        System.out.println(ex6(root));
        System.out.println(ex7(root));
        System.out.println(ex8(root));
        System.out.println(root);
        //ex9(root);
        System.out.println(root);
        System.out.println(ex10(root));
        System.out.println(ex11(root));
        System.out.println(ex12(root, 3));
        System.out.println(ex13(root));

        BinNode<Integer> root2 = new BinNode<>(5);
        root2.setLeft(new BinNode<>(4));
        root2.getLeft().setLeft(new BinNode<>(2));
        root2.setRight(new BinNode<>(3));
        root2.getRight().setLeft(new BinNode<>(4));
        root2.getRight().setRight(new BinNode<>(4));

        System.out.println(equal(root, root2));

    }


    public static <T> int ex1(BinNode<T> root){
        int c = 0;
        if(root.hasLeft())
            c+=ex1(root.getLeft()) + 1;
        if(root.hasRight())
            c+=ex1(root.getRight()) + 1;
        return c;
    }

    public static int ex2(BinNode<Integer> root){
        int c = 0;
        c+= root.getValue();
        if(root.hasLeft()){
            c+=ex2(root.getLeft());
        }
        if(root.hasRight()) {
            c+=ex2(root.getRight());
        }
        return c;
    }

    public static int ex3(BinNode<Integer> root){
        int c = 0;
        if(root.getValue()%2==0) c+= root.getValue();
        if(root.hasLeft()){
            c+=ex3(root.getLeft());
        }
        if(root.hasRight()) {
            c+=ex3(root.getRight());
        }
        return c;
    }

    public static <T> boolean ex4(BinNode<T> root){
        return !(root.hasRight() || root.hasLeft());
    }

    public static int ex5(BinNode<Integer> root){
        int c = 0;
        if (root!=null) c++;
        if(root.hasLeft()){
            c+=ex5(root.getLeft());
        }
        if(root.hasRight()) {
            c+=ex5(root.getRight());
        }
        return c;
    }

    public static <T> int ex6(BinNode<T> root){
        int lHeight = 0;
        if(root.hasLeft())
            lHeight = ex6(root.getLeft());
        int rHeight = 0;
        if(root.hasRight())
            rHeight = ex6(root.getRight());
        return Math.max(lHeight, rHeight) + 1;
    }

    public static int ex7(BinNode<Integer> root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(Math.max(root.getValue(), ex7(root.getRight())), ex7(root.getLeft()));
    }

    public static boolean ex8(BinNode<Integer> t) {
        return checkHeight(t) != -1;
    }

    private static int checkHeight(BinNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkHeight(root.getLeft());
        if (leftHeight == -1) return -1;
        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static void ex9(BinNode<Integer> root){
        if(root==null) return;
        if(root.hasLeft() && !root.hasRight()) {
            root.setRight(new BinNode<>(root.getLeft().getValue()));
        }
        if(root.hasRight() && !root.hasLeft()) {
            root.setLeft(new BinNode<>(root.getRight().getValue()));
        }
        ex9(root.getLeft());
        ex9(root.getRight());
    }

    public static int ex10(BinNode<Integer> root){
        int c = 0;
        if(root==null) return 0;
        if(root.hasLeft() && root.getLeft().getValue() < root.getValue() && root.hasRight() && root.getRight().getValue() < root.getValue()) c++;
        c+=ex10(root.getLeft());
        c+=ex10(root.getRight());
        return c;
    }

    public static int ex11(BinNode<Integer> root){
        int c = 0;
        if(root==null) return 0;
        if(root.hasLeft() && !root.hasRight()) {
            c+=root.getLeft().getValue();
        }
        if(root.hasRight() && !root.hasLeft()) {
            c+=root.getRight().getValue();
        }
        c+=ex11(root.getLeft());
        c+=ex11(root.getRight());
        return c;
    }

    public static boolean ex12(BinNode<Integer> root, int x){
        if(root==null) return false;
        if(root.getValue()==x) return true;
        return ex12(root.getRight(), x) || ex12(root.getLeft(), x);
    }

    public static boolean ex13(BinNode<Integer> root){
        if(root==null) return true;
        if(!root.hasRight() && !root.hasLeft()) return true;
        if(root.hasRight() && root.hasLeft()) return ex13(root.getLeft()) && ex13(root.getRight());
        return false;
    }


    public static <T> boolean equal(BinNode<T> root1, BinNode<T> root2){
        if(root1 == null && root2 == null) return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        if(root1.getValue() != root2.getValue()) return false;
        return equal(root1.getLeft(), root2.getLeft()) && equal(root1.getRight(), root2.getRight());
    }
}
