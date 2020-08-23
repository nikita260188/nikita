package Pages;

import Pages.code.CodePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SearchPage extends BasePages{

    public SearchPage(WebDriver driver) {

        super(driver);
    }

    private final By LinkG44Automation = By.xpath("//a [contains(@data-hydro-click, 'https://github.com/BKuso/G44Automation')]");

    /**
     * Метод для входа в репозиторий BKuso/G44Automation
     * @return new CodePage
     */
    public CodePage openCodePage(){
        LOG.info("Выбираем репозиторий G44Automation");
        List<WebElement> link = driver.findElements (LinkG44Automation);
        WebElement ourLink = link.stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .orElse(driver.findElement(LinkG44Automation));
        Assert.assertTrue("Репозиторий не доступен для нажатия",
                ourLink.isDisplayed());
        ourLink.click();
        LOG.info("Переходим в репозиторий G44Automation");
        return new CodePage(this.driver);
    }
}


