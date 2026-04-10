package lr4;
import java.util.Scanner;


public class Example17_error {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива (целое положительное число): ");
        int size = Integer.parseInt(scanner.nextLine());

        byte[] array = new byte[size];
        int sum = 0;

        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент array[" + i + "] (целое число от -128 до 127): ");
            String input = scanner.nextLine();
            byte value = Byte.parseByte(input);
            array[i] = value;
            sum += value;
        }

        System.out.println("Сумма элементов массива (int): " + sum);
        System.out.println("Сумма элементов как byte: " + (byte) sum);

        scanner.close();
    }
}
