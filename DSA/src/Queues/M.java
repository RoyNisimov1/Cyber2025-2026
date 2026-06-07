package Queues;

public class M {
    public static void main(String[] args){
        Queue<Integer> q = new Queue<>();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        System.out.println(q);
        System.out.println(isUnique(q));
    }

    public static <T> boolean isInQueue(Queue<T> q, T val){
        Queue<T> temp = new Queue<>();
        boolean ret = false;
        while (!q.isEmpty()){
            if (val == q.head()) ret = true;
            temp.insert(q.remove());
        }
        while (!temp.isEmpty()){
            q.insert(temp.remove());
        }
        return ret;
    }

    public static <T> boolean isUnique(Queue<T> q){
        if(q.isEmpty()) return true;
        Queue<T> temp = new Queue<>();
        boolean ret = true;
        while (!q.isEmpty()){
            if(isInQueue(temp, q.head())) ret = false;
            temp.insert(q.remove());
        }
        while (!temp.isEmpty()){
            q.insert(temp.remove());
        }
        return ret;
    }


}
