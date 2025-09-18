public class Main {
    public static void main(String[] args) {

        System.out.println(factorial(5));
    }

    public static int factorial(int num){
        if (num <= 1){
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static void printRevNum(int n){
        if (n <= 0){
            System.out.print(0);
            return;
        }
        System.out.println(wrapper(n, ""));
    }
    public static String wrapper(int num, String s){
        if (num <= 0){
            return s;
        }
        s += (num % 10);
        return wrapper(num / 10, s);
    }
}