package lr8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XmlParsingSongs {
    private static final String FILE_PATH = "C:/Users/Екатерина/IdeaProjects/laba_1/src/lr8/exampleSongs.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nМеню:");
            System.out.println("1. Показать все песни");
            System.out.println("2. Добавить новую песню");
            System.out.println("3. Найти песню (по исполнителю или году)");
            System.out.println("4. Удалить песню по названию");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            try {
                File inputFile = new File(FILE_PATH);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
                Document doc = dbBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();

                switch (choice) {
                    case "1":
                        displaySongs(doc);
                        break;
                    case "2":
                        addSong(doc, inputFile, scanner);
                        break;
                    case "3":
                        searchSong(doc, scanner);
                        break;
                    case "4":
                        deleteSong(doc, inputFile, scanner);
                        break;
                    case "0":
                        isRunning = false;
                        System.out.println("Программа завершена.");
                        break;
                    default:
                        System.out.println("Неверный ввод. Попробуйте снова.");
                }
            } catch (Exception e) {
                System.err.println("Ошибка при работе с XML: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // Отображение всех песен
    private static void displaySongs(Document doc) {
        System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("song");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("\nТекущий элемент: " + node.getNodeName());
                System.out.println("Название песни: " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Исполнитель: " + element.getElementsByTagName("artist").item(0).getTextContent());
                System.out.println("Год выпуска: " + element.getElementsByTagName("year").item(0).getTextContent());
            }
        }
    }

    // Задание 2: Добавление новой песни
    private static void addSong(Document doc, File file, Scanner scanner) throws Exception {
        System.out.print("Введите название песни: ");
        String title = scanner.nextLine();
        System.out.print("Введите исполнителя: ");
        String artist = scanner.nextLine();
        System.out.print("Введите год выпуска: ");
        String year = scanner.nextLine();

        Element newSong = doc.createElement("song");

        Element titleElem = doc.createElement("title");
        titleElem.appendChild(doc.createTextNode(title));
        newSong.appendChild(titleElem);

        Element artistElem = doc.createElement("artist");
        artistElem.appendChild(doc.createTextNode(artist));
        newSong.appendChild(artistElem);

        Element yearElem = doc.createElement("year");
        yearElem.appendChild(doc.createTextNode(year));
        newSong.appendChild(yearElem);

        doc.getDocumentElement().appendChild(newSong);
        saveDocument(doc, file);
        System.out.println("Песня успешно добавлена.");
    }

    // Задание 3: Поиск по исполнителю или году
    private static void searchSong(Document doc, Scanner scanner) {
        System.out.println("Поиск по: 1 - Исполнитель, 2 - Год выпуска");
        System.out.print("Выберите критерий (1 или 2): ");
        String criteria = scanner.nextLine();
        System.out.print("Введите значение для поиска: ");
        String searchTerm = scanner.nextLine();

        NodeList nodeList = doc.getElementsByTagName("song");

        // Преобразование NodeList в Stream<Element>
        List<Element> songs = IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .collect(Collectors.toList());

        List<Element> foundSongs;
        if ("1".equals(criteria)) {
            foundSongs = songs.stream()
                    .filter(element -> element.getElementsByTagName("artist").item(0).getTextContent().equalsIgnoreCase(searchTerm))
                    .collect(Collectors.toList());
        } else if ("2".equals(criteria)) {
            foundSongs = songs.stream()
                    .filter(element -> element.getElementsByTagName("year").item(0).getTextContent().equals(searchTerm))
                    .collect(Collectors.toList());
        } else {
            System.out.println("Неверный критерий поиска.");
            return;
        }

        if (foundSongs.isEmpty()) {
            System.out.println("Песни по заданному критерию не найдены.");
        } else {
            System.out.println("\nНайденные песни:");
            for (Element song : foundSongs) {
                System.out.println("Название: " + song.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Исполнитель: " + song.getElementsByTagName("artist").item(0).getTextContent());
                System.out.println("Год: " + song.getElementsByTagName("year").item(0).getTextContent());
            }
        }
    }

    // Задание 4: Удаление песни по названию
    private static void deleteSong(Document doc, File file, Scanner scanner) throws Exception {
        System.out.print("Введите точное название песни для удаления: ");
        String titleToDelete = scanner.nextLine();

        NodeList nodeList = doc.getElementsByTagName("song");
        boolean isDeleted = false;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element songElement = (Element) node;
                String currentTitle = songElement.getElementsByTagName("title").item(0).getTextContent();

                if (currentTitle.equalsIgnoreCase(titleToDelete)) {
                    // Удаление элемента через родительский узел
                    Node parentNode = songElement.getParentNode();
                    parentNode.removeChild(songElement);
                    isDeleted = true;
                    break;
                }
            }
        }

        if (isDeleted) {
            saveDocument(doc, file);
            System.out.println("Песня успешно удалена из файла.");
        } else {
            System.out.println("Песня с таким названием не найдена.");
        }
    }

    // Сохранение изменений в файл
    private static void saveDocument(Document doc, File file) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }
}



