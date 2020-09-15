package DZ.Tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.MainPage;

import java.util.Collection;
import java.util.List;

import static helpers.ExcelHelper.readProviderDataFromExcel;
import static java.lang.System.getProperty;


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
    public DZ16(Object title, Object comment, List<String> label) {
        this.issueTitle = title.toString();
        this.issueComment = comment.toString();
        this.issueLabel = label;
    }

    /**
     * Достаем параметры с файла
     */
    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return readProviderDataFromExcel(getProperty("user.dir")
                + "/src/test/resources/data/input/ExcelData.xlsx","Sheet3");
//        List<String> params = linesFromFile(getProperty("user.dir")
//                + "/src/test/resources/data/input/NewIssue3Values.txt");
//        List<Object[]> result = new ArrayList<>();
//                   params.forEach(value->{
//                       String[] values = value.split(":");
//                       String[] label = values[2].split(",");
//                       Object[] temp = new Object[]{
//                               values[0], values[1], Arrays.asList(label)
//                           };
//                           result.add(temp);
//
//                });
//        return result;
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

    @Test
    public void dfc(){
        System.out.println(issueLabel);
    }

    @After
    public void exit(){
        this.page.signOut()
                .checkHomePage();
    }

}
