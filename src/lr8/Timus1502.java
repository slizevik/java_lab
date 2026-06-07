package lr8;
import java.util.Scanner;

public class Timus1502 {
    public static void main(String[] args) {
        System.out.println("Ведите количество точек");
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long result = n * (n + 1) * (n + 2) / 2;

        System.out.println(result);
    }
}
