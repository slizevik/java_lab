package lr7;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Timus1617 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        // считываем диаметры и считаем количество
        for (int i = 0; i < n; i++) {
            int diameter = scanner.nextInt();

            map.put(diameter, map.getOrDefault(diameter, 0) + 1);
        }

        int wagons = 0;

        // считаем количество вагонов
        for (int count : map.values()) {
            wagons += count / 4;
        }

        System.out.println(wagons);
    }
}

