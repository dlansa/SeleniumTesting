package by.htp.page;

import org.openqa.selenium.WebDriver;

public abstract class CorePage {

    protected WebDriver driver;

    public CorePage(WebDriver driver){
        this.driver = driver;
    }

    public abstract void openPage() throws InterruptedException;
}
