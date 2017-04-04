package by.htp;

import by.htp.pages.RegistratorPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SmokeTest {

    private static final String KEY = "webdriver.gecko.driver";
    private static final String VALUE = "C:\\Selenium\\Drivers\\geckodriver.exe";

    private WebDriver driver;

    @Before
    public void init(){
        System.setProperty(KEY, VALUE);
        driver = new FirefoxDriver();
    }

    @Test
    public void registrateTest() throws InterruptedException {
        RegistratorPage page = new RegistratorPage(driver);
        page.openPage();
        page.registrate();
    }

    @After
    public void closeDriver(){
        driver.close();
    }
}
