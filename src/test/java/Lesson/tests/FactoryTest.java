package Lesson.tests;

import Lesson.pages.PageFactory;
import org.junit.Before;
import org.junit.Test;
import tests.BaseTest;


public class FactoryTest extends BaseTest {

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
