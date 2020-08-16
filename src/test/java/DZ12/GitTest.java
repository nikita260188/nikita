package DZ12;

import DZ12.Pages.LoginPage;
import org.junit.Before;
import org.junit.Test;

public class GitTest extends BaseTest {

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
            this.loginPage.login().
                    validateSuccess("Working with a team?");
    }

        @Test
        public void checkOurCommits(){
            this.loginPage.login()
                    .openCommits();
    }

    @Test
    public void checkG44Automation(){
        this.loginPage.login()
                .openG44Automation().checkSeleniumVersion();
    }
}

