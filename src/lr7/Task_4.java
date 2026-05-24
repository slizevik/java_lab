package lr7;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task_4 {
    public static void main(String[] args) {
        String inputPath = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/output.txt";
        String outputPath = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/copy_output.txt";

        try (FileReader reader = new FileReader(inputPath);
             FileWriter writer = new FileWriter(outputPath)) {

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            System.out.println("Файл скопирован успешно!");
            System.out.println("Исходный файл: " + inputPath);
            System.out.println("Файл назначения: " + outputPath);

        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
