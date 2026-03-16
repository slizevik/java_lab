package laba_2;
import java.util.Scanner;

public class timus1197 {
    public static void main(String[] args){
        Scanner chess = new Scanner(System.in);
        char[] columns = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[][] moves = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        int count = chess.nextInt(); // Количество тестов

        for (int i = 0; i < count; i++) {
            String position = chess.next();
            char letter = position.charAt(0);
            int number = position.charAt(1) - '0';

            int colIndex = 0;
            for (int j = 0; j < columns.length; j++) {
                if (columns[j] == letter) {
                    colIndex = j;
                    break;
                }
            }

            int rowIndex = number - 1;
            int validMoves = 0;

            for (int[] move : moves) {
                int newCol = colIndex + move[0];
                int newRow = rowIndex + move[1];

                if (newCol >= 0 && newCol < 8 && newRow >= 0 && newRow < 8) {
                    validMoves++;
                }
            }

            System.out.println(validMoves);
        }

        chess.close();
    }

}
