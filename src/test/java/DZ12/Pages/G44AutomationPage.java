package DZ12.Pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.junit.ComparisonFailure;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;




public class G44AutomationPage extends BasePages{


    public G44AutomationPage (WebDriver driver){
        super(driver);}

    private final By PomLink = By.xpath("//a[@title='pom.xml']");
    private final By BKusoLink = By.xpath("//a[@href='/BKuso/G44Automation']"); //Ссылка на страницу /BKuso/G44Automation
    private final By seleniumID = By.id("LC25");
    private final By seleniumVersion = By.id("LC27");
    private final By userIcon = By.xpath("//summary[@aria-label='View profile and more']");
    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign out')]");
    private final By welcomeMessage = By.xpath("//h1[contains(text(), 'Built for developers')]");



    public void checkSeleniumVersion(){
        Assert.assertTrue(this.driver.findElement(BKusoLink).isDisplayed());
        driver.findElement(BKusoLink).click();                                  // Переход на страницу /BKuso/G44Automation
        Assert.assertTrue(this.driver.findElement(PomLink).isDisplayed());
        driver.findElement(PomLink).click();
        Assert.assertTrue(this.driver.findElement(seleniumID).isDisplayed());
        Logger LOG = LogManager.getLogger("Selenium Version");
        Assert.assertTrue(this.driver.findElement(seleniumVersion).isDisplayed());
        try {Assert.assertEquals("            <version>3.141.59</version>", driver.findElement(seleniumVersion).getText());
            LOG.info ("Версия Selenium 3.141.59");
        } catch (ComparisonFailure ignore) {LOG.error("Версия Selenium не 3.141.59 \n Данная версия - " + driver.findElement(seleniumVersion).getText().substring(21,29));
        }
        Assert.assertTrue(this.driver.findElement(userIcon).isDisplayed());
        driver.findElement(userIcon).click();
        Assert.assertTrue(this.driver.findElement(signOutButton).isDisplayed());
        driver.findElement(signOutButton).click();
        Assert.assertTrue(this.driver.findElement(welcomeMessage).isDisplayed());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
