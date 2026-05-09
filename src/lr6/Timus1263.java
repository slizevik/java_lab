package lr6;
import java.util.*;

public class Timus1263 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] votes = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            votes[x]++;
        }

        for (int i = 1; i <= n; i++) {
            double percent = (votes[i] * 100.0) / m;
            System.out.printf("%.2f%n", percent);
        }
    }
}

