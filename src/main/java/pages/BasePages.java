package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;



public abstract class BasePages {


    protected WebDriver driver;
    protected Logger LOG;

    public BasePages(WebDriver driver){

        this.driver = driver;
        this.LOG = LogManager.getLogger(this);
    }






}
