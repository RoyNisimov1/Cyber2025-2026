public class P1 {

    public static void main(String[] args){
        System.out.println(ex1(5));
        System.out.println(ex2(5));
        System.out.println(ex3(7));
        System.out.println(ex4(24));
        System.out.println(ex5(5, 3));
        System.out.println(ex6(5, 6));
        System.out.println(ex7(15, 3));
        System.out.println(ex8(12, 2));
        System.out.println(ex9(1, 2));
    }

    public static int ex1(int num){
        if (num <=1) return 1;
        return num + ex1(num-1);
    }
    public static int ex2(int num){
        if (num <=1) return 1;
        return num * ex2(num-1);
    }
    public static int ex3(int num){
        if (num <=1) return 1;
        if (num % 2 == 0) return ex3(num-1);
        return num * ex3(num-2);
    }
    public static int ex4(int num){
        return ex4Helper(num, 0);
    }
    public static int ex4Helper(int n, int c){
        if (n <=0) return c;
        return ex4Helper(n/10, c+1);
    }
    public static int ex5(int num1, int num2){
        return ex5Helper(num1, num2, 0);
    }
    public static int ex5Helper(int n, int n1, int i){
        if (n <=0 || n < n1) return i;
        return ex5Helper(n-n1, n1, i+1);
    }
    public static int ex6(int num1, int num2){
        if (num1-num2 > 0) return ex6(num1-num2, num2);
        if (num1-num2 == 0) return 0;
        return num1;
    }

    public static boolean ex7(int y, int x){
        if (y-x > 0) return ex7(y-x, x);
        return y - x == 0;
    }

    public static boolean ex8(int n, int y){
        if (Math.sqrt(n) == y) return true;
        if (n%y == 0) return false;
        return ex8(n, y+1);
    }

    public static boolean ex9(int num, int last_state){
        // last_state:
        // 2 first digit
        // 1 odd
        // 0 even
        if (num == 0) return true;
        if (last_state == 2){
            return ex9(num, (num % 10) % 2);
        }
        if ((num % 10) % 2 != last_state) return false;
        return ex9(num / 10, (num % 10) % 2);

    }
}
