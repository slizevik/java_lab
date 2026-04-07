package laba_3;

public class Example1_3 {
    public static void printBeforeAfter(int x) {
        if (x >= 20) {
            return;
        }
        System.out.println("Перед вызовом: " + x);
        printBeforeAfter(2 * x + 1);
        System.out.println("После вызова: " + x);
    }

    public static void main(String[] args) {
        System.out.println("До и после рекурсивного вызоа");
        printBeforeAfter(1);
    }
}
