//Import Packages
package rightEyeTest;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rightEyePageObjects.LoginPageObjects;

public class Login extends LoginPageObjects{

    //Instantiate common variables
    String expectedMessage;
    String actualMessage;

    //Launch Browser once before running any methods in this class
    @BeforeClass
    public void openBrowser() {
        driver.get("https://dsah01.github.io/");
    }

    @Test(priority = 1)
    public void checkSuccessfullLogin() {
        //Exception handling using try catch
        try {
            expectedMessage = "You have logged in successfully";

            //Perform Test Steps
            findEmailAddress().sendKeys("coding@project.com");
            findPassword().sendKeys("Coding@123");
            findLoginButton().click();

            actualMessage = getMessage();

            //Verfication
            Assert.assertEquals(actualMessage, expectedMessage);
        }
        catch (Exception ex){
            System.out.println("Exception in checkSuccessfullLogin Method : " + ex);
        }
    }

    @Test(priority = 2)
    public void checkUnsuccessfulLoginWithIncorrectEmail() {
        expectedMessage = "Wrong email address";

        findEmailAddress().sendKeys("xyz");
        findPassword().sendKeys("Coding@123");
        findLoginButton().click();

        actualMessage = getMessage();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    //Use dataprovider for running same test using multiple different values
    @Test(priority = 3, dataProvider = "passwordProvider")
    public void checkUnsuccessfulLoginWithIncorrectPassword(String password, String message) throws InterruptedException {
        expectedMessage = message;

        findEmailAddress().sendKeys("coding@project.com");
        findPassword().sendKeys(password);
        findLoginButton().click();

        actualMessage = getMessage();

        Assert.assertEquals(actualMessage, expectedMessage);
        // we can also use message in the Assert statements to let user know whey the methods failed
    }

    @Test(priority = 4)
    public void checkFaqPageIsNotBroken() {
        expectedMessage = "First helping point";

        findHelpLink().click();

        actualMessage = findFaqPage().getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @DataProvider
    private Object[][] passwordProvider() {
        return new Object[][]{
                {"IncorrectPass@1", "Email address and password doesn’t match"},
                {"IncorrectPass@2", "Email address and password doesn’t match"},
                {"IncorrectPass@3", "Email address and password doesn’t match." +
                        "You only have one more chance.Please contact RightEye Support at 800-301-0803"},
                {"IncorrectPass@4", "Your Email address is locked and invalid.Please contact RightEye Support at 800-301-0803."}
        };
    }
}
