package Lesson.tests;

import org.junit.Before;
import org.junit.Test;
import Lesson.pages.LoginPage;

public class PageObjectLoginTest extends tests.BaseTest {

    private LoginPage loginPage;

    @Before
    public void init(){
        this.loginPage = new LoginPage(this.driver);
    }

    @Test
    public void negativeAuthTest(){
        this.loginPage.login("TestUser","TestPassword")
                .validateError("Incorrect username or password.");
    }

    @Test
    public void positiveAuthTest(){
        this.loginPage.login()
                .validateSuccess("Working with a team?");
    }


    @Test
    public void checkOurCommits(){
        this.loginPage.login()
                .openCommits();
    }



}
