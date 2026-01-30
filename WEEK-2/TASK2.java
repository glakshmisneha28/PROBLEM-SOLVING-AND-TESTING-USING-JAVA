package PSTJ;

import java.util.*;
import java.util.function.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }
    public static PerformOperation isPrime() {
        return n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        };
    }
    public static PerformOperation isPalindrome() {
        return n -> {
            int original = n, reverse = 0;
            while (n > 0) {
                reverse = reverse * 10 + n % 10;
                n /= 10;
            }
            return original == reverse;
        };
    }

    public static boolean checker(PerformOperation op, int num) {
        return op.check(num);
    }
}

public class TASK2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int type = sc.nextInt();
            int num = sc.nextInt();

            PerformOperation op;
            boolean result;

            if (type == 1) {
                op = MyMath.isOdd();
                result = MyMath.checker(op, num);
                System.out.println(result ? "ODD" : "EVEN");

            } else if (type == 2) {
                op = MyMath.isPrime();
                result = MyMath.checker(op, num);
                System.out.println(result ? "PRIME" : "COMPOSITE");

            } else if (type == 3) {
                op = MyMath.isPalindrome();
                result = MyMath.checker(op, num);
                System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
            }
        }
        sc.close();
    }
}
