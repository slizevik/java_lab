package lr5;
import java.util.*;

public class Example7_11 {
    // 7. Числа, делящиеся на заданное число
    public static List<Integer> filterDivisibleNumbers(List<Integer> list, int divisor) {
        List<Integer> result = new ArrayList<>();

        for (int num : list) {
            if (num % divisor == 0) {
                result.add(num);
            }
        }

        return result;
    }

    // 8. Строки длиннее заданного значения
    public static List<String> filterByLength(List<String> list, int minLength) {
        List<String> result = new ArrayList<>();

        for (String str : list) {
            if (str != null && str.length() > minLength) {
                result.add(str);
            }
        }

        return result;
    }

    // 9. Числа больше заданного значения
    public static List<Integer> filterGreaterThan(List<Integer> list, int value) {
        List<Integer> result = new ArrayList<>();

        for (int num : list) {
            if (num > value) {
                result.add(num);
            }
        }

        return result;
    }

    // 10. Строки только из букв
    public static List<String> filterOnlyLetters(List<String> list) {
        List<String> result = new ArrayList<>();

        for (String str : list) {
            if (str != null && str.matches("[a-zA-Zа-яА-Я]+")) {
                result.add(str);
            }
        }

        return result;
    }

    // 11. Числа меньше заданного значения
    public static List<Integer> filterLessThan(List<Integer> list, int value) {
        List<Integer> result = new ArrayList<>();

        for (int num : list) {
            if (num < value) {
                result.add(num);
            }
        }

        return result;
    }
    // Проверка всех функций
    public static void main(String[] args) {

        // Задание 7
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Делятся на 2: " + filterDivisibleNumbers(numbers, 2));

        // Задание 8
        List<String> words = Arrays.asList("hi", "hello", "java", "a");
        System.out.println("Длина > 3: " + filterByLength(words, 3));

        // Задание 9
        System.out.println("Больше 3: " + filterGreaterThan(numbers, 3));

        // Задание 10
        List<String> mixed = Arrays.asList("hello", "world123", "java!", "code");
        System.out.println("Только буквы: " + filterOnlyLetters(mixed));

        // Задание 11
        System.out.println("Меньше 4: " + filterLessThan(numbers, 4));
    }
}

