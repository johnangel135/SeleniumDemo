package demo.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverFacade implements IWebDriverFacade {

    private static final long WAIT_SECONDS = 5;

    private WebDriver driver;

    public WebDriverFacade() {
        driver = WebDriverFactory.createWebDriver();
    }

    @Override
    public void start(String url) {
        driver.get(url);
    }

    @Override
    public void stop() {
        driver.quit();
    }

    @Override
    public Object executeJavaScript(String script) {
        return ((JavascriptExecutor) driver).executeScript(script);
    }

    @Override
    public WebElement findElement(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            return NullWebElement.getNull();
        }
    }

    @Override
    public List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    @Override
    public String getTitle(){
        return driver.getTitle();
    }

    @Override
    public void waitFor(long sec){
        WebDriverWait wait = new WebDriverWait(driver, sec);
    }

    @Override
    public WebElement findElementByText(String text){
        String xpath = "//*[contains(text(), '" + text + ",)]";
        return driver.findElement(By.xpath(xpath));
    }
    @Override
    public void switchToCurrentWindow(){
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
}