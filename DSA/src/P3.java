public class P3 {

    public static void main(String[] args) {
        // Q1
        Queue<Integer> q1 = new Queue<>();
        q1.insert(3);
        q1.insert(3);
        q1.insert(7);
        q1.insert(1);
        q1.insert(3);
        q1.insert(9);
        q1.insert(5);
        q1.insert(3);
        System.out.println(q1);
        Queue<Integer> q2 = new Queue<>();
        q2.insert(3);
        q2.insert(9);
        q2.insert(5);
        q2.insert(3);
        System.out.println(q2);

        //Q2
        System.out.println(count(q1, 3));

        //Q3
        System.out.println(equals(q1, q2));
        System.out.println(q1);
        System.out.println(q2);


        Queue<Integer> q3 = new Queue<>();
        q3.insert(3);
        q3.insert(3);
        q3.insert(7);
        q3.insert(1);
        q3.insert(3);
        q3.insert(9);
        q3.insert(5);
        q3.insert(3);
        System.out.println(equals(q1, q3));
        System.out.println(q1);
        System.out.println(q3);


        //Q4
        int min = removeMin(q1);
        System.out.println(q1);
        if (min >2) System.out.println("big");
        else System.out.println("small");
        System.out.println(removeMin(q1));
        System.out.println(q1);

        //5
        Queue<Character> q4 = new Queue<>();
        q4.insert('a');
        q4.insert('e');
        q4.insert('d');
        q4.insert('a');
        q4.insert('c');
        System.out.println(q4);
        System.out.println(removeMin2(q4));
        System.out.println(q4);


        //6
        Queue<Integer> q5 = new Queue<>();
        q5.insert(9);
        q5.insert(2);
        q5.insert(1);
        q5.insert(5);
        q5.insert(3);
        System.out.println(q5);
        System.out.println(getVal(q5, 1));
        System.out.println(getVal(q5, 6));


        //7
        System.out.println(q4);
        sort(q4);
        System.out.println(q4);

    }

    //Q2
    public static <T> int count(Queue<T> q, T X){
        int count = 0;
        Queue<T> t = new Queue<>();
        while (!q.isEmpty()){
            if (q.head() == X) count++;
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return count;
    }

    //Q3
    public static boolean equals(Queue<Integer> q1, Queue<Integer> q2){
        Queue<Integer> t1 = new Queue<>();
        Queue<Integer> t2 = new Queue<>();
        boolean ret = true;
        while (!q1.isEmpty()){
            if (!q2.isEmpty()) {
                if (q1.head() != q2.head()) ret = false;
                t2.insert(q2.remove());
            }else ret = false;
            t1.insert(q1.remove());
        }
        while (!q2.isEmpty()){
            ret = false;
            t2.insert(q2.remove());
        }
        while (!t2.isEmpty()){
            q2.insert(t2.remove());
        }
        while (!t1.isEmpty()){
            q1.insert(t1.remove());
        }
        return ret;
    }


    //Q4
    public static int removeMin(Queue<Integer> q){
        Queue<Integer> t = new Queue<>();
        // finding the minimum
        int min = findMin(q);
        while (!q.isEmpty()) {
            if (q.head() != min) t.insert(q.remove());
            else q.remove();
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return min;
    }

    //Q4 find min
    public static int findMin(Queue<Integer> q){
        Queue<Integer> t = new Queue<>();
        int min = q.head();
        while (!q.isEmpty()){
            if (q.head() <= min){
                min = q.head();
            }
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return min;
    }


    //Q5
    public static char removeMin2(Queue<Character> q){
        char cur = q.head();
        Queue<Character> t = new Queue<>();
        while (!q.isEmpty()){
            if(q.head() < cur) cur = q.head();
            t.insert(q.remove());
        }
        boolean removed = false;
        while (!t.isEmpty()) {
            if (removed) q.insert(t.remove());
            else {
                if(t.head() == cur){
                    removed = true;
                    t.remove();
                }
                else q.insert(t.remove());
            }
        }

        return cur;
    }


    //Q6
    public static <T> T getVal(Queue<T> q, int index){
        int i = 1;
        Queue<T> t = new Queue<>();
        T selection = null;
        while (!q.isEmpty()){
            if (i == index){
                selection = q.head();
            }
            i++;
            t.insert(q.remove());
        }
        while (!t.isEmpty()){

            q.insert(t.remove());
        }
        return selection;

    }

    //Q7
    public static void sort(Queue<Character> q){
        Queue<Character> sortedQ = new Queue<>();
        while (!q.isEmpty()){
            sortedQ.insert(removeMin2(q));
        }
        while (!sortedQ.isEmpty()) q.insert(sortedQ.remove());
    }
}
