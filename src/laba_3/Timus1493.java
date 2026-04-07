package laba_3;
import java.util.Scanner;

public class Timus1493 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String ticket = scanner.nextLine();

        int sumFirst = 0;
        int sumLast = 0;

        for (int i = 0; i < 3; i++) {
            sumFirst += ticket.charAt(i) - '0';
        }

        for (int i = 3; i < 6; i++) {
            sumLast += ticket.charAt(i) - '0';
        }

        if (Math.abs(sumFirst - sumLast) == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
