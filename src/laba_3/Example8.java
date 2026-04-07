package laba_3;
import java.util.Scanner;

public class Example8 {
    private Node head;
    private static final Scanner SC = new Scanner(System.in);

    public void createHead() {
        head = null;
        System.out.print("createHead (цикл): введите числа (0 - конец): ");
        int val = SC.nextInt();
        if (val != 0) {
            head = new Node(val, null);
            Node ref = head;
            while ((val = SC.nextInt()) != 0) {
                ref.next = new Node(val, null);
                ref = ref.next;
            }
        }
    }

    public void createTail() {
        head = null;
        System.out.print("createTail (цикл): введите числа (0 - конец): ");
        int val;
        while ((val = SC.nextInt()) != 0) {
            head = new Node(val, head);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node ref = head;
        while (ref != null) {
            sb.append(ref.value).append(" ");
            ref = ref.next;
        }
        return sb.toString().trim();
    }

    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void addLast(int value) {
        if (head == null) {
            head = new Node(value, null);
            return;
        }
        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = new Node(value, null);
    }

    public void insert(int index, int value) {
        if (index == 1) {
            addFirst(value);
            return;
        }
        Node ref = head;
        for (int k = 1; k < index - 1 && ref != null; k++) {
            ref = ref.next;
        }
        if (ref == null) return;
        ref.next = new Node(value, ref.next);
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }

    public void remove(int index) {
        if (index == 1) {
            removeFirst();
            return;
        }
        Node ref = head;
        for (int k = 1; k < index - 1 && ref != null; k++) {
            ref = ref.next;
        }
        if (ref == null || ref.next == null) return;
        ref.next = ref.next.next;
    }

    public void createHeadRec() {
        head = createHeadRecHelper();
    }

    private Node createHeadRecHelper() {
        int val = SC.nextInt();
        if (val == 0) return null;
        return new Node(val, createHeadRecHelper());
    }

    public void createTailRec() {
        head = null;
        createTailRecHelper();
    }

    private void createTailRecHelper() {
        int val = SC.nextInt();
        if (val == 0) return;
        createTailRecHelper();
        head = new Node(val, head);
    }

    public String toStringRec() {
        return toStringRecHelper(head).trim();
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        return node.value + " " + toStringRecHelper(node.next);
    }

    public static void main(String[] args) {
        Example8 list = new Example8();

        System.out.println("Задание 8: Цикл");
        list.createHead();
        System.out.println("Список: " + list.toString());

        list.addFirst(0);
        System.out.println("После addFirst(0): " + list.toString());

        list.addLast(99);
        System.out.println("После addLast(99): " + list.toString());

        list.insert(2, 777);
        System.out.println("После insert(2,777): " + list.toString());

        list.removeFirst();
        System.out.println("После removeFirst: " + list.toString());

        list.removeLast();
        System.out.println("После removeLast: " + list.toString());

        list.remove(2);
        System.out.println("После remove(2): " + list.toString());

        System.out.println("\nЗадание 8: Рекурсия");
        Example8 listRec = new Example8();

        listRec.createHeadRec();
        System.out.println("createHeadRec: " + listRec.toStringRec());

        listRec.createTailRec();
        System.out.println("createTailRec: " + listRec.toStringRec());
    }
}
