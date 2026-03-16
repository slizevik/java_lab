package laba_2;
import java.util.Scanner;

public class timus1196 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] teacher = new int[n];
        for (int i = 0; i < n; i++) {
            teacher[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] student = new int[m];
        for (int i = 0; i < m; i++) {
            student[i] = scanner.nextInt();
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (binarySearch(teacher, student[i])) {
                count++;
            }
        }

        System.out.println(count);
        scanner.close();
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
