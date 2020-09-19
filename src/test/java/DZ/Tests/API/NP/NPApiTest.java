package DZ.Tests.API.NP;

import DZ.Tests.API.Privat.MethodNPHelper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NPApiTest extends MethodNPHelper {


    @Test
    public void getNP(){
        Map<String, Object> testData = new HashMap<>();
        Map<String, Object> Data = new HashMap<>();
        testData.put("modelName", "Common");
        testData.put("calledMethod", "getCargoTypes");
        testData.put("apiKey", "4c1a644fc298161e29aa815462d76255");
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
