package lr5;
import java.util.*;

public class Timus1496 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine(); // очистка строки

        Map<String, Integer> map = new HashMap<>();

        // считаем количество сабмитов
        for (int i = 0; i < N; i++) {
            String name = in.nextLine();

            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }

        // выводим тех, у кого больше 1 сабмита
        for (String name : map.keySet()) {
            if (map.get(name) > 1) {
                System.out.println(name);
            }
        }
    }
}
