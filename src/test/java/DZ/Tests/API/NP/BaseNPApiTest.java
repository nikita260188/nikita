package DZ.Tests.API.Privat;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;

public abstract class BaseNPApiTest {

    protected Logger log = LogManager.getLogger(this.getClass().getName());

    protected RequestSpecification reqSpec;
    protected ResponseSpecification resSpec;

    @Before
    public void setUp(){
        this.reqSpec = new RequestSpecBuilder()
                .setBaseUri("http://testapi.novaposhta.ua/v2.0")
                .addQueryParam("Content-Type","application/json")
                .build();
        this.resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }


}
