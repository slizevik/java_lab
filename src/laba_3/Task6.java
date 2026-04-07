package laba_3;
import java.util.*;

public class Task6 {
    private static final int N = 1_000_000;
    private static final int N_GET = 1_000_000;

    public static void main(String[] args) {
        System.out.println("Количество элементов: " + N);

        // ArrayList
        testArrayList();

        // TreeSet (реализация SortedSet и TreeSet)
        testTreeSet();
    }

    private static void testArrayList() {
        List<Integer> list = new ArrayList<>();
        System.out.println("\nArrayList");

        long t1 = measureAddBegin(list);
        System.out.println("Добавление в начало: " + t1 + " мс");

        long t2 = measureAddEnd(list);
        System.out.println("Добавление в конец:  " + t2 + " мс");

        long t3 = measureAddMiddle(list);
        System.out.println("Добавление в середину: " + t3 + " мс");

        long t4 = measureRemoveBegin(list);
        System.out.println("Удаление в начале: " + t4 + " мс");

        long t5 = measureRemoveEnd(list);
        System.out.println("Удаление в конце:  " + t5 + " мс");

        long t6 = measureRemoveMiddle(list);
        System.out.println("Удаление в середине: " + t6 + " мс");

        long t7 = measureGetByIndex(list);
        System.out.println("Получение по индексу: " + t7 + " мс");
    }

    private static void testTreeSet() {
        Set<Integer> set = new TreeSet<>();
        System.out.println("\nTreeSet (SortedSet)");

        long t1 = measureAddTreeSet(set);
        System.out.println("Добавление (add): " + t1 + " мс");

        long t2 = measureRemoveTreeSet(set);
        System.out.println("Удаление (remove): " + t2 + " мс");

        // Для TreeSet операции "по индексу" не поддерживаются
        System.out.println("Добавление/удаление в начало/середину/конец: одинаково");
        System.out.println("Получение по индексу: не поддерживается (индексов нет)");
    }

    //ArrayList

    private static long measureAddBegin(List<Integer> list) {
        list.clear();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(0, i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureAddEnd(List<Integer> list) {
        list.clear();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureAddMiddle(List<Integer> list) {
        list.clear();
        for (int i = 0; i < N / 2; i++) list.add(i); // предварительно заполним
        long start = System.currentTimeMillis();
        for (int i = 0; i < N / 2; i++) {
            list.add(list.size() / 2, i); // в середину
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureRemoveBegin(List<Integer> list) {
        list.clear();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.remove(0);               // из начала
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureRemoveEnd(List<Integer> list) {
        list.clear();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.remove(list.size() - 1); // из конца
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureRemoveMiddle(List<Integer> list) {
        list.clear();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.currentTimeMillis();
        for (int i = 0; i < N / 2; i++) {
            list.remove(list.size() / 2); // из середины
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureGetByIndex(List<Integer> list) {
        list.clear();
        for (int i = 0; i < N_GET; i++) list.add(i);
        long start = System.currentTimeMillis();
        for (int i = 0; i < N_GET; i += 1000) {   // проверяем много индексов
            list.get(i);
        }
        return System.currentTimeMillis() - start;
    }

    //TreeSet операции

    private static long measureAddTreeSet(Set<Integer> set) {
        set.clear();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureRemoveTreeSet(Set<Integer> set) {
        for (int i = 0; i < N; i++) set.add(i); // предварительно заполним
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            set.remove(i);
        }
        return System.currentTimeMillis() - start;
    }
}
