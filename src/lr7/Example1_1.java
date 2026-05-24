package lr7;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Example1_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //содаем папку
        File folder = new File("C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/example_folder");
        if (!folder.exists()){
            if(folder.mkdirs()){
                System.out.println("Папка создана " + folder.getAbsolutePath());
            } else{
                System.out.println("Неудалось создать папку " + folder.getAbsolutePath());
            }
        } else {
            System.out.println("Папка уже существует " + folder.getAbsolutePath());
        }
        // Ввод имени файла
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();

        // Создаем файл в папке
        File file = new File(folder.getAbsolutePath() +
                File.separator + fileName);

        try {
            if (file.createNewFile()){
                System.out.println("Файл создан " + file.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать файл " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла " + e.getMessage());
        }
        // удаление файла и папки
        if (file.delete()) {
            System.out.println("файл удален " + file.getAbsolutePath());
        } else {
            System.out.println("Неудалось удалить файл " + file.getAbsolutePath());
        }
        if (folder.delete()) {
            System.out.println("Папка удалена " + folder.getAbsolutePath());
        } else {
            System.out.println("Неудалось удалить папку " + folder.getAbsolutePath());
        }

    }
}
