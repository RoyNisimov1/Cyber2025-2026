import java.util.*;

public class Program {

    public static String printArray(int[] k){
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < k.length; i++) {
            s.append(Integer.toString(k[i]));
            if (i != k.length-1){
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
    public static void Lottery(){
        int[] l = new int[10];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {

            int randomNumber = random.nextInt(10);
            l[randomNumber] += 1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Number #"+(i+1) + " showed " + l[i]);
        }
    }

    public static void elections(){
        Scanner scanner = new Scanner(System.in);
        String s = "1";
        int[] choices = new int[10];
        while (!Objects.equals(s, "0")) {
            System.out.println("ID: ");
            s = scanner.nextLine();
            if(s.equals("0")) break;
            System.out.println("First choice: ");
            int j = Integer.parseInt(scanner.nextLine());
            choices[j+1] += 3;
            System.out.println("Second choice: ");
            j = Integer.parseInt(scanner.nextLine());
            choices[j+1] += 2;
            System.out.println("Third choice: ");
            j = Integer.parseInt(scanner.nextLine());
            choices[j+1] += 1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Number #"+(i+1) + " showed " + choices[i]);
        }

    }
    public static void Lottery427(){
        int[] keySet = new int[27];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(4, 27);
            keySet[index]++;
        }
        int c = 0;
        for (int i = 3; i < 27; i++) {
            if (keySet[i] > keySet[c]){
                c=i;
            }
        }
        System.out.println("Top: " + (c+1) + " showed up: " + keySet[c]);
        System.out.println(Program.printArray(keySet));
    }
    public static void threeB(){
        int[] l = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(4, 27);
            l[i] = randomNumber;
        }
        int[] c = new int[27];
        for (int i = 0; i < 10; i++) {
            c[l[i]]++;
        }
        int highest = 0;
        for (int i = 0; i < 27; i++) {
            if (c[i] > c[highest]){
                highest = i;
            }
        }
        System.out.println(highest);
        System.out.println(Arrays.toString(l));
    }
    public static int[] fourth(int num){
        String s = String.valueOf(num);
        int[] frequency = new int[10];
        for (int c = 0; c < s.length(); c++) {
            int j = Integer.parseInt(String.valueOf(s.charAt(c)));
            frequency[j] ++;
        }
        return frequency;
    }

}
