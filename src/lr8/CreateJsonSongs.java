package lr8;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;

public class CreateJsonSongs {
    public static void main(String[] args) {
        try {
            // Создание корневого объекта
            JSONObject root = new JSONObject();

            // Создание массива песен
            JSONArray songsArray = new JSONArray();

            // Первая песня
            JSONObject song1 = new JSONObject();
            song1.put("title", "Лесник");
            song1.put("artist", "Король и Шут");
            song1.put("year", 1997);
            songsArray.add(song1);

            // Вторая песня
            JSONObject song2 = new JSONObject();
            song2.put("title", "Прогулки по воде");
            song2.put("artist", "Наутилус Помпилиус");
            song2.put("year", 1985);
            songsArray.add(song2);

            // Добавление массива в корневой объект
            root.put("songs", songsArray);

            // Запись JSON-объекта в файл
            FileWriter file = new FileWriter("C:/Users/Екатерина/IdeaProjects/laba_1/src/lr8/exampleSongs.json");
            file.write(root.toJSONString());
            file.flush();
            file.close();

            System.out.println("JSON файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

