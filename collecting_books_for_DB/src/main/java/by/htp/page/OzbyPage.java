/*Открыть поисковик google, ввести в строку поиска «Java», убедиться, что название
вкладки с результатами поиска содержит слово Java.
 */

package by.htp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OzbyPage extends CorePage {

    private CreateBook creator;

    public static final String URL = "https://oz.by/books/topic1.html";
    public static final By BOOKS_FIELD = By.className("viewer-type-card__wrapper");
    public static final By BOOKS = By.className("viewer-type-card__li ");
    public static final By BOOK_TITLE = By.cssSelector(".item-type-card__title");
    public static final By BOOK_AUTHOR = By.cssSelector(".item-type-card__info");
    public static final By BOOK_PICtURE = By.cssSelector(".item-type-card__figure img");
    public static final By BOOK_PRICE = By.className("item-type-card__btn");
    public static final By BOOK_URL = By.className("item-type-card__link");
    public static final By LAST_PAGE = By.xpath("//*[@id=\"paginator1\"]/div/ul/li[8]/a");
    public static final By GO_NEXT_PAGE = By.xpath("//*[@id=\"paginator1\"]/div/a");


    public OzbyPage(WebDriver driver) {
        super(driver);
        creator = new CreateBook();
    }


    public void openPage() {
        driver.get(URL);
    }

    public void fillDB(){
        int pageCount = Integer.parseInt(driver.findElement(LAST_PAGE).getText());
        for (int i = 0; i < pageCount; i++) {
            grabBook();
        }
    }

    public synchronized void grabBook(){
        int missedBooks = 1;
        WebElement books = (new WebDriverWait(driver, 8))
                .until(ExpectedConditions.presenceOfElementLocated(BOOKS_FIELD));
        List<WebElement> bookList = books.findElements(BOOKS);
        for (WebElement bookElement: bookList){
            try {
                String title = bookElement.findElement(BOOK_TITLE).getText();
                String author = bookElement.findElement(BOOK_AUTHOR).getText();
                String picUrl = bookElement.findElement(BOOK_PICtURE).getAttribute("src");
                String url = bookElement.findElement(BOOK_URL).getAttribute("href");
                String price = bookElement.findElement(BOOK_PRICE).getText();
                Book book = new Book(title, author, price, picUrl, url);
                if (!title.isEmpty())
                    creator.addBook(book);
            }catch (NoSuchElementException e){
                System.out.println(missedBooks + " books are missed");
                missedBooks++;
            }
        }
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(GO_NEXT_PAGE));
        driver.findElement(GO_NEXT_PAGE).click();
    }

}
