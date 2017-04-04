/*Прочитать с tut.by название главной новости. Кликнуть на главную новость,
посчитать количество параграфов в тексте новости.
 */

package by.htp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TutByPage extends CorePage {

    public static final String URL = "https://www.tut.by/";
    public static final By MAIN_NEWS = By.xpath("//*[@id=\"title_news_block\"]/div[1]/h3/a");
    public static final By NEWS_TITLE = By.xpath("//*[@id=\"title_news_block\"]/div[1]/h3/a/span[1]");
    public static final By NEWS_BODY = By.xpath("//*[@id=\"article_body\"]");
    public static final By PARAGRAPH_TAG = By.tagName("p");

    public TutByPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void openMainNews(){
        WebElement news = (new WebDriverWait(driver, 8))
                .until(ExpectedConditions.presenceOfElementLocated(MAIN_NEWS));
        news.click();
    }

    public String getMianNewsTitle(){
        String title = driver.findElement(NEWS_TITLE).getText();
        return title;
    }

    public int getParagraphCount(){
        WebElement mainNews = (new WebDriverWait(driver, 8))
                .until(ExpectedConditions.presenceOfElementLocated(NEWS_BODY));
        int count = mainNews.findElements(PARAGRAPH_TAG).size();
        return count;
    }

}
