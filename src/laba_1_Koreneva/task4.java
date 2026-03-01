package laba_1_Koreneva;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input month:");
        String month = in.nextLine();

        System.out.println("Input number of days:");
        int days = in.nextInt();

        System.out.println("Month " + month + " has " + days + " days");

        in.close();
    }
}
