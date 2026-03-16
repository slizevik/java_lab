package laba_2;
import java.util.Scanner;
import java.util.ArrayList;

public class timus1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Y = scanner.nextInt();

        ArrayList<Integer> results = new ArrayList<>();

        for (int X = 0; X < M; X++) {
            if (modPow(X, N, M) == Y) {
                results.add(X);
            }
        }

        if (results.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.print(results.get(i));
                if (i < results.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }

    public static int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base % mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp = exp / 2;
        }

        return (int) result;
    }
}
