package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;

    private String topFrame = "frame-top";
    private String bottomFrame = "frame-bottom";

    private String leftFrame = "frame-left";
    private String middleFrame = "frame-middle";
    private String rightFrame = "frame-right";

    private By body = By.tagName("body");
    private By id = By.id("content");

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    public String getLeftFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit left to top
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }

    public String getMiddleFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(middleFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit middle to top
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }

    public String getRightFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(rightFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit right to top
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }

    public String getBottomFrameText(){
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }

    private String getFrameText(){
        return driver.findElement(body).getText();
    }

}
