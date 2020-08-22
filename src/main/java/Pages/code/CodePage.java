package Pages.code;

import Pages.BasePages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CodePage extends BasePages {


    public CodePage(WebDriver driver) {
        super(driver);
    }


    private final By PomLink = By.xpath("//a[@title='pom.xml']");
    private final By Tabs = By.xpath("//li [@class='d-flex']");

    /**
     * Метод для открития файла pom.xml
     * @return new  POMXmlPage
     */

    public POMXmlPage openPomFile() {
        LOG.info("Открываем файл pom.xml");
        Assert.assertTrue(this.driver.findElement(PomLink).isDisplayed());
        this.driver.findElement(PomLink).click();
        LOG.info("Файл pom.xml открыт");
        return new  POMXmlPage (driver);
    }


    /**
     * Метод для вывода вкладок на странице репозитория
     * @return измененную CodePage
     */

    public CodePage ShowAllTab (){
        LOG.info("Выводим вкладки");
        driver.findElements(Tabs).forEach(
                tab ->{
                    Assert.assertTrue(tab.isDisplayed());
                    LOG.info("Найдена вкладка: " + tab.getText().replaceAll("\n|\r\n"," - "));
                });
        LOG.info("Вывод вкладок завершен");
                return this;

    }

    /**
     * Метод для входа на вкладку Issues
     * @return new IssuesPage
     */

    public IssuesPage openIssuesPage(){
        LOG.info("Заходим на вкладку Issues");
        Assert.assertTrue("Репозиторий не доступен для нажатия",
                this.driver.findElements(Tabs).get(1).isEnabled());
        driver.findElements(Tabs).get(1).click();
        LOG.info("Вход на вкладку Issues выполнен");
        return new IssuesPage (this.driver);

    }
}
