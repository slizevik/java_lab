package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        System.out.print("Введите слово для поиска: ");
        String searchWord = scanner.nextLine();


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                // Проверяем, содержит ли строка искомое слово (без учета регистра)
                if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                    System.out.println("Строка " + lineNumber + ": " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Слово \"" + searchWord + "\" не найдено в файле.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();
    }
}
