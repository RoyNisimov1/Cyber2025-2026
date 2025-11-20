import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] i = {1, 2, 4};
        System.out.println(i.length);
        System.out.println(Program.B2C("abcdB"));
        System.out.println(Program.doesNotContainDigits("abcdB4"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("String: ");
        String s = scanner.nextLine();
        if (Program.firstIsLast(s)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
        System.out.println("String: ");
        s = scanner.nextLine();
        System.out.println(Program.NumberOfWords(s));
        System.out.println("String: ");
        s = scanner.nextLine();
        System.out.println(Program.isJavaParsable(s));
        System.out.println("String is palindrome: ");
        s = scanner.nextLine();
        while (!Objects.equals(s, "")){
            System.out.println(Program.isPalindrome(s));
            System.out.println("String is palindrome: ");
            s = scanner.nextLine();
        }
        System.out.println("String: ");
        s = scanner.nextLine();
        System.out.println(Program.setLike(s));
        System.out.println("String: ");
        s = scanner.nextLine();
        System.out.println(Program.sequences(s));
        System.out.println("Pass: ");
        s = scanner.nextLine();
        System.out.println(Program.isGoodPass(s));
    }

}