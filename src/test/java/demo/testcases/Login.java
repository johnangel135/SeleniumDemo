package demo.testcases;

import demo.helper.TestData;
import demo.webdriver.IWebDriverFacade;
import demo.webdriver.NullWebElement;
import demo.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Login {

    IWebDriverFacade webDriver;
    private final String DATA_PATH = "testdata/login.csv";

    void init(){
        TestData.readData(DATA_PATH);
    }
    @BeforeClass
    public void setUp() {
        init();
        String browser = TestData.metaData.get("browser");
        String url = TestData.metaData.get("url");
        System.setProperty("browser",browser);
        webDriver = new WebDriverFacade();
        webDriver.start(url);
    }

    public void clickSignIn(String selector){
        WebElement loginBtn = webDriver.findElement(By.cssSelector(".SignInPanel-signInBtn"));
        loginBtn.click();
    }
    @Test
    public void login(){
        String signInBtn = TestData.metaData.get("siginbtn");
        clickSignIn(signInBtn);

        String checkRedirectSignIn = TestData.metaData.get("checksignin");
        boolean redirectSignIn = checkElement(checkRedirectSignIn);

        Assert.assertEquals(true,redirectSignIn);
        String email = TestData.metaData.get("email");
        String emailElement = TestData.metaData.get("emailElement");

        String password = TestData.metaData.get("password");
        String passwordElement = TestData.metaData.get("passwordElement");
        inputEmailPassword(email,emailElement, password, passwordElement);

        String submit = TestData.metaData.get("submit");
        clickSignIn(submit);

        boolean checkSignInBtn = checkElement(signInBtn);

        Assert.assertEquals(false,checkSignInBtn);

    }

    private void inputEmailPassword(String email, String emailElement, String password, String passwordElement) {
        WebElement emailField = webDriver.findElement(By.cssSelector(emailElement));
        emailField.sendKeys(email);

        WebElement passwordField = webDriver.findElement(By.cssSelector(passwordElement));
        passwordField.sendKeys(password);
    }

    private boolean checkElement(String s) {
        WebElement element = webDriver.findElement(By.cssSelector(s));
        return !NullWebElement.getNull().equals(element);
    }


    @AfterClass
    public void tearDown() {
        webDriver.stop();
    }
}


