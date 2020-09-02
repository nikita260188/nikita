package DZ.Tests;



import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(Parameterized.class)
public class DZ16 extends BaseTest{

    private MainPage page;
    private final String issueTitle;
    private final String issueComment;
    private final List<String> issueLabel;

    /**
     * Конструктор с переменными
     * @param title, comment, label
     */
    public DZ16(String title, String comment, List<String> label) {
        this.issueTitle = title;
        this.issueComment = comment;
        this.issueLabel = label;
    }

    /**
     * List с переменными
     */
    @Parameterized.Parameters
    public static List<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {"test_title1", "test_comment1", new ArrayList<String>(){
                    {
                        add ("bug");
                    }
                }},
                {"test_title2", "test_comment2", new ArrayList<String>(){
                    {
                        add ("documentation");
                    }
                }},
                {"test_title3", "test_comment3", new ArrayList<String>(){
                    {
                        add ("question");
                    }
                }},
                {"test_title4", "test_comment4", new ArrayList<String>(){
                    {
                        add ("bug");
                        add ("documentation");
                    }
                }},
                {"test_title5", "test_comment5", new ArrayList<String>(){
                    {
                        add ("bug");
                        add ("question");
                    }
                }},
                {"test_title6", "test_comment6", new ArrayList<String>(){
                    {
                        add ("documentation");
                        add ("question");
                    }
                }},
                {"test_title7", "test_comment7", new ArrayList<String>(){
                    {
                        add ("bug");
                        add ("documentation");
                        add ("question");
                    }
                }}
        });
    }

    /**
     * Тест с выполнением ДЗ-16
     */

    @Before
    public void init(){
        this.page = new LoginPage(this.driver).login();
    }

    @Test()
    public void checkSearch() {
        this.page
                .openSearchPages("nikita260188/nikita")
                .openIssuesPage()
                .pressCreateNewIssues()
                .createIssue (issueTitle,issueComment,issueLabel)
                .pressSubmitNewIssueButton()
                .checkNewIssue(issueTitle,issueComment);
    }


    @After
    public void exit(){
        this.page.signOut()
                .checkHomePage();
    }

}
