package lr7;
import java.io.*;
import java.util.Scanner;

public class Example1_5 {
    public static void main(String[] args) {
        String inputFileName = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/input.txt";
        String outputFileName = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/output.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст для файла: ");
        String data = scanner.nextLine();
        try {
            File inputFile = new File(inputFileName);

            // создание файла перед чтением
            if (!inputFile.exists()) {
                inputFile.createNewFile();
            }

            // запись текста в input.txt
            BufferedWriter inputWriter = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(inputFileName), "UTF-8"));

            inputWriter.write(data);
            inputWriter.close();

        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }

        try (InputStream inputStream = new FileInputStream(inputFileName);
             InputStreamReader inputStreamReader =
                     new InputStreamReader(inputStream, "UTF-8");
             BufferedReader bufferedReader =
                     new BufferedReader(inputStreamReader);
             OutputStream outputStream =
                     new FileOutputStream(outputFileName);
             OutputStreamWriter outputStreamWriter =
                     new OutputStreamWriter(outputStream, "UTF-8");
             BufferedWriter bufferedWriter =
                     new BufferedWriter(outputStreamWriter)) {

            bufferedWriter.write(data);
            bufferedWriter.newLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }

            System.out.println("Данные записаны в файл: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}