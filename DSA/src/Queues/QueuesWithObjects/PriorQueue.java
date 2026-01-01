package Queues.QueuesWithObjects;

import Queues.Queue;

public class PriorQueue {



    @Override
    public String toString() {
        return this.queue.toString();
    }

    private Queue<Patient> queue;
    public PriorQueue(){
        this.queue = new Queue<>();
    }

    public void insert(Patient p){
        Queue<Patient> t = new Queue<>();
        boolean inserted = false;
        while (!this.queue.isEmpty()){
            if (!inserted && p.getPriority() > this.queue.head().getPriority()){
                t.insert(p);
                inserted = true;
            }
            t.insert(this.queue.remove());
        }
        if (!inserted) t.insert(p);
        while (!t.isEmpty()) this.queue.insert(t.remove());
    }

    public Patient get(){
        if(this.queue.isEmpty()) return null;
        return this.queue.head();
    }
    public Patient set(){
        if(this.queue.isEmpty()) return null;

        return this.queue.remove();
    }



    public Queue<Patient> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Patient> queue) {
        this.queue = queue;
    }
}
