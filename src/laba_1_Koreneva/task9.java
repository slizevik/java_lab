package laba_1_Koreneva;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input number:");
        int num = in.nextInt();

        int num1 = num - 1;  // число на единицу меньше
        int num2 = num;      // введенное число
        int num3 = num + 1;  // число на единицу больше
        int sum = num1 + num2 + num3;
        int num4 = sum * sum;  // квадрат суммы первых трёх

        System.out.println("Sequence: " + num1 + ", " + num2 + ", " + num3 + ", " + num4);

        in.close();
    }
}
