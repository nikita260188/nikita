package DZ10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class QALightAboutPageTest {

    private final Logger LOG = LogManager.getLogger("Web driver test");



    @Test
    public void pageTest(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") +
                        "/src/main/resources/drivers/chrome/v85/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qalight.com.ua/o-nas/qalight-eto/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        driver.quit();
    }

}