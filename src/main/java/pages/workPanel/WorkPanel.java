package pages.workPanel;

import pages.Header;
import pages.workPanel.actions.ActionsPage;
import pages.workPanel.code.CodePage;
import pages.workPanel.insights.InsightsPage;
import pages.workPanel.issues.IssuesPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.projects.ProjectsPage;
import pages.workPanel.pullRequests.PullRequestsPage;
import pages.workPanel.security.SecurityPage;
import pages.workPanel.wiki.WikiPage;

public class WorkPanel extends Header {

    private final By codeButton = By.xpath("//li[@class = 'd-flex']/a [@data-tab-item = 'code-tab']");
    private final By issuesButton = By.xpath("//li[@class = 'd-flex']/a [contains (@href,'/issues')]");
    private final By pullRequestsButton = By.xpath("//li[@class = 'd-flex']/a [contains (@href,'/pulls')]");
    private final By actionsButton = By.xpath("//li[@class = 'd-flex']/a [contains (@href,'/actions')]");
    private final By projectsButton = By.xpath("//li[@class = 'd-flex']/a [contains (@href,'/projects')]");
    private final By wikiButton = By.xpath("//li[@class = 'd-flex']/a [contains (@href,'/wiki')]");
    private final By securityButton = By.xpath("//li[@class = 'd-flex']/a [contains (@href,'/security')]");
    private final By insightsButton = By.xpath("//li[@class = 'd-flex']/a [contains (@href,'/pulse')]");
    private final By Tabs = By.xpath("//li [@class='d-flex']");

    public WorkPanel(WebDriver driver) {
        super(driver);
    }


    /**
     * Метод для входа на вкладку Code
     * @return new CodePage
     */

    public CodePage openCodePage (){
        LOG.info("Заходим на вкладку Code");
        Assert.assertTrue(this.driver.findElement(codeButton).isDisplayed());
        driver.findElement(codeButton).click();
        LOG.info("Вход на вкладку Code выполнен");
        return new CodePage (this.driver);
    }

    /**
     * Метод для входа на вкладку Issues
     * @return new IssuesPage
     */

    public IssuesPage openIssuesPage (){
        LOG.info("Заходим на вкладку Issues");
        Assert.assertTrue(this.driver.findElement(issuesButton).isDisplayed());
        driver.findElement(issuesButton).click();
        LOG.info("Вход на вкладку Issues выполнен");
        return new IssuesPage (this.driver);

    }

    /**
     * Метод для входа на вкладку Pull Requests
     * @return new PullRequestsPage
     */

    public PullRequestsPage openPullRequestsPage (){
        LOG.info("Заходим на вкладку Pull Requests");
        Assert.assertTrue(this.driver.findElement(pullRequestsButton).isDisplayed());
        driver.findElement(pullRequestsButton).click();
        LOG.info("Вход на вкладку Pull Requests выполнен");
        return new PullRequestsPage (this.driver);
    }

    /**
     * Метод для входа на вкладку Actions
     * @return new ActionsPage
     */

    public ActionsPage openActionsPage (){
        LOG.info("Заходим на вкладку Actions");
        Assert.assertTrue(this.driver.findElement(actionsButton).isDisplayed());
        driver.findElement(actionsButton).click();
        LOG.info("Вход на вкладку Actions выполнен");
        return new ActionsPage (this.driver);
    }

    /**
     * Метод для входа на вкладку Projects
     * @return new ProjectsPage
     */

    public ProjectsPage openProjectsPage (){
        LOG.info("Заходим на вкладку Projects");
        Assert.assertTrue(this.driver.findElement(projectsButton).isDisplayed());
        driver.findElement(projectsButton).click();
        LOG.info("Вход на вкладку Projects выполнен");
        return new ProjectsPage (this.driver);
    }

    /**
     * Метод для входа на вкладку Wiki
     * @return new WikiPage
     */

    public WikiPage openWikiPage (){
        LOG.info("Заходим на вкладку Wiki");
        Assert.assertTrue(this.driver.findElement(wikiButton).isDisplayed());
        driver.findElement(wikiButton).click();
        LOG.info("Вход на вкладку Wiki выполнен");
        return new WikiPage (this.driver);
    }

    /**
     * Метод для входа на вкладку Security
     * @return new SecurityPage
     */

    public SecurityPage openSecurityPage (){
        LOG.info("Заходим на вкладку Security");
        Assert.assertTrue(this.driver.findElement(securityButton).isDisplayed());
        driver.findElement(securityButton).click();
        LOG.info("Вход на вкладку Security выполнен");
        return new SecurityPage (this.driver);
    }

    /**
     * Метод для входа на вкладку Insights
     * @return new InsightsPage
     */

    public InsightsPage openInsightsPage (){
        LOG.info("Заходим на вкладку Insights");
        Assert.assertTrue(this.driver.findElement(insightsButton).isDisplayed());
        driver.findElement(insightsButton).click();
        LOG.info("Вход на вкладку Insights выполнен");
        return new InsightsPage (this.driver);
    }

    /**
     * Метод для вывода вкладок на странице репозитория
     * @return измененную CodePage
     */

    public WorkPanel ShowAllTab (){
        LOG.info("Выводим вкладки");
        driver.findElements(Tabs).forEach(
                tab ->{
                    Assert.assertTrue(tab.isDisplayed());
                    LOG.info("Найдена вкладка: " + tab.getText().replaceAll("\n|\r\n"," - "));
                });
        LOG.info("Вывод вкладок завершен");
        return this;

    }
}
