package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {

    private WebDriver driver;
    private By contentArea = By.id("content");
    private By errorServer = By.cssSelector("body > h1");

    public EmailSentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage() {
        return driver.findElement(contentArea).getText();
    }

    public String getError() {
        return driver.findElement(errorServer).getText();
    }
}
