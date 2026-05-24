package lr7;
import java.io.*;

public class Task_8 {
    public static void main(String[] args) {
        String filePath = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/person2.bin";

        // Создание объекта Person2
        Person2 original = new Person2("Мария Смирнова", 28, "maria@example.com");

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(original);
            System.out.println("Объект Person2 сохранён в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи: " + e.getMessage());
        }
        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Person2 restored = (Person2) ois.readObject();
            System.out.println("\nВосстановленный объект Person2:");
            System.out.println("Имя: " + restored.getName());
            System.out.println("Возраст: " + restored.getAge());
            System.out.println("Email: " + restored.getEmail());
            System.out.println(restored); // через toString()
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении: " + e.getMessage());
        }
    }
}

