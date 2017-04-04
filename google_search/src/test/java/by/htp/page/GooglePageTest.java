/*Открыть поисковик google, ввести в строку поиска «Java», убедиться, что название
вкладки с результатами поиска содержит слово Java.
 */

package by.htp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GooglePageTest {

    private static final String KEY = "webdriver.gecko.driver";
    private static final String VALUE = "C:\\Selenium\\Drivers\\geckodriver.exe";
    public static final String SEARCH_KEY = "java";

    public static final By TITLE = By.cssSelector("TITLE");

    private WebDriver driver;

    @BeforeClass
    public void before(){
        System.setProperty(KEY, VALUE);
        driver = new FirefoxDriver();
    }

    @Test
    public void testSearch() throws InterruptedException {
        GooglePage page = new GooglePage(driver);
        page.openPage();
        page.search(SEARCH_KEY);
        Thread.sleep(1000);

        WebElement resultPage = (new WebDriverWait(driver, 8))
                .until(ExpectedConditions.presenceOfElementLocated(TITLE));

        String checkPage = resultPage.getText();
        assertTrue(checkPage.contains(SEARCH_KEY));
    }
}