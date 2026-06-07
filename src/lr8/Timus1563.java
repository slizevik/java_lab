package lr8;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Timus1563 {
    public static void main(String[] args) {
        System.out.println("Введите колчичество магазинов");

        Scanner scanner = new Scanner(System.in);

        // Проверяем, есть ли ввод
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        // Считываем остаток строки
        scanner.nextLine();

        Set<String> uniqueStores = new HashSet<>();
        System.out.println("Введите названия магазинов");

        for (int i = 0; i < n; i++) {
            String storeName = scanner.nextLine();
            uniqueStores.add(storeName);
        }

        // Количество "БАЯН" = Общее количество - Количество уникальных магазинов
        int bayanCount = n - uniqueStores.size();

        System.out.println(bayanCount);

        scanner.close();
    }
}
