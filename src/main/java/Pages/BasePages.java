package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public abstract class BasePages {


    protected WebDriver driver;
    protected Logger LOG;

    public BasePages(WebDriver driver){

        this.driver = driver;
        this.LOG = LogManager.getLogger(this);
    }

    private final By userIcon = By.xpath("//summary[@aria-label='View profile and more']");
    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign out')]");
    private final By welcomeMessage = By.xpath("//h1[contains(text(), 'Built for developers')]");

    /**
     * Метод для выхода из github
     */

    public void signOut(){
        LOG.info("Выходим из Git");
        Assert.assertTrue(this.driver.findElement(userIcon).isDisplayed());
        driver.findElement(userIcon).click();
        Assert.assertTrue(this.driver.findElement(signOutButton).isDisplayed());
        driver.findElement(signOutButton).click();
        Assert.assertTrue(this.driver.findElement(welcomeMessage).isDisplayed());
        LOG.info("Выход из Git успешно выполнен");
        try {
            sleep (500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
