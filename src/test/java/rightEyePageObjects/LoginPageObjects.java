package rightEyePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/* This pattern of having page objects separately helps to reduce the amount of duplicated code
and offers reuse of code. Also, if the UI changes, the fix only need to be applied at one place */

public abstract class LoginPageObjects {

    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        //gecko dirver helps to connect to Firefox browser
        //configure geckodriver path "/Users/divya" to run on your machine
        System.setProperty("webdriver.gecko.driver", "/Users/divya/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://dsah01.github.io/");
    }

    @AfterSuite
    public void cleanUp() {
        driver.close();
    }

    public WebElement findEmailAddress() {
        WebElement webElement = driver.findElement(Locators.EMAIL_ADDRESS);
        webElement.clear();
        return webElement;
    }

    public WebElement findPassword() {
        WebElement webElement = driver.findElement(Locators.PASSWORD);
        webElement.clear();
        return webElement;
    }

    public WebElement findLoginButton() {
        return driver.findElement(Locators.LOGIN);
    }

    public String getMessage() {
        return driver.findElement(Locators.MESSAGE).getText();
    }

    public WebElement findHelpLink() {
        return driver.findElement(Locators.NEEDHELP);
    }

    public WebElement findFaqPage() {
        return driver.findElement(Locators.FAQ_PAGE);
    }
}

interface Locators {
    By EMAIL_ADDRESS = By.id("txtUserId");
    By PASSWORD = By.id("txtPassword");
    By MESSAGE = By.id("lblMessage");
    By LOGIN = By.id("btnLogin");
    By NEEDHELP = By.id("urlFaq");

    By FAQ_PAGE = By.xpath("//h1[2]");
    //other common way to locate element is by using css seclector)
}
