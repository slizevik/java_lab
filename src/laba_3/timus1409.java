package laba_3;
import java.util.Scanner;

public class timus1409 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Сколько банок прострелил Ларри? ");
        int larry = scan.nextInt();
        System.out.println("Сколько банок прострелил Гарри? ");
        int garry = scan.nextInt();
        int not_larry = 10 - larry;
        int not_garry = 10 - garry;
        System.out.println("Ларри не прострелил " + not_larry + " банок");
        System.out.println("Гарри не прострелил " + not_garry + " банок");
    }
}
