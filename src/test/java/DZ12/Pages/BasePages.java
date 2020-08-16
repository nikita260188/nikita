package DZ12.Pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePages {

    protected WebDriver driver;

    public BasePages(WebDriver driver){
        this.driver = driver;
    }

}
