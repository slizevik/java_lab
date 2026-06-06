package lr8;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.xml.transform.OutputKeys;

public class CreateSongs {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder docBuilder =
                    docFactory.newDocumentBuilder();

            // Создание корневого элемента
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("songs");
            doc.appendChild(rootElement);

            // Первая песня
            Element song1 = doc.createElement("song");
            rootElement.appendChild(song1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Лесник"));
            song1.appendChild(title1);

            Element artist1 = doc.createElement("artist");
            artist1.appendChild(doc.createTextNode("Король и Шут"));
            song1.appendChild(artist1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("1997"));
            song1.appendChild(year1);

            // Вторая песня
            Element song2 = doc.createElement("song");
            rootElement.appendChild(song2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Прогулки по воде"));
            song2.appendChild(title2);

            Element artist2 = doc.createElement("artist");
            artist2.appendChild(doc.createTextNode("Наутилус Помпилиус"));
            song2.appendChild(artist2);

            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("1985"));
            song2.appendChild(year2);

            // Запись XML-файла
            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result =
                    new javax.xml.transform.stream.StreamResult(new File("C:/Users/Екатерина/IdeaProjects/laba_1/src/lr8/exampleSongs.xml"));
            transformer.transform(source, result);
            System.out.println("Файл успешно создан!");
        } catch (Exception pce) {
            pce.printStackTrace();
        }
    }
}

