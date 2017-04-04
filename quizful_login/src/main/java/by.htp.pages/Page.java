package by.htp.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver driver;

    public abstract void openPage() throws InterruptedException;

    public Page(WebDriver driver){
        this.driver = driver;
    }
}
