package lr7;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task_3 {
    public static void main(String[] args) {
        String filePath = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/output.txt";
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Количество строк в файле: " + lineCount);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
