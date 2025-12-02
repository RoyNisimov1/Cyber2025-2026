package Queues;

import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        Queue<Student> students = new Queue<>();
        int[] grades = {95, 92, 93};
        Student Avi = new Student("Avi", grades);
        students.insert(Avi);
        grades[0] = 88;
        grades[1] = 76;
        grades[2] = 90;
        Student Ben = new Student("Ben", grades);
        students.insert(Ben);
        grades[0] = 59;
        grades[1] = 65;
        grades[2] = 70;
        Student Carmit = new Student("Carmit", grades);
        students.insert(Carmit);
        grades[0] = 100;
        grades[1] = 98;
        grades[2] = 99;
        Student Dina = new Student("Dina", grades);
        students.insert(Dina);
        grades[0] = 45;
        grades[1] = 55;
        grades[2] = 60;
        Student Eli = new Student("Eli", grades);
        students.insert(Eli);
        System.out.println(students);

        Queue<Student> q = excellentStudents(students);
        System.out.println(students);
        System.out.println(q);

        Queue<Student> q1 = new Queue<>();
        q1.insert(Avi);
        q1.insert(Ben);
        Queue<Student> q2 = new Queue<>();
        q2.insert(Carmit);
        q2.insert(Dina);
        q2.insert(Eli);
        Queue<Student>[] studentsQueueArr = new Queue[2];
        studentsQueueArr[0] = q1;
        studentsQueueArr[1] = q2;
        Queue<Student> withF = studentsWithFail(studentsQueueArr);
        System.out.println(withF);
        System.out.println(Arrays.toString(studentsQueueArr));
    }




    // O(n) grows with the number of grades a student has
    public static boolean isExcellent(Student student){
        return student.average() > 90;
    }

    // O(n * m) n = number of students, m = the student with the most grades.
    public static Queue<Student> excellentStudents(Queue<Student> studentQueue){
        Queue<Student> studentQueue1 = new Queue<>();
        Queue<Student> t = new Queue<>();
        while (!studentQueue.isEmpty()){
            if (isExcellent(studentQueue.head())) studentQueue1.insert(studentQueue.head());
            t.insert(studentQueue.remove());
        }
        while (!t.isEmpty()) studentQueue.insert(t.remove());
        return studentQueue1;
    }

    //O(N * m * z) N = length of the array, m = longest queue, z = the student with the most amount of grades.
    public static Queue<Student> studentsWithFail(Queue<Student>[] studentQueues){
        Queue<Student> failingStudents = new Queue<>();
        for (Queue<Student> studentQueue : studentQueues) {
            Queue<Student> t = new Queue<>();
            while (!studentQueue.isEmpty()) {
                if (studentQueue.head().getLowestGrade() < 60) failingStudents.insert(studentQueue.head());
                t.insert(studentQueue.remove());
            }
            while (!t.isEmpty()) {
                studentQueue.insert(t.remove());
            }
        }
        return failingStudents;
    }


    //5 Adding an average var that changes when changing a grade is worth it because it will significantly reduce the call time to get the average. we won't need to calculate it every time.
}
