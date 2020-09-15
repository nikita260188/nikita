//package DZ.Tests;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import pages.LoginPage;
//import pages.MainPage;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.*;
//
//import static helpers.FileHelper.linesFromFile;
//import static helpers.FileHelper.loadDataForProvider;
//import static java.lang.System.getProperty;
//
//
//@RunWith(Parameterized.class)
//public class DataSource extends BaseTest{
//
//    private final static Logger log = LogManager.getLogger("Помошник для выбора источника данных");
//
//    private MainPage page;
//    private final String issueTitle;
//    private final String issueComment;
//    private final List<String> issueLabel;
//
//    /**
//     * Конструктор с переменными
//     * @param title, comment, label
//     */
//    public DataSource(String title, String comment, List<String> label) {
//        this.issueTitle = title;
//        this.issueComment = comment;
//        this.issueLabel = label;
//    }
//
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> createDataSourceFromFile (){
//        List<String,String,String>> resultAsList = new ArrayList<>();
//        linesFromFile(getProperty("user.dir") + "/src/test/resources/data/input/NewIssue2Values.txt")
//                .forEach(line->
//                        String tempString = new ArrayList<>());
//        Object[][] result = new Object[testData.keySet().size()][2];
//        List<String> logins = new ArrayList<>(testData.keySet());
//        for(int i = 0; i < testData.keySet().size(); i++){
//            result[i][0] = logins.get(i);
//            result[i][1] = testData.get(logins.get(i));
//        }
//        return Arrays.asList(result);
//    }
//
//    /**
//     * List с переменными
//     */
//    @Parameterized.Parameters
//    public static List<Object[]> params() {
//        return Arrays.asList(new Object[][]{
//                {"test_title1", "test_comment1", new ArrayList<String>(){
//                    {
//                        add ("bug");
//                    }
//                }},
//                {"test_title2", "test_comment2", new ArrayList<String>(){
//                    {
//                        add ("documentation");
//                    }
//                }},
//                {"test_title3", "test_comment3", new ArrayList<String>(){
//                    {
//                        add ("question");
//                    }
//                }},
//                {"test_title4", "test_comment4", new ArrayList<String>(){
//                    {
//                        add ("bug");
//                        add ("documentation");
//                    }
//                }},
//                {"test_title5", "test_comment5", new ArrayList<String>(){
//                    {
//                        add ("bug");
//                        add ("question");
//                    }
//                }},
//                {"test_title6", "test_comment6", new ArrayList<String>(){
//                    {
//                        add ("documentation");
//                        add ("question");
//                    }
//                }},
//                {"test_title7", "test_comment7", new ArrayList<String>(){
//                    {
//                        add ("bug");
//                        add ("documentation");
//                        add ("question");
//                    }
//                }}
//        });
//    }
//
//    /**
//     * Тест с выполнением ДЗ-16
//     */
//
//    @Before
//    public void init(){
//        this.page = new LoginPage(this.driver).login();
//    }
//
//    @Test()
//    public void checkSearch() {
//        this.page
//                .openSearchPages("nikita260188/nikita")
//                .openIssuesPage()
//                .pressCreateNewIssues()
//                .createIssue (issueTitle,issueComment,issueLabel)
//                .pressSubmitNewIssueButton()
//                .checkNewIssue(issueTitle,issueComment);
//    }
//
//
//    @After
//    public void exit(){
//        this.page.signOut()
//                .checkHomePage();
//    }
//
//}
//
//    public void some(){
//        //File testFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\input\\NewIssue2Values.txt");
//        List<List<String>> resultAsList = new ArrayList<>();
//        Map<String,String> result = new HashMap<>();
//        linesFromFile(getProperty("user.dir")+"\\src\\test\\resources\\data\\input\\NewIssue3Values.txt")
//                .forEach(line->{
//                    List<String> tempList = new ArrayList<>(Arrays.asList(line.split(":")));
//                    resultAsList.add(tempList);
//                });
////              .forEach(line->{
////                  String [] tempLineArray = line.split(":");
////                  result.put(tempLineArray[0],tempLineArray[1]);
////              });
//    System.out.println(resultAsList);
//
//    }
//
//}
