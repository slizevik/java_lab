package laba_3;
import java.util.Scanner;

public class Example3 {
    public static void fillArray(int[] arr, int index, Scanner scanner) {
        if (index == arr.length) return;
        arr[index] = scanner.nextInt();
        fillArray(arr, index + 1, scanner);
    }

    public static void printArray(int[] arr, int index) {
        if (index == arr.length) return;
        System.out.print(arr[index] + " ");
        printArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Массив через рекурсию\nВведите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        fillArray(array, 0, scanner);

        System.out.print("Массив: ");
        printArray(array, 0);
        System.out.println();
    }
}
