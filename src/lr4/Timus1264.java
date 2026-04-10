package lr4;
import java.util.Scanner;

public class Timus1264 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов массива ");
        int N = scan.nextInt();
        System.out.print("Введите число ");
        int M = scan.nextInt();
        System.out.println(N * (M + 1) + " секунд потребуется чтобы написать программу");
        scan.close();
    }
}
