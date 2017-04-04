package by.htp.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TutByPageTest {

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
        TutByPage page = new TutByPage(driver);
        page.openPage();
        String title = page.getMianNewsTitle();
        page.openMainNews();
        int count = page.getParagraphCount();

        System.out.println("Main news are " + title + " ,have " + count + " paragraphs.");
    }
}