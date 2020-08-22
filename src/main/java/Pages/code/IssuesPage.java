package Pages.code;

import Pages.BasePages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuesPage extends BasePages {

    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    private final By NewIssueButton = By.xpath("//span [text()='New issue']");
    private final By issueTitleField = By.name("issue[title]");
    private final By issueBodyField = By.name("issue[body]");
    private final By SubmitNewIssueButton = By.xpath("//button[@type='submit' and contains(text(),'Submit new issue')]");
    private final By userIcon = By.xpath("//summary[@aria-label='View profile and more']");
    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign out')]");
    private final By welcomeMessage = By.xpath("//h1[contains(text(), 'Built for developers')]");
    private final By newIssueTitle = By.xpath("//span[@class='js-issue-title']");
    private final By newIssueBody = By.xpath("//tr[@class='d-block']");
    String issueTitle = "Test Title";
    String issueBody = "Test Body";


    /**
     * Метод для создания нового Issue
     * @return new IssuesPage
     */

    public IssuesPage createNewIssue() {
        LOG.info("Создаем новый Issue");
        Assert.assertTrue(this.driver.findElement(NewIssueButton).isEnabled());
        driver.findElement(NewIssueButton).click();
        Assert.assertTrue(this.driver.findElement(issueTitleField).isEnabled());
        driver.findElement(issueTitleField).sendKeys(issueTitle);
        Assert.assertTrue(this.driver.findElement(issueBodyField).isEnabled());
        driver.findElement(issueBodyField).sendKeys(issueBody);
        Assert.assertTrue(this.driver.findElement(SubmitNewIssueButton).isEnabled());
        driver.findElement(SubmitNewIssueButton).click();
        LOG.info("Новый Issue создан");
        return new IssuesPage (driver);
    }

    /**
     * Метод для проверки названия и описания
     * @return new IssuesPage
     */
    public IssuesPage checkNewIssue() {
        LOG.info("Проверяем название и описание созданного Issues");
        Assert.assertTrue(this.driver.findElement(newIssueTitle).isEnabled());
        Assert.assertEquals(issueTitle, driver.findElement(newIssueTitle).getText());
        Assert.assertTrue(this.driver.findElement(newIssueBody).isEnabled());
        Assert.assertEquals(issueBody, driver.findElement(newIssueBody).getText());
        LOG.info("Название и описание созданного Issues соответствуют");
        return new IssuesPage (driver);
    }

}




