package laba_2;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class example1 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.println("Введите номер массива:");
        int size = id.nextInt();
        System.out.println("Размер массива:"+ size);
        int[] nums = new int[size];
        Random random = new Random();

        for (int i = 0; i < nums.length ; i++){
            nums[i] = random.nextInt(200);
            System.out.println("Номер массива ["+i+"] = " + nums[i]);
        }
        int minValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            }
        }

        System.out.println("\nМинимальное значение: " + minValue);

        System.out.print("Индексы минимальных элементов: ");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minValue) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        id.close();

    }
}
