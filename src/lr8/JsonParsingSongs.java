package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class JsonParsingSongs {
    private static final String FILE_PATH = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr8/exampleSongs.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nМеню:");
            System.out.println("1. Показать все песни");
            System.out.println("2. Добавить новую песню");
            System.out.println("3. Найти песню по исполнителю");
            System.out.println("4. Удалить песню по названию");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            choice = scanner.nextLine();

            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(FILE_PATH));
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray jsonArray = (JSONArray) jsonObject.get("songs");

                switch (choice) {
                    case "1":
                        displayAllSongs(jsonArray);
                        break;
                    case "2":
                        addSong(jsonObject, jsonArray);
                        break;
                    case "3":
                        searchSongByArtist(jsonArray, scanner);
                        break;
                    case "4":
                        deleteSongByTitle(jsonObject, jsonArray, scanner);
                        break;
                    case "0":
                        System.out.println("Программа завершена.");
                        break;
                    default:
                        System.out.println("Неверный ввод. Попробуйте снова.");
                }
            } catch (Exception e) {
                System.err.println("Ошибка при работе с JSON: " + e.getMessage());
            }
        } while (!choice.equals("0"));

        scanner.close();
    }

    // Отображение всех песен
    private static void displayAllSongs(JSONArray jsonArray) {
        System.out.println("\nСписок всех песен:");
        for (Object o : jsonArray) {
            JSONObject song = (JSONObject) o;
            System.out.println("\nТекущий элемент: song");
            System.out.println("Название песни: " + song.get("title"));
            System.out.println("Исполнитель: " + song.get("artist"));
            System.out.println("Год выпуска: " + song.get("year"));
        }
    }

    // Задание 3: Добавление новой песни в массив
    private static void addSong(JSONObject jsonObject, JSONArray jsonArray) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название песни: ");
        String title = scanner.nextLine();
        System.out.print("Введите исполнителя: ");
        String artist = scanner.nextLine();
        System.out.print("Введите год выпуска: ");
        int year = Integer.parseInt(scanner.nextLine());

        JSONObject newSong = new JSONObject();
        newSong.put("title", title);
        newSong.put("artist", artist);
        newSong.put("year", year);

        jsonArray.add(newSong);

        saveToFile(jsonObject);
        System.out.println("Песня успешно добавлена.");
    }

    // Задание 2: Поиск песни по исполнителю
    private static void searchSongByArtist(JSONArray jsonArray, Scanner scanner) {
        System.out.print("Введите имя исполнителя для поиска: ");
        String artist = scanner.nextLine();

        System.out.println("\nРезультаты поиска:");
        boolean found = false;

        for (Object obj : jsonArray) {
            if (obj instanceof JSONObject) {
                JSONObject song = (JSONObject) obj; // Явное приведение типа
                String currentArtist = (String) song.get("artist");

                if (artist.equalsIgnoreCase(currentArtist)) {
                    found = true;
                    System.out.println("\nТекущий элемент: song");
                    System.out.println("Название песни: " + song.get("title"));
                    System.out.println("Исполнитель: " + song.get("artist"));
                    System.out.println("Год выпуска: " + song.get("year"));
                }
            }
        }

        if (!found) {
            System.out.println("Песни данного исполнителя не найдены.");
        }
    }

    // Задание 4: Удаление песни по названию
    private static void deleteSongByTitle(JSONObject jsonObject, JSONArray jsonArray, Scanner scanner) throws Exception {
        System.out.print("Введите точное название песни для удаления: ");
        String title = scanner.nextLine();

        Iterator iterator = jsonArray.iterator();
        boolean isDeleted = false;

        while (iterator.hasNext()) {
            JSONObject song = (JSONObject) iterator.next();
            if (title.equalsIgnoreCase((String) song.get("title"))) {
                iterator.remove();
                isDeleted = true;
                break;
            }
        }

        if (isDeleted) {
            saveToFile(jsonObject);
            System.out.println("Песня успешно удалена из файла.");
        } else {
            System.out.println("Песня с таким названием не найдена.");
        }
    }

    // Вспомогательный метод для сохранения изменений обратно в JSON-файл
    private static void saveToFile(JSONObject jsonObject) throws Exception {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        }
    }
}