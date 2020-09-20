package pages.workPanel.issues;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.WorkPanel;

public class IssuePage extends WorkPanel {

    public IssuePage(WebDriver driver) {
        super(driver);
    }


    private final By newIssueTitle = By.xpath("//span[@class='js-issue-title']");
    private final By newIssueBody = By.xpath("//tr[@class='d-block']");


    /**
     * Метод для проверки названия и описания
     * @return new IssuesPage
     */
    @Step("Проверяем названия и описания")
    public IssuesPage checkNewIssue(String Title, String Comment) {
        LOG.info("Проверяем название и описание созданного Issues");
        Assert.assertTrue(this.driver.findElement(newIssueTitle).isEnabled());
        Assert.assertEquals(Title, driver.findElement(newIssueTitle).getText());
        Assert.assertTrue(this.driver.findElement(newIssueBody).isEnabled());
        Assert.assertEquals(Comment, driver.findElement(newIssueBody).getText());
        LOG.info("Название и описание созданного Issues соответствуют");
        return new IssuesPage(driver);
    }

}


