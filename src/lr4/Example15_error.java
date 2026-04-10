package lr4;

import java.util.Scanner;

public class Example15_error {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        int positiveSum = 0;
        int positiveCount = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите элемент array[" + i + "]: ");
            int value = scanner.nextInt();
            array[i] = value;
            if (value > 0) {
                positiveSum += value;
                positiveCount++;
            }
        }

        if (positiveCount == 0) {
            System.out.println("положительные элементы отсутствуют");
        } else {
            double average = (double) positiveSum / positiveCount;
            System.out.printf("Среднее арифметическое положительных элементов: %.2f\n", average);
        }

        scanner.close();
    }
}