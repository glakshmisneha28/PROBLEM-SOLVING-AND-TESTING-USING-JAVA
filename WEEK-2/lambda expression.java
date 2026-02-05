import java.io.*;
import java.util.*;
import java.util.function.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a <= 1) return false;
            if (a == 2) return true;
            if (a % 2 == 0) return false;
            for (int i = 3; i * i <= a; i += 2) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return (int a) -> {
            String s = String.valueOf(a);
            return s.equals(new StringBuilder(s).reverse().toString());
        };
    }

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int condition = Integer.parseInt(input[0]);
            int number = Integer.parseInt(input[1]);

            PerformOperation op;
            boolean result;

            if (condition == 1) {
                op = MyMath.isOdd();
                result = MyMath.checker(op, number);
                System.out.println(result ? "ODD" : "EVEN");
            } else if (condition == 2) {
                op = MyMath.isPrime();
                result = MyMath.checker(op, number);
                System.out.println(result ? "PRIME" : "COMPOSITE");
            } else if (condition == 3) {
                op = MyMath.isPalindrome();
                result = MyMath.checker(op, number);
                System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
            }
        }
    }
}
