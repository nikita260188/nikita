package DZ.Tests;

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
public class NegativeAuth extends BaseTest{

    private LoginPage loginPage;

    private final String username;
    private final String password;

    /**
     * Достаем параметры с file/excel
     */

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> result = new ArrayList<>();
        switch (System.getProperty("source", "file")){
            case "excel":
                List<String> testDataExcel = readColumnFromExcel(getProperty("user.dir")
                        + "/src/test/resources/data/input/ExcelData.xlsx", "Sheet1");
                List<Object[]> resultExcel= new ArrayList<>();
                testDataExcel.forEach(value -> {
                    String[] values = value.split(":");
                    Object[] temp = new Object[]{
                            values[0], values[1]
                    };
                    resultExcel.add(temp);

                });
                result = resultExcel;
                break;

                case "file":
                    Map<String, String> testData = loadDataForProvider(getProperty("user.dir")
                            + "/src/test/resources/data/input/negativeAuthData.txt");
                    Object[][] resultFile = new Object[testData.keySet().size()][2];
                    List<String> logins = new ArrayList<>(testData.keySet());
                        for(int i = 0; i < testData.keySet().size(); i++){
                            resultFile[i][0] = logins.get(i);
                            resultFile[i][1] = testData.get(logins.get(i));
                        }
                    result = Arrays.asList(resultFile);
                    break;
        }
            return result;
    }

    /**
     * Конструктор с переменными
     * @param login, password
     */

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
