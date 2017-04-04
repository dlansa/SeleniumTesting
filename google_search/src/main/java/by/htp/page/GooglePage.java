/*Открыть поисковик google, ввести в строку поиска «Java», убедиться, что название
вкладки с результатами поиска содержит слово Java.
 */

package by.htp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends CorePage {

    public static final String URL = "https://www.google.by/";
    public static final By SEARCH_FIELD = By.xpath("//*[@id=\"lst-ib\"]");
    public static final By SUBMIT_BUTTON = By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]");

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(500);
    }

    public void search(String key){
        WebElement search = driver.findElement(SEARCH_FIELD);
        search.sendKeys(key);
        driver.findElement(SUBMIT_BUTTON).submit();
    }
}
