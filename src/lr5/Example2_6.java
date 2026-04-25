package lr5;
import java.util.*;
import java.util.stream.Collectors;

public class Example2_6 {
    // 2. Только чётные числа
    public static int[] filterEvenNumbers(int[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .toArray();
    }

    // 3. Общие элементы двух массивов
    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : arr2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    // 4. Строки с заглавной буквы
    public static List<String> filterCapitalizedStrings(List<String> list) {
        List<String> result = new ArrayList<>();

        for (String str : list) {
            if (str != null && !str.isEmpty() && Character.isUpperCase(str.charAt(0))) {
                result.add(str);
            }
        }

        return result;
    }

    // 5. Квадраты чисел
    public static List<Integer> squareNumbers(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    // 6. Строки, содержащие подстроку
    public static List<String> filterBySubstring(List<String> list, String substring) {
        List<String> result = new ArrayList<>();

        for (String str : list) {
            if (str != null && str.contains(substring)) {
                result.add(str);
            }
        }

        return result;
    }
    // Тестирование всех функций
    public static void main(String[] args) {

        // Задание 2
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Чётные: " + Arrays.toString(filterEvenNumbers(arr)));

        // Задание 3
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};
        System.out.println("Общие элементы: " + Arrays.toString(findCommonElements(arr1, arr2)));

        // Задание 4
        List<String> words = Arrays.asList("apple", "Banana", "cherry", "Dog");
        System.out.println("С заглавной: " + filterCapitalizedStrings(words));

        // Задание 5
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        System.out.println("Квадраты: " + squareNumbers(numbers));

        // Задание 6
        List<String> strings = Arrays.asList("hello", "world", "hell", "java");
        System.out.println("С подстрокой 'hell': " + filterBySubstring(strings, "hell"));
    }
}

