package pages;

import pages.workPanel.code.CodePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public abstract class Header extends BasePages{

    private final By InputSearch = By.xpath("//input [@aria-label='Search or jump to…']");
    private final By userIcon = By.xpath("//summary[@aria-label='View profile and more']");
    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign out')]");
    private final By myIssuesButton = By.xpath("//a [@aria-label='Issues you created']");
    private final By searchResultList = By.xpath("//ul [@id='jump-to-results']/li/a");

    public Header(WebDriver driver) {
        super(driver);
    }



    /**
     * Метод для выхода из github
     */

    public HomePage signOut(){
        LOG.info("Выходим из Git");
        this.driver.navigate().refresh();
        Assert.assertTrue(this.driver.findElement(userIcon).isDisplayed());
        driver.findElement(userIcon).click();
        Assert.assertTrue(this.driver.findElement(signOutButton).isDisplayed());
        driver.findElement(signOutButton).click();
        LOG.info("Выход из Git успешно выполнен");
        try {
            sleep (500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new HomePage(this.driver);
    }

    public MyIssuesPage openMyIssues(){
        Assert.assertTrue(this.driver.findElement(myIssuesButton).isDisplayed());
        this.driver.findElement(myIssuesButton).click();
        return new MyIssuesPage(this.driver);
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

    /**
     * Метод для поиска репозитория введенного в метод
     * @return new SearchPage
     */

    public CodePage openSearchPages(String projectTitle) {
        LOG.info("Ищем репозиторий " + projectTitle);
        Assert.assertTrue(this.driver.findElement(InputSearch).isEnabled());
        driver.findElement(InputSearch).sendKeys(projectTitle);
        driver.findElement(InputSearch).click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> results = this.driver.findElements(searchResultList);
        results.stream()
                .filter(result -> result.getAttribute("href").contains(projectTitle))
                .findFirst()
                .orElse(results.get(1))
                .click();

//        for (WebElement result: results){
//            if (result.getText().contains(projectTitle)){
//                result.click();
//            }
//        }

        LOG.info(String.format("Переходим на страницу репозитория ", projectTitle));
        return new CodePage (driver);
    }

}
