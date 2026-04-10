package lr4;
import java.util.Scanner;

public class Example16_error {
        public static void main(String[] args) {
            int[][] matrix = {
                    {1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {11, 12, 13, 14, 15},
                    {16, 17, 18, 19, 20}
            };

            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите номер столбца (от 0 до " + (matrix[0].length - 1) + "): ");
            int columnNumber = scanner.nextInt();

            System.out.println("Столбец с номером " + columnNumber + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][columnNumber]);
            }

            System.out.println("\nПрограмма успешно завершена.");
            scanner.close();
        }
    }

