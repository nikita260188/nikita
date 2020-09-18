package DZ.Tests.UI;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.*;

import static helpers.ExcelHelper.readColumnFromExcel;
import static helpers.FileHelper.loadDataForProvider;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class DZ14  extends BaseTest {


    private final String issueTitle;
    private final String issueComment;
    private LoginPage loginPage;

    /**
     * Достаем параметры с file/excel
     */

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> result = new ArrayList<>();
        switch (System.getProperty("source", "file")){
            case "excel":
        List<String> testData = readColumnFromExcel(getProperty("user.dir")
                + "/src/test/resources/data/input/ExcelData.xlsx","Sheet2");
        List<Object[]> resultExcel = new ArrayList<>();
        testData.forEach(value->{
            String[] values = value.split(":");
            Object[] temp = new Object[]{
                    values[0], values[1]
            };
            resultExcel.add(temp);


        });
                result = resultExcel;
                break;
            case "file":
                Map<String, String> testFileData = loadDataForProvider(getProperty("user.dir") + "/src/test/resources/data/input/NewIssue2Values.txt");
                Object[][] resultFile = new Object[testFileData.keySet().size()][2];
                List<String> logins = new ArrayList<>(testFileData.keySet());
                for(int i = 0; i < testFileData.keySet().size(); i++){
                    resultFile[i][0] = logins.get(i);
                    resultFile[i][1] = testFileData.get(logins.get(i));
                }
                result = Arrays.asList(resultFile);
            }
        return result;
    }


    /**
     * Конструктор с переменными
     * @param title, comment
     */

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
