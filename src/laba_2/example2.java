package laba_2;
import java.util.Scanner;

public class example2 {
    public static void main(String[] args){
        int count = 1;
        Scanner id = new Scanner(System.in);
        System.out.println("Введите число строк и столбцов через enter: ");
        int size1 = id.nextInt();
        int size2 = id.nextInt();
        int[][] nums = new int[size1][size2];

        for (int i = 0;  i < nums.length; i++){
            if (i % 2 == 0) {
                for (int j = 0; j < size2; j++) {
                    nums[i][j] = count;
                    count = count + 1;
                }
            }
            else {
                for (int j = size2 - 1; j >=0; j--) {
                    nums[i][j] = count;
                    count = count + 1;
                }
            }
        }

        System.out.println("Массив змейкой");
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
            }
        id.close();
        }
}






