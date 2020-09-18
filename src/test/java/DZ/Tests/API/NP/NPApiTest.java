package DZ.Tests.API.NP;

import DZ.Tests.API.Privat.MethodNPHelper;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NPApiTest extends MethodNPHelper {

    @Ignore
    @Test
    public void getNP(){
        Map<String, Object> testData = new HashMap<>();
        Map<String, Object> Data = new HashMap<>();
        testData.put("modelName", "Common");
        testData.put("calledMethod", "getCargoTypes");
        testData.put("apiKey", "a011a4e3b502bdb46765dfe0e73a2e7c");
        testData.put("methodProperties",Data);
        post(testData, "/v2.0/common/getCargoTypes/json")
                .then()
                .log()
                .all(true)
                .spec(resSpec);
//                .body(matchesJsonSchema(
//                        new File(getProperty("user.dir")
//                                + "/src/test/resources/schema-validation/getPubinfoSchema.json")));
    }

}
