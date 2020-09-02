package pages.workPanel.issues;


import pages.workPanel.WorkPanel;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuesPage extends WorkPanel {

    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    private final By NewIssueButton = By.xpath("//span [text()='New issue']");

    /**
     * Метод для нажатия на кнопку Create New Issues
     * @return new IssuesPage
     */

    public IssuesCreationPages pressCreateNewIssues(){
        LOG.info("Нажимаем на кнопку Create New Issues");
        Assert.assertTrue(this.driver.findElement(NewIssueButton).isEnabled());
        driver.findElement(NewIssueButton).click();
        LOG.info("Кнопку Create New Issues нажата");
        return new IssuesCreationPages (this.driver);
    }
}




