package pages.workPanel.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.WorkPanel;

import java.util.Arrays;

import static java.lang.Thread.sleep;


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

    public IssuesCreationPages createIssue (String Title, String Comment, String... Labels){
        Assert.assertTrue(this.driver.findElement(issueTitleField).isEnabled());
        driver.findElement(issueTitleField).sendKeys(Title);
        Assert.assertTrue(this.driver.findElement(issueCommentField).isEnabled());
        driver.findElement(issueCommentField).sendKeys(Comment);
        this.driver.findElement(additionalFieldButtons).click();
        Arrays.stream(Labels).forEach(label ->{
            Assert.assertTrue(this.driver.findElement(labelLocator(label)).isEnabled());
            this.driver.findElement(labelLocator(label)).click();
        });
        driver.findElement(additionalFieldButtons).click();
        return new IssuesCreationPages (this.driver);
    }

    public IssuePage pressSubmitNewIssueButton(){
        Assert.assertTrue(this.driver.findElement(SubmitNewIssueButton).isEnabled());
        driver.findElements(SubmitNewIssueButton).get(0).click();
        return new IssuePage (this.driver);
    }

}

