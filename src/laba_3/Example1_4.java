package laba_3;

public class Example1_4 {

        public static long factorial(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            return n * factorial(n - 1);
        }

        public static void main(String[] args) {
            System.out.println("Факториал");
            int number = 5;
            System.out.println(number + "! = " + factorial(number));
        }
    }

