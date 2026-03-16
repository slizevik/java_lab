package laba_2;
import java.util.Scanner;
import java.util.Arrays;

public class timus1025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();

        int[] votesNeeded = new int[K];

        for (int i = 0; i < K; i++) {
            int groupSize = scanner.nextInt();
            votesNeeded[i] = groupSize / 2 + 1;
        }

        Arrays.sort(votesNeeded);

        int groupsToWin = K / 2 + 1;

        int totalVotes = 0;
        for (int i = 0; i < groupsToWin; i++) {
            totalVotes += votesNeeded[i];
        }

        System.out.println(totalVotes);
        scanner.close();
    }

}
