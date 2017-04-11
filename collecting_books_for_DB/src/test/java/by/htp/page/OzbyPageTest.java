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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OzbyPageTest {

    private static final String KEY = "webdriver.gecko.driver";
    private static final String VALUE = "C:\\Selenium\\Drivers\\geckodriver.exe";

    private WebDriver driver;

    @BeforeClass
    public void before(){
        System.setProperty(KEY, VALUE);
        driver = new FirefoxDriver();
    }

    @Test
    public void testSearch() throws InterruptedException {
        OzbyPage page = new OzbyPage(driver);
        page.openPage();
        page.fillDB();
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }

}