package laba_2;
import java.util.Scanner;

public class example3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для шифра: ");
        String string1 = scanner.nextLine();
        System.out.println("Введите ключ: ");
        int key = scanner.nextInt();

        String encrypted = encrypt(string1, key);
        System.out.println("Текст после преобразования: " + encrypted);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        String answer = scanner.next();

        if (answer.equals("y")) {
            String decrypted = decrypt(encrypted, key);
            System.out.println("Расшифрованный текст: " + decrypted);
        } else if (answer.equals("n")) {
            System.out.println("Завершено");
        } else {
            System.out.println("Введите корректный ответ");
        }

        scanner.close();
    }
    public static String encrypt(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(chars[i] + key);
        }
        return new String(chars);
    }
    public static String decrypt(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(chars[i] - key);
        }
        return new String(chars);
    }
}
