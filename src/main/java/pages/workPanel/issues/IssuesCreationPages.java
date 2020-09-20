package pages.workPanel.issues;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.WorkPanel;
import java.util.List;




public class IssuesCreationPages extends WorkPanel {

    public IssuesCreationPages(WebDriver driver) {
        super(driver);
    }

    private final By issueTitleField = By.name("issue[title]");
    private final By issueCommentField = By.name("issue[body]");
    private final By additionalFieldButtons = By.id("labels-select-menu");
    private final By labelSearchField = By.name("//details[@id='labels-select-menu']/summary");
    private final By SubmitNewIssueButton = By.xpath("//button[@type='submit' and contains(text(),'Submit new issue')]");
    private By labelLocator(String name){
        return By.xpath(String.format( "//span[text()='%s']", name));
    }

    /**
     * Метод для введения параметров (String+String+List<String>) в issue
     * @param Title
     * @param Comment
     * @param Labels
     * @return
     */
    @Step("Вводим параметры в issue")
    public IssuesCreationPages createIssue (String Title, String Comment, List<String> Labels){
        LOG.info("Создаем новый issue с параметрами  " + Title + " : "+ Comment + " : "+ Labels);
        Assert.assertTrue(this.driver.findElement(issueTitleField).isEnabled());
        driver.findElement(issueTitleField).sendKeys(Title);
        Assert.assertTrue(this.driver.findElement(issueCommentField).isEnabled());
        driver.findElement(issueCommentField).sendKeys(Comment);
        this.driver.findElement(additionalFieldButtons).click();
        Labels.forEach(label ->{
            Assert.assertTrue(this.driver.findElement(labelLocator(label)).isEnabled());
            this.driver.findElement(labelLocator(label)).click();
        });
        driver.findElement(additionalFieldButtons).click();
        LOG.info("Параметры введены");
        return new IssuesCreationPages (this.driver);
    }

    /**
     * Метод для нажатия на кнопку Submit New Issue
     * @return
     */
    @Step("Нажимаем на кнопку Submit New Issue")
    public IssuePage pressSubmitNewIssueButton(){
        LOG.info("Нажимаем на кнопку Submit New Issue");
        Assert.assertTrue(this.driver.findElement(SubmitNewIssueButton).isEnabled());
        driver.findElements(SubmitNewIssueButton).get(0).click();
        LOG.info("Новый issue создан");
        return new IssuePage (this.driver);
    }

    /**
     * Метод для введения 2-х типа String параметров в issue
     * @return
     */
    @Step("Вводим параметры в issue")
    public IssuesCreationPages createNewIssue(String issueTitle,String issueBody) {
        LOG.info("Создаем новый issue с параметрами  " + issueTitle + " : "+ issueBody);
        Assert.assertTrue(this.driver.findElement(issueTitleField).isEnabled());
        driver.findElement(issueTitleField).sendKeys(issueTitle);
        Assert.assertTrue(this.driver.findElement(issueCommentField).isEnabled());
        driver.findElement(issueCommentField).sendKeys(issueBody);
        LOG.info("Параметры введены");
        return new IssuesCreationPages(driver);
    }

}

