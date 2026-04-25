package lr5;
import java.util.*;

public class Timus1457 {
    public class Main {
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);

            int N = in.nextInt();

            double sum = 0;

            for (int i = 0; i < N; i++) {
                sum += in.nextInt();
            }

            double result = sum / N;

            // вывод с 6 знаками после запятой
            System.out.printf("%.6f\n", result);
        }
    }
}

