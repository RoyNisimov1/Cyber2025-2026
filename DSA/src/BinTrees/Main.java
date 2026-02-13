package BinTrees;

import Queues.Queue;

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
        System.out.println("-------------------------------");
        ex14(root);
        System.out.println("-------------------------------");

        ex15(root);
        BinNode<Character> root2 = new BinNode<>('a');
        root2.setLeft(new BinNode<Character>('d'));
        ex16(root2);
        System.out.println(root2);
        System.out.println("-------------------------------");
        System.out.println(root);
        ex17(root);
        System.out.println(root);
        System.out.println("-------------------------------");
        root = new BinNode<>(4);
        root.setLeft(new BinNode<>(4));
        root.getLeft().setLeft(new BinNode<>(4));
        root.setRight(new BinNode<>(5));
        root.getRight().setLeft(new BinNode<>(5));
        root.getRight().setRight(new BinNode<>(5));
        System.out.println(root);
        System.out.println(ex18(root, 2));
        System.out.println("-------------------------------");
        System.out.println(root);
        System.out.println(ex19(root));
        System.out.println("-------------------------------");
        System.out.println(root);
        System.out.println(ex20(root));
        System.out.println("-------------------------------");
        BinNode<Queue<Integer>> root3 = new BinNode<>(new Queue<>());
        root3.getValue().insert(5);
        root3.getValue().insert(10);
        root3.setLeft(new BinNode<>(new Queue<>()));
        root3.getLeft().getValue().insert(9);
        root3.getLeft().getValue().insert(11);
        System.out.println(root3);
        System.out.println(ex23(root3));
        System.out.println("-------------------------------");
        root = new BinNode<>(7);
        root.setLeft(new BinNode<>(4));
        root.getLeft().setLeft(new BinNode<>(2));
        root.setRight(new BinNode<>(9));
        root.getRight().setLeft(new BinNode<>(4));
        root.getRight().setRight(new BinNode<>(10));
        System.out.println(root);
        System.out.println(sum(root));
        System.out.println(ex25(root));
        System.out.println("-------------------------------");
        Queue<BinNode<Integer>> q = new Queue<>();
        q.insert(root);
        ex29(q);
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

    public static <T> void ex14(BinNode<T> root){
        if(root==null) return;
        ex14(root.getLeft());
        ex14(root.getRight());

        System.out.println(root.getValue());
    }

    public static void ex15(BinNode<Integer> root){
        if(root==null) return;
        root.setValue(root.getValue()+1);
        ex15(root.getLeft());
        ex15(root.getRight());
    }
    public static void ex16(BinNode<Character> root){
        if(root==null) return;
        ex16(root.getLeft());
        ex16(root.getRight());

        root.setValue((char) ((int)root.getValue()+1));
    }

    public static void ex17(BinNode<Integer> root){
        if(root==null) return;
        int c = 0;
        if(root.hasLeft()) c+=root.getLeft().getValue();
        if(root.hasRight()) c+=root.getRight().getValue();
        root.setValue(c);
        ex17(root.getLeft());
        ex17(root.getRight());
    }

    public static <T> BinNode<T> ex18(BinNode<T> root, T target){
        if(root==null) return null;
        if(root.hasLeft() && root.getLeft().getValue() == target) return root;
        if(root.hasRight() && root.getRight().getValue() == target) return root;
        BinNode<T> l = ex18(root.getLeft(), target);
        if (l!=null) return l;
        return ex18(root.getRight(), target);
    }

    public static boolean ex19(BinNode<Integer> root){
        if(root == null) return true;
        if(root.hasLeft()){
            if(root.getLeft().getValue() == root.getValue()){
                if(ex19(root.getLeft())) return true;
            }
        }
        if(root.hasRight()){
            if(root.getRight().getValue() == root.getValue()){
                if(ex19(root.getRight())) return true;
            }
        }
        if(!root.hasLeft() && !root.hasRight()) return true;
        return false;
    }
    public static int ex20(BinNode<Integer> root){
//???
        return -1;
    }

    public static int maxInt(Queue<Integer> q){
        Queue<Integer> t = new Queue<>();
        int max = q.head();
        while (!q.isEmpty()){
            if(q.head()>max) max = q.head();
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return max;
    }


    public static int ex23(BinNode<Queue<Integer>> root){
        if(root==null) return Integer.MIN_VALUE;
        if(root.hasLeft() && !root.hasRight()) return ex23(root.getLeft());
        if(!root.hasLeft() && root.hasRight()) return ex23(root.getRight());
        if(root.hasLeft() && root.hasRight()) return Math.max(ex23(root.getLeft()), ex23(root.getRight()));
        return maxInt(root.getValue());
    }

    public static int sum(BinNode<Integer> root){
        if(root==null) return 0;
        return root.getValue() + sum(root.getLeft()) + sum(root.getRight());
    }

    public static boolean ex25(BinNode<Integer> root){
        if(root==null || (!root.hasLeft() && !root.hasRight())) return true;
        int sumLeft = sum(root.getLeft());
        int sumRight = sum(root.getRight());
        if(!root.hasLeft() && sumRight < root.getValue()) return false;
        if(!root.hasRight() && sumLeft > root.getValue()) return false;
        if(root.hasLeft() && root.hasRight() && (sumRight < root.getValue() || sumLeft > root.getValue())) return false;
        return ex25(root.getLeft()) && ex25(root.getRight());
    }



    public static <T> boolean ex26(BinNode<T> root1, BinNode<T> root2){
        if(root1 == null && root2 == null) return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        if(root1.getValue() != root2.getValue()) return false;
        return ex26(root1.getLeft(), root2.getLeft()) && ex26(root1.getRight(), root2.getRight());
    }
    //26 is same as 27
    public static <T> boolean ex28(BinNode<T> root1, BinNode<T> root2){
        if(root1 == null && root2 == null) return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        if(root1.getValue() != root2.getValue()) return false;
        return ex28(root1.getLeft(), root2.getRight()) && ex28(root1.getRight(), root2.getLeft());
    }

    public static <T> void ex29(Queue<BinNode<T>> q){
        if(q.isEmpty()) return;
        BinNode<T> root = q.remove();
        if(root.hasLeft()) q.insert(root.getLeft());
        if(root.hasRight()) q.insert(root.getRight());
        System.out.println(root.getValue());
        ex29(q);
    }

    public static boolean ex30(BinNode<Integer> r){
        if(r==null) return true;
        if(r.hasLeft() && r.getLeft().getValue() >= r.getValue()) return false;
        if(r.hasRight() && r.getRight().getValue() >= r.getValue()) return false;
        return ex30(r.getLeft()) && ex30(r.getRight());
    }
}
