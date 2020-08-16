package DZ12.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePages{

    public MainPage (WebDriver driver){
        super(driver);}

    private final By successHead = By.xpath("//h2[@class='hide-sm hide-md f5 mb-1 border-top pt-3']");
    private final String successMessage = "Working with a team?";
    private final By commitButton = By.xpath("//span[@class = 'css-truncate css-truncate-target']");
    private final By G44AutomationLink = By.xpath("//span[contains(text(), 'G44Automation')]");
    private final By userIcon = By.xpath("//summary[@aria-label='View profile and more']");
    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign out')]");
    private final By welcomeMessage = By.xpath("//h1[contains(text(), 'Built for developers')]");

    public void openCommits(){
        Assert.assertTrue(driver.findElement(commitButton).isDisplayed());
        driver.findElement(commitButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validateSuccess(String successMessage){
        Assert.assertTrue(this.driver.findElement(successHead).isDisplayed());
        Assert.assertEquals(successMessage, driver.findElement(successHead).getText());
    }

    public G44AutomationPage openG44Automation(){
        Assert.assertTrue(driver.findElement(G44AutomationLink).isDisplayed());
        driver.findElement(G44AutomationLink).click();
        return new G44AutomationPage(this.driver);
    }

    public void signOut (){
    Assert.assertTrue(this.driver.findElement(userIcon).isDisplayed());
        driver.findElement(userIcon).click();
        Assert.assertTrue(this.driver.findElement(signOutButton).isDisplayed());
        driver.findElement(signOutButton).click();
        Assert.assertTrue(this.driver.findElement(welcomeMessage).isDisplayed());
    }
}
