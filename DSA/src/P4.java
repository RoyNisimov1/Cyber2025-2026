public class P4 {

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        System.out.println(q);
        System.out.println(isUnique(q));

        Queue<Integer> q1 = new Queue<>();
        q1.insert(2);
        q1.insert(4);
        q1.insert(4);
        q1.insert(5);
        q1.insert(6);
        q1.insert(7);
        q1.insert(6);
        q1.insert(6);
        System.out.println(q1);
        deleteEvenAmountVals(q1);
        System.out.println(q1);


        Queue<Integer> q2 = new Queue<>();
        q2.insert(5);
        q2.insert(6);
        q2.insert(4);
        q2.insert(5);
        q2.insert(3);
        System.out.println(q2);
        System.out.println(pairBigger10(q2));

        Queue<Integer> q3 = new Queue<>();
        q3.insert(5);
        q3.insert(6);
        q3.insert(4);
        q3.insert(3);
        q3.insert(3);
        System.out.println(q3);
        System.out.println(crazy(q3));
    }

    //Q1
    public static <T> boolean isUnique(Queue<T> q){
        if (q.isEmpty()) return true;
        boolean ret = true;
        Queue<T> t = new Queue<>();
        while (!q.isEmpty()){
            if (count(q, q.head()) > 1) ret = false;
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return ret;
    }

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

    //Q2
    public static <T> void deleteEvenAmountVals(Queue<T> q){
        Queue<T> t = new Queue<>();
        Queue<T> og = new Queue<>();
        while (!q.isEmpty()){
            og.insert(q.head());
            t.insert(q.remove());
        }
        while (!t.isEmpty()){
            if (count(og, t.head()) % 2 == 0) {
                deleteValAll(t, t.head());
            }
            else q.insert(t.remove());
        }
    }
    public static <T> void deleteValAll(Queue<T> q, T target){
        Queue<T> t = new Queue<>();
        while (!q.isEmpty()){
            t.insert(q.remove());
        }
        while (!t.isEmpty()){
            T o = t.remove();
            if (o != target) q.insert(o);
        }
    }

    public static int pairBigger10(Queue<Integer> q){
        Queue<Integer> t = new Queue<>();
        int count = 0;
        int last = q.head();
        t.insert(q.remove());
        while (!q.isEmpty()){
            if(q.head() + last > 10) count++;
            last = q.head();
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return count;
    }


    public static <T> boolean crazy(Queue<T> q){
        Queue<T> t = new Queue<>();
        boolean isCrazy = false;
        T last = q.head();
        t.insert(q.remove());
        while (!q.isEmpty()){
            if(last == q.head()){
                isCrazy = true;
            }
            last = q.head();
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return isCrazy;
    }


}
