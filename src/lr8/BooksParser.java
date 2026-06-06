package lr8;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class BooksParser {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://books.toscrape.com/").get();
            System.out.println("Title: " + doc.title());

            // Получаем книги
            Elements books = doc.select("article.product_pod");

            System.out.println("Количество книг: " + books.size());

            int count = 0;

            for (Element book : books) {

                String title = book.select("h3 a").attr("title");
                String price = book.select(".price_color").text();
                String rating = book.select(".star-rating").attr("class");

                System.out.println("Книга: " + title);
                System.out.println("Цена: " + price);
                System.out.println("Рейтинг: " + rating);

                count++;
                if (count == 10) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


