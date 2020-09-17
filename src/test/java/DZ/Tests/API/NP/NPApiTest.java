package DZ.Tests.API.NP;

import DZ.Tests.API.Privat.MethodNPHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NPApiTest extends MethodNPHelper {

    @Test
    public void getNP(){
        Map<String, Object> testData = new HashMap<>();
        List<Object[]> Data = new ArrayList<>();
        testData.put("modelName", "Common");
        testData.put("calledMethod", "getTypesOfCounterparties");
        testData.put("apiKey", "a011a4e3b502bdb46765dfe0e73a2e7c");
        testData.put("methodProperties",Data);
        post(testData, "/common/getTypesOfCounterparties/json/")
                .then()
                .log()
                .all(true)
                .spec(resSpec);
//                .body(matchesJsonSchema(
//                        new File(getProperty("user.dir")
//                                + "/src/test/resources/schema-validation/getPubinfoSchema.json")));
    }

}
