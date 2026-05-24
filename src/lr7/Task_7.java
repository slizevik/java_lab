package lr7;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу для записи: ");
        String filePath = scanner.nextLine();

        System.out.print("Введите текст для записи в файл: ");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(text);
            int charCount = text.length();
            System.out.println("Текст успешно записан в файл: " + filePath);
            System.out.println("Количество записанных символов: " + charCount);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();
    }
}
