package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePages{

    protected final Logger LOG = LogManager.getLogger("Login Page");


    private final By usernameField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By errorMessage = By.xpath("//div[@class = 'container-lg px-2']");



    public LoginPage (WebDriver driver){

        super(driver);
    }

    /**
     * Метод для проверки для входа в github с системными переменными
     * @return new MainPage
     */

    public MainPage login(){
        validateTrue(driver.findElement(usernameField));
        validateTrue(driver.findElement(passwordField));
        validateTrue(driver.findElement(signInButton));
        driver.findElement(usernameField).sendKeys(System.getProperty("username"));
        driver.findElement(passwordField).sendKeys(System.getProperty("password"));
        driver.findElement(signInButton).click();
        return new MainPage(this.driver);
    }

    /**
     * Метод для проверки для входа в github с заданными переменными
     * @param username
     * @param password
     * @return new LoginPage
     */
    public LoginPage login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();

        return new LoginPage(this.driver);
    }

    /**
     * Метод для проверки error-сообщения
     * @param errorText
     */

    public void validateError(String errorText){
        Assert.assertEquals(errorText, driver.findElement(errorMessage).getText());
    }

    /**
     * Метод для логирования и проверки элементов
     */

    private void validateTrue(WebElement element){
        LOG.debug("Start test for enabled true for element: " + element);
        Assert.assertTrue(element.isEnabled());
        LOG.debug("Test finished");
    }


}
