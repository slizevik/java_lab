package lr7;
import java.io.File;
import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            long fileSize = file.length();
            System.out.println("Размер файла: " + fileSize + " байт");

            // Дополнительная информация для наглядности
            if (fileSize > 1024) {
                System.out.println("(" + (fileSize / 1024.0) + " КБ)");
            }
            if (fileSize > 1024 * 1024) {
                System.out.println("(" + (fileSize / (1024.0 * 1024.0)) + " МБ)");
            }
        } else if (!file.exists()) {
            System.out.println("Ошибка: Файл не существует!");
        } else if (file.isDirectory()) {
            System.out.println("Ошибка: Указан путь к директории, а не к файлу!");
        }

        scanner.close();
    }
}
