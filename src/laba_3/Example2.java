package laba_3;
import java.util.Scanner;

public class Example2 {
    public static String toBinary(int n) {
        if (n == 0) return "0";
        if (n == 1) return "1";
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Перевод в двоичную систему\nВведите число: ");
        int number = scanner.nextInt();
        System.out.println(toBinary(number));
    }
}
