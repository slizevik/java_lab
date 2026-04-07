package laba_3;

public class Example7_tail {
    public static void main(String[] args) {
        System.out.println("Список с хвоста");

        Node current = new Node(5, null);
        for (int i = 4; i >= 1; i--) {
            current = new Node(i, current);
        }
        Node head = current;

        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
        System.out.println();
    }
}
