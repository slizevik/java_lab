package laba_3;

public class Example1_2 {
        public static void printReverse(int x) {
            if (x >= 20) {
                return;
            }
            printReverse(2 * x + 1);
            System.out.print(x + " ");
        }

        public static void main(String[] args) {
            System.out.println("Последовательность в обратном порядке");
            printReverse(1);
            System.out.println();
        }
    }

