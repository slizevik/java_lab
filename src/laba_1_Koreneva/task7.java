package laba_1_Koreneva;
import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input age:");
        int age = in.nextInt();

        int birthYear = 2026 - age;

        System.out.println("Your birth year: " + birthYear);

        in.close();
    }
}
