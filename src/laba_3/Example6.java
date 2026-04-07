package laba_3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Example6 {
    public static int simulate(ArrayList<Integer> people) {
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }

    public static int simulate(LinkedList<Integer> people) {
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N: ");
        int n = scanner.nextInt();

        long start, end;

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) arrayList.add(i);
        start = System.currentTimeMillis();
        int lastArray = simulate(arrayList);
        end = System.currentTimeMillis();
        System.out.println("ArrayList: последний = " + lastArray + ", время = " + (end - start) + " мс");

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) linkedList.add(i);
        start = System.currentTimeMillis();
        int lastLinked = simulate(linkedList);
        end = System.currentTimeMillis();
        System.out.println("LinkedList: последний = " + lastLinked + ", время = " + (end - start) + " мс");

    }
}
