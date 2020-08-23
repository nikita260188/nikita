package DZ.Tests;

import Pages.LoginPage;
import Pages.MainPage;
import org.junit.Before;
import org.junit.Test;

public class GitTest extends BaseTest  {

    private LoginPage loginPage;
    private MainPage mainPages;


    @Before
    public void init(){
    this.loginPage = new LoginPage(this.driver);

    }

    /**
     * Выполнение негативного теста входа
     */

    @Test
    public void negativeAuthTest(){
            this.loginPage.login("TestUser","TestPassword")
                    .validateError("Incorrect username or password.");

    }

    /**
     * Выполнение позитивного теста входа
     */

    @Test
    public void positiveAuthTest(){
        mainPages = this.loginPage.login()
                .validateSuccess("Working with a team?");
    }

    /**
     * Тест входа в свой репозиторий
     */

    @Test
    public void checkOurCommits(){
        this.loginPage.login()
                .openCommits();
    }

    /**
     * Тест с выполнением ДЗ-12
     */

    @Test
    public void DZ12(){
        this.loginPage.login()
                .openSearchPages()
                .openCodePage()
                .openPomFile()
                .checkSeleniumVersion()
                .signOut();
    }

    /**
     * Тест с выводом всех версий библиотек в pom.xml
     */

    @Test
    public void checkPom(){
        this.loginPage.login()
                .openSearchPages()
                .openCodePage()
                .openPomFile()
                .showAllVersion()
                .signOut();
    }

    /**
     * Тест с выполнением ДЗ-14
     */

    @Test
    public void DZ14 (){
        this.loginPage.login()
                .openSearchPages()
                .openCodePage()
                .ShowAllTab()
                .openIssuesPage()
                .createNewIssue()
                .checkNewIssue()
                .signOut();
    }
}

