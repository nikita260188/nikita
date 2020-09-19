package DZ.Tests.UI;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.MainPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static helpers.ExcelHelper.readProviderDataFromExcel;
import static helpers.FileHelper.linesFromFileDZ16;
import static java.lang.System.getProperty;


@RunWith(Parameterized.class)
public class DZ16Test extends BaseTest {

    private MainPage page;
    private final String issueTitle;
    private final String issueComment;
    private final List<String> issueLabel;

    /**
     * Конструктор с переменными
     * @param title, comment, label
     */

    public DZ16Test(Object title, Object comment, List<String> label) {
        this.issueTitle = title.toString();
        this.issueComment = comment.toString();
        this.issueLabel = label;
    }

    /**
     * Достаем параметры с file/excel
     */

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        List<Object[]> result = new ArrayList<>();
        switch (System.getProperty("source", "file")){
            case "excel":
                result =  readProviderDataFromExcel(getProperty("user.dir")
                + "/src/test/resources/data/input/ExcelData.xlsx","Sheet3");
            break;
            case "file":
                result = linesFromFileDZ16 (getProperty("user.dir")
                + "/src/test/resources/data/input/NewIssue3Values.txt");
            break;

    }
        return result;
    }

    /**
     * Тест с выполнением ДЗ-16
     */

    @Before
    public void init(){
        this.page = new LoginPage(this.driver).login();
    }

    /**
     * Тест с выполнением ДЗ-16
     */

    @Test
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
