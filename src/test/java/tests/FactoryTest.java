package tests;

import org.junit.Before;
import org.junit.Test;
import Lesson.pages.PageFactory;

public class FactoryTest extends tests.BaseTest {

    private PageFactory factory;

    @Before
    public void init(){
        factory = new PageFactory(driver);

    }

    @Test
    public void checkLogin(){
       factory.login();
    }

}
