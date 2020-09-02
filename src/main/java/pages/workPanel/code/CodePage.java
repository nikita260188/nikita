package pages.workPanel.code;


import pages.workPanel.WorkPanel;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CodePage extends WorkPanel {


    public CodePage(WebDriver driver) {
        super(driver);
    }


    private final By PomLink = By.xpath("//a[@title='pom.xml']");


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

}
