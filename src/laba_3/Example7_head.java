package laba_3;

public class Example7_head {
    public static void main(String[] args) {
        System.out.println("Список с головы");

        Node head = new Node(1, null);
        Node ref = head;
        for (int i = 2; i <= 5; i++) {
            ref.next = new Node(i, null);
            ref = ref.next;
        }

        ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
        System.out.println();
    }
}
