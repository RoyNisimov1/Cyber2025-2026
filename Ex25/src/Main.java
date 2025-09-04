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
        while (j != -1){
            int[] fourth = Program.fourth(j);
            int m = 0;
            for (int i = 0; i < fourth.length; i++) {
                if (fourth[i] > fourth[m]){
                    m = i;
                }
            }
            System.out.println(m);
            System.out.println("Num: ");
            j = scanner.nextInt();
        }

    }
}