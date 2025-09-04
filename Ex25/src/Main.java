import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Program.Lottery();
        Program.elections();
        Program.Lottery427();
        Program.threeB();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Num: ");
        int j = scanner.nextInt();
        System.out.println(Program.printArray(Program.fourth(j)));
    }
}