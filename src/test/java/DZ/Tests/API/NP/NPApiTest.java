package DZ.Tests.API.NP;

import DZ.Tests.API.Privat.MethodNPHelper;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static java.lang.System.getProperty;

public class NPApiTest extends MethodNPHelper {


    @Test
    public void getCargoTypesNP(){
        Map<String, Object> testData = new HashMap<>();
        Map<String, Object> Data = new HashMap<>();
        testData.put("modelName", "Common");
        testData.put("calledMethod", "getCargoTypes");
        testData.put("apiKey", "4c1a644fc298161e29aa815462d76255");
        testData.put("methodProperties",Data);
        post(testData, "/getCargoTypes/json")
                .then()
                .log()
                .all(true)
                .spec(resSpec)
                .body(matchesJsonSchema(
                        new File(getProperty("user.dir")
                                + "/src/test/resources/schema-validation/getCargoTypesSchema")));
    }

    @Test
    public void getServiceTypesNP(){
        Map<String, Object> testData = new HashMap<>();
        Map<String, Object> Data = new HashMap<>();
        testData.put("modelName", "Common");
        testData.put("calledMethod", "getServiceTypes");
        testData.put("apiKey", "4c1a644fc298161e29aa815462d76255");
        testData.put("methodProperties",Data);
        post(testData, "/getServiceTypes/json")
                .then()
                .log()
                .all(true)
                .spec(resSpec)
                .body(matchesJsonSchema(
                        new File(getProperty("user.dir")
                                + "/src/test/resources/schema-validation/getServiceTypes")));
    }

}
