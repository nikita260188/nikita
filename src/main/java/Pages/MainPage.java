package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.*;

public class MainPage extends BasePages{

    public MainPage (WebDriver driver){
        super(driver);}

    private final By successHead = By.xpath("//h2[@class='hide-sm hide-md f5 mb-1 border-top pt-3']");
    private final String successMessage = "Working with a team?";
    private final By commitButton = By.xpath("//span[@class = 'css-truncate css-truncate-target']");
    private final By InputSearch = By.xpath("//input [@aria-label='Search or jump to…']");

    /**
     * Метод для входа в свой репозиторий nikita260188/nikita
     */

    public void openCommits(){
        Assert.assertTrue(driver.findElement(commitButton).isDisplayed());
        driver.findElement(commitButton).click();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для проверки сообщения на странице MainPage
     * @param successMessage
     * @return измененную MainPage
     */

    public MainPage validateSuccess(String successMessage){
        Assert.assertTrue(this.driver.findElement(successHead).isDisplayed());
        Assert.assertEquals(successMessage, driver.findElement(successHead).getText());
        return this;
    }

    /**
     * Метод для поиска репозитория BKuso/G44Automation
     * @return new SearchPage
     */

    public SearchPage openSearchPages() {
        LOG.info("Вводим в поисковое пооле название репозитория");
        Assert.assertTrue(this.driver.findElement(InputSearch).isEnabled());
        driver.findElement(InputSearch).sendKeys("BKuso/G44Automation \n");
        LOG.info("Переходим на страницу результатов поиска");
        return new SearchPage (driver);

    }
}
