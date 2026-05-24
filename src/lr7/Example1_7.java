package lr7;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Example1_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        Person person = new Person(name, age);

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("C:/Users/Екатерина/IdeaProjects/laba_1/src/lr7/output.txt");
            ObjectOutputStream out =
                    new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

