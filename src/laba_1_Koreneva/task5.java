package laba_1_Koreneva;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input birth year:");
        int birthYear = in.nextInt();

        int age = 2026 - birthYear;

        System.out.println("Your age: " + age);

        in.close();
    }
}
