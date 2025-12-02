package Queues;

import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;
    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            this.grades[i] = grades[i];
        }

    }
    public String getName() {
        return name;
    }
    public int[] getGrades() {
        int[] grades1 = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            grades1[i] = grades[i];
        }
        return grades1;
    }
    // מחזירה את ממוצע הציונים של התלמיד
    public double average() {
        int sum = 0;
        for (int grade : grades) sum += grade;
        return (double)sum / grades.length;
    }
    public String toString() {
        return name;
    }
    public int getLowestGrade(){
        int min = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < min) min = grades[i];
        }
        return min;
    }
}