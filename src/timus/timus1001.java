package timus;
import java.util.ArrayList;
import java.util.Scanner;

public class timus1001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Long> numbers = new ArrayList<>();

        while (in.hasNextLong()) {
            numbers.add(in.nextLong());
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            double sqrt = Math.sqrt(numbers.get(i));
            System.out.printf("%.4f%n", sqrt);
        }

        in.close();
    }
}
