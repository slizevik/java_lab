package lr7;
import java.io.*;
import java.util.Scanner;

public class Example1_3 {
    public static void main(String[] args){
        String fileName = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/example_file.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст для файла: ");
        String data = scanner.nextLine();

        try (FileWriter writer = new FileWriter((fileName))){
            writer.write(data);
            System.out.println("Текст записан в файл "+ fileName);
        } catch (IOException e){
            System.out.println("Ошибка записи " + e.getMessage());
        }

        try (FileReader reader = new FileReader(fileName)){
            char [] buffer = new char[1024];
            int charRead = reader.read(buffer);
            String readData = new String(buffer, 0, charRead);
            System.out.println("Прочитанные данные " + readData);
        } catch (IOException e){
            System.out.println("Не удалось прочитать данные" + e.getMessage());
        }

        if (new File (fileName).delete()) {
            System.out.println("файл удален " + fileName);
        } else {
            System.out.println("Неудалось удалить файл " + fileName);
        }

    }
}
