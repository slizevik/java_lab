package laba_1_Koreneva;
import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input name:");
        String name = in.nextLine();

        System.out.println("Input birth year:");
        int birthYear = in.nextInt();

        int age = 2026 - birthYear;

        System.out.println("Name: " + name + ", Age: " + age);

        in.close();
    }
}
