package laba_3;
import java.util.HashMap;
import java.util.Map;

public class Example5 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, "Элемент" + i);
        }

        System.out.println("HashMap");
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        if (map.containsKey(0)) {
            System.out.print("При ключ=0 ");
            boolean first = true;
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (entry.getKey() > 5) {
                    if (!first) System.out.print(", ");
                    System.out.print(entry.getValue());
                    first = false;
                }
            }
            System.out.println();
        }

        long product = 1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
            }
        }
        System.out.println("Произведение ключей где длина строки >5: " + product);
    }
}
