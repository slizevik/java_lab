package laba_3;

public class Example1_5 {

        public static long fib(int n) {
            System.out.println("  Входим в fib(" + n + ")");

            if (n == 0) {
                System.out.println("  Выходим из fib(0) → 0");
                return 0;
            }
            if (n == 1) {
                System.out.println("  Выходим из fib(1) → 1");
                return 1;
            }

            long a = fib(n - 1);
            long b = fib(n - 2);
            long result = a + b;

            System.out.println("  Выходим из fib(" + n + ") → " + result);
            return result;
        }

        public static void main(String[] args) {
            System.out.println("Число Фибоначчи и дерево рекурсивных вызовов");
            int number = 5;
            System.out.println("fib(" + number + ") = " + fib(number));
        }
    }

