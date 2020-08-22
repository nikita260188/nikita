package Pages.code;

import Pages.BasePages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class POMXmlPage extends BasePages {



    public POMXmlPage(WebDriver driver) {

        super(driver);
    }

    private final By seleniumID = By.id("LC25");
    private final By seleniumVersion = By.id("LC27");

    /**
     * Метод для проверки версии Selenium
     * @return измененную POMXmlPage
     */

    public POMXmlPage checkSeleniumVersion(){
        LOG.info("Проверяем версию Selenium");
        Assert.assertTrue(this.driver.findElement(seleniumID).isDisplayed());
        Logger LOG = LogManager.getLogger("Selenium Version");
        Assert.assertTrue(this.driver.findElement(seleniumVersion).isDisplayed());
        try {Assert.assertEquals("            <version>3.141.59</version>", driver.findElement(seleniumVersion).getText());
            LOG.info ("Версия Selenium 3.141.59");
        } catch (ComparisonFailure ignore) {LOG.error("Версия Selenium не 3.141.59 \n Данная версия - "
                + driver.findElement(seleniumVersion).getText()
                .replaceAll("<version>", "")
                .replaceAll("</version>", "")
                .replaceAll(" ", "")
        );
        }
        LOG.info("Версия Selenium проверена");
        return this;
    }

}
