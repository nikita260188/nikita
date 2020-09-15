package DZ.Tests;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static helpers.ExcelHelper.readColumnFromExcel;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class DZ14  extends BaseTest{


    private final String issueTitle;
    private final String issueComment;
    private LoginPage loginPage;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
//        Map<String, String> testData = loadDataForProvider(getProperty("user.dir") + "/src/test/resources/data/input/NewIssue2Values.txt");
//        Object[][] result = new Object[testData.keySet().size()][2];
//        List<String> logins = new ArrayList<>(testData.keySet());
//        for(int i = 0; i < testData.keySet().size(); i++){
//            result[i][0] = logins.get(i);
//            result[i][1] = testData.get(logins.get(i));
//        }
//        return Arrays.asList(result);
//    }
        List<String> testData = readColumnFromExcel(getProperty("user.dir")
                + "/src/test/resources/data/input/ExcelData.xlsx","Sheet2");
        List<Object[]> result = new ArrayList<>();
        testData.forEach(value->{
            String[] values = value.split(":");
            Object[] temp = new Object[]{
                    values[0], values[1]
            };
            result.add(temp);

        });
        return result;
    }


    public DZ14(String title, String comment){
        this.issueTitle = title;
        this.issueComment = comment;
    }

    @Before
    public void init() {
        this.loginPage = new LoginPage(this.driver);

    }

    /**
     * Тест с выполнением ДЗ-14
     */

    @Test
    public void DZ14() {
        this.loginPage.login()
                .openSearchPages()
                .openCodePage()
                .ShowAllTab()
                .openIssuesPage()
                .pressCreateNewIssues()
                .createNewIssue(issueTitle,issueComment)
                .pressSubmitNewIssueButton()
                .checkNewIssue(issueTitle,issueComment)
                .signOut()
                .checkHomePage();
    }

}
