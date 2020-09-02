package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePages{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By welcomeMessage = By.xpath("//h1[contains(text(), 'Built for developers')]");

    public void checkHomePage(){
        LOG.info("Проверка выхода из GitHub");
        Assert.assertTrue(this.driver.findElement(welcomeMessage).isDisplayed());
        LOG.info("Выход выполнен успешно.Мы не авторизированы");
    }


}
