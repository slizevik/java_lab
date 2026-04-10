package lr4;
import java.util.Scanner;

public class Timus1209 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество чисел ");
        int N = scan.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= N; i++) {
            System.out.print("Введите число ");
            long k = scan.nextLong();
            long d = 1 + 8 * (k - 1);
            long root = (long) Math.sqrt(d);
            if (root * root == d) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }

        }
        System.out.println(result.toString().trim());
        scan.close();

    }
}


