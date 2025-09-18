public class P26 {

    public static void main(String[] args){
        System.out.println(ex1(5));
        System.out.println(ex2(5));
        System.out.println(ex3(7));
        System.out.println(ex4(24));
        System.out.println(ex5(5, 3));
        System.out.println(ex6(5, 6));
        System.out.println(ex7(15, 3));
        System.out.println(ex8(12, 2));
        System.out.println(ex9(111, 2));
        System.out.println(ex10(3, 0));
        System.out.println(ex11(2, 0.0));
        System.out.println(ex13(4));
        System.out.println(ex13b(5, 0));
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

    public static int ex10(int i, int acc){
        if (i == 0) {
            return acc;
        }
        int a = ((i%2) == 0) ? i*i : 2*i;
        return ex10(i-1, acc + a);
    }
    public static double ex11(double i, double acc){
        if (i <= 0) {
            return acc;
        }
        double a = i;
        if ((i%2) == 0){
            a = - Math.sqrt(i+1);
        }
        return ex11(i-1, acc + a);
    }
    public static int ex13(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        int last_one = ex13(n - 1);
        int last_second = ex13(n - 2);
        return last_one * last_one + last_second * last_second;
    }
    public static int ex13b(int n,int acc){
        if (n <= 0) return acc;
        int a = ex13(n);
        return ex13b(n-1, acc + a);
    }
}

