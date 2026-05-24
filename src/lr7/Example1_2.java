package lr7;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Example1_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String fileName = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/example_file.txt";
        System.out.println("Введите текст для файла: ");
        String data = scanner.nextLine();

        try (FileOutputStream outputStream = new FileOutputStream(fileName)){
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
        }

        // чтение данных из файла
        try (FileInputStream inputStream = new FileInputStream(fileName)){
            byte [] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String readData = new String(buffer, 0, bytesRead);
            System.out.println("Прочитанные данные " + readData);
        } catch (IOException e){
            System.out.println("Не удалось прочитать данные");
        }

        if (new File (fileName).delete()) {
            System.out.println("файл удален " + fileName);
        } else {
            System.out.println("Неудалось удалить файл " + fileName);
        }

    }
}
