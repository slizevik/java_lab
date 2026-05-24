package lr7;
import java.util.Scanner;

public class Timus1607 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt(); // старт Пети
        int b = scanner.nextInt(); // шаг Пети
        int c = scanner.nextInt(); // старт таксиста
        int d = scanner.nextInt(); // шаг таксиста

        while (a < c) {
            a += b;

            if (a >= c) {
                break;
            }

            c -= d;
        }

        System.out.println(a);
    }
}

