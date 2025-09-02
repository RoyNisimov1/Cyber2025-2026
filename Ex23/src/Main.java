import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 10;
        Lion[] lions = new Lion[n];
        String name;
        int age;
        double weight;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            System.out.println("Name #"+j+": ");
            name = scanner.nextLine();
            System.out.println("Age #"+j+": ");
            age = scanner.nextInt();
            System.out.println("Weight #"+j+": ");
            weight = scanner.nextDouble();
            lions[i] = new Lion(name, weight, age);
            scanner.nextLine(); // why is java like this, how does this help
        }
        System.out.println("Average weight: " + Lion.averageWeight(lions));
        System.out.println("Number of dangerous lions: " + Lion.numberOfDangerousLions(lions));
    }
}