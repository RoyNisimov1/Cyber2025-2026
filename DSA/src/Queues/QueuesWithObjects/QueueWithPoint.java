package Queues.QueuesWithObjects;

import Queues.Queue;

public class QueueWithPoint {
    public static void main(String[] args) {
        Queue<Point> p = new Queue<>();
        p.insert(new Point(1, 3));
        p.insert(new Point(10, 2));
        p.insert(new Point(15, 40));
        System.out.println(p);
        System.out.println(sumPointsInQueue(p));
        System.out.println(p);
        System.out.println(findClosestPointToOrigin(p));
        System.out.println(p);
    }


    public static Point sumPointsInQueue(Queue<Point> q){
        Queue<Point> t = new Queue<>();
        Point p = new Point(0, 0);
        while (!q.isEmpty()){
            Point c = q.head();
            p.setX(p.getX() + c.getX());
            p.setY(p.getY() + c.getY());
            t.insert(q.remove());
        }
        while (!t.isEmpty()){
            q.insert(t.remove());
        }
        return p;
    }

    public static Point findClosestPointToOrigin(Queue<Point> q){
        Queue<Point> t = new Queue<>();
        Point closestPoint = q.head();
        t.insert(q.remove());
        double closestMag = Math.sqrt((double)(closestPoint.getX()* closestPoint.getX() + closestPoint.getY()*closestPoint.getY()));
        while (!q.isEmpty()){
            Point c = q.head();
            double currentMag = Math.sqrt((double)(c.getX()* c.getX() + c.getY()*c.getY()));
            if (currentMag < closestMag) {
                closestPoint = c;
                closestMag = currentMag;
            }
            t.insert(q.remove());
        }
        while (!t.isEmpty()) q.insert(t.remove());
        return closestPoint;
    }
}
