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
public class NegativeAuth extends BaseTest{

    private LoginPage loginPage;

    private final String username;
    private final String password;

    @Parameterized.Parameters
//    public static Collection<Object[]> data(){
//        Map<String, String> testData = loadDataForProvider(getProperty("user.dir") + "/src/test/resources/data/input/negativeAuthData.txt");
//        Object[][] result = new Object[testData.keySet().size()][2];
//        List<String> logins = new ArrayList<>(testData.keySet());
//        for(int i = 0; i < testData.keySet().size(); i++){
//            result[i][0] = logins.get(i);
//            result[i][1] = testData.get(logins.get(i));
//        }
//        return Arrays.asList(result);
//    }

    public static Collection<Object[]> data(){
        List<String> testData = readColumnFromExcel(getProperty("user.dir")
                + "/src/test/resources/data/input/ExcelData.xlsx","Sheet1");
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

    public NegativeAuth(String login, String password){
        this.username = login;
        this.password = password;
    }
    
    /**
     * Выполнение негативного теста входа
     */

    @Test
    public void negativeAuthTest(){
        this.loginPage.login(this.username, this.password)
                .validateError("Incorrect username or password.");
    }

    @Before
    public void init(){
        this.loginPage = new LoginPage(this.driver);
    }

}
