package lr6;

import java.util.Scanner;

public class Timus1585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int emp = 0, little = 0, mac = 0, count = 0;

        while (count < n) {
            String s = sc.nextLine();

            if (s.matches("\\d+")) {
                System.out.println("введите название пингвина");
                continue;
            }

            if (!s.endsWith("Penguin")) {
                System.out.println("введите название пингвина");
                continue;
            }

            switch (s) {
                case "Emperor Penguin":
                    emp++;
                    count++;
                    break;
                case "Little Penguin":
                    little++;
                    count++;
                    break;
                case "Macaroni Penguin":
                    mac++;
                    count++;
                    break;
                default:
                    System.out.println("введите название пингвина");
            }
        }

        if (emp > little && emp > mac)
            System.out.println("Emperor Penguin");
        else if (little > emp && little > mac)
            System.out.println("Little Penguin");
        else
            System.out.println("Macaroni Penguin");
    }
}
