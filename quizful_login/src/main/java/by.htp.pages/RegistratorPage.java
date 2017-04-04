package by.htp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistratorPage extends Page {

    private static final String URL = "http://www.quizful.net/test";

    private static final String LOGIN = "klopik123123";
    private static final String PASSWORD = "klopik123123";
    private static final String MAIL = "dlansa@mail.ru";

    private static final By registrationPage = By.xpath("//*[@id=\"user-panel\"]/li[3]/a");
    private static final By loginLocator = By.xpath("//*[@id=\"login\"]");
    private static final By passwordLocator = By.xpath("//*[@id=\"register-form\"]/div[3]/form/label[2]/input");
    private static final By passwordRepeate = By.xpath("//*[@id=\"register-form\"]/div[3]/form/label[3]/input");
    private static final By isCorporative = By.xpath("//*[@id=\"corporate\"]");
    private static final By mail = By.xpath("//*[@id=\"register-form\"]/div[3]/form/label[4]/input");
    private static final By submitReg = By.xpath("//*[@id=\"register-form\"]/div[3]/form/p[2]/input[1]");

    public RegistratorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(500);
    }

    public void registrate() throws InterruptedException {
        driver.findElement(registrationPage).click();
        Thread.sleep(1000);

        WebElement login = driver.findElement(loginLocator);
        login.sendKeys(LOGIN);

        WebElement password = driver.findElement(passwordLocator);
        password.sendKeys(PASSWORD);

        WebElement repeatePassword = driver.findElement(passwordRepeate);
        repeatePassword.sendKeys(PASSWORD);

        WebElement mailAdress = driver.findElement(mail);
        mailAdress.sendKeys(MAIL);

        driver.findElement(isCorporative).click();

        Thread.sleep(9000);     // enter captcha

        driver.findElement(submitReg).click();
    }


}
