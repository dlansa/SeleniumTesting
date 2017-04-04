package by.htp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistratorPage extends Page {

    private static final String URL = "http://www.quizful.net/test";

    private static final String LOGIN = "klopik123123";
    private static final String PASSWORD = "klopik123123";
    private static final String MAIL = "dlansa@mail.ru";

    private static final By REGISTRATION_PAGE = By.xpath("//*[@id=\"user-panel\"]/li[3]/a");
    private static final By LOGIN_LOCATOR = By.xpath("//*[@id=\"login\"]");
    private static final By PASSWORD_LOCATOR = By.xpath("//*[@id=\"register-form\"]/div[3]/form/label[2]/input");
    private static final By PASSWORD_REPEATE = By.xpath("//*[@id=\"register-form\"]/div[3]/form/label[3]/input");
    private static final By IS_CORPORATIVE = By.xpath("//*[@id=\"corporate\"]");
    private static final By REG_MAIL = By.xpath("//*[@id=\"register-form\"]/div[3]/form/label[4]/input");
    private static final By SUBMIT_REG = By.xpath("//*[@id=\"register-form\"]/div[3]/form/p[2]/input[1]");

    public RegistratorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() throws InterruptedException {
        driver.get(URL);
    }

    public void registrate() throws InterruptedException {
        WebElement registration = (new WebDriverWait(driver, 8))
                .until(ExpectedConditions.presenceOfElementLocated(REGISTRATION_PAGE));
        registration.click();

        WebElement login = (new WebDriverWait(driver, 8))
                .until(ExpectedConditions.presenceOfElementLocated(LOGIN_LOCATOR));
        login.sendKeys(LOGIN);

        WebElement password = driver.findElement(PASSWORD_LOCATOR);
        password.sendKeys(PASSWORD);

        WebElement repeatePassword = driver.findElement(PASSWORD_REPEATE);
        repeatePassword.sendKeys(PASSWORD);

        WebElement mailAdress = driver.findElement(REG_MAIL);
        mailAdress.sendKeys(MAIL);

        driver.findElement(IS_CORPORATIVE).click();

        Thread.sleep(9000);     // enter captcha

        driver.findElement(SUBMIT_REG).click();
    }


}
