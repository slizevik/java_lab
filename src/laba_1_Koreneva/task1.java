package laba_1_Koreneva;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input Surname: ");
        String name = in.nextLine();

        System.out.println("Input Name: ");
        String surname = in.nextLine();

        System.out.println("Input Last Name: ");
        String lastname = in.nextLine();

        System.out.println("Hello, " + name + " " + surname + " "  + lastname);
    }

}
