package lr7;
import java.io.*;
import java.util.Scanner;

public class Example1_6 {
    public static void main(String[] args) {

        String outputFileName = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/output.txt";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для файла:");
        String data = scanner.nextLine();

        try (PrintWriter printWriter =
                     new PrintWriter(outputFileName, "UTF-8")) {

            printWriter.println(data.toUpperCase());

            System.out.println("Данные записаны в файл: " + outputFileName);

        } catch (Exception e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
