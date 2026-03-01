package laba_1_Koreneva;
import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input first number:");
        int num1 = in.nextInt();

        System.out.println("Input second number:");
        int num2 = in.nextInt();

        int sum = num1 + num2;

        System.out.println("Sum: " + sum);

        in.close();
    }
}
