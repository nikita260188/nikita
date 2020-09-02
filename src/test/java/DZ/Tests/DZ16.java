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
    private String issueTitle;
    private String issueComment;
    private List<String> issueLabel;

    public DZ16(String title, String comment, List<String> label) {
        this.issueTitle = title;
        this.issueComment = comment;
        this.issueLabel = label;
    }



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
                .pressSubmitNewIssueButton();
    }

//    private String concatenate (Object... params){
//        StringBuilder builder = new StringBuilder();
//        Arrays.stream(params).forEach(param ->builder.append(param).append(", "));
//        return builder.toString();
//    }

    @After
    public void exit(){
        this.page.signOut()
                .checkHomePage();
    }

}
