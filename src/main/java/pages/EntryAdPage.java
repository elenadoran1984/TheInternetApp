package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryAdPage {

    private WebDriver driver;
    private By modalTitle = By.cssSelector(".modal-title > h3");
    private By modalBody = By.cssSelector(".modal-body > p");
    private By modalFooter = By.cssSelector(".modal-footer > p");

    public EntryAdPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(modalTitle).getAttribute("textContent");
    }

    public String getBody(){
        return driver.findElement(modalBody).getAttribute("textContent");
    }

    public String getFooter(){
        return driver.findElement(modalFooter).getAttribute("textContent");
    }
}
