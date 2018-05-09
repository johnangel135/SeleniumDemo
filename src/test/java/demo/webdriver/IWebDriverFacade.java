package demo.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Duong Truong on 4/23/2018.
 */
public interface IWebDriverFacade {
    void start(String url);

    void stop();

    Object executeJavaScript(String script);

    WebElement findElement(By by);

    List<WebElement> findElements(By by);

    String getTitle();

    void waitFor(long sec);

    WebElement findElementByText(String text);

    void switchToCurrentWindow();
}
