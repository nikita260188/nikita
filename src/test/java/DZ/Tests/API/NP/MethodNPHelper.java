package DZ.Tests.API.NP;

import entities.BaseEntity;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public abstract class MethodNPHelper extends DZ.Tests.API.NP.BaseNPApiTest {

    protected Response get(Map<String, Object> params, String partOfUrl){
        return given()
                .spec(reqSpec)
                .queryParams(params)
                .when()
                .log()
                .body(true)
                .get(partOfUrl);
    }

    protected Response get(String partOfUrl){
        return given()
                .spec(reqSpec)
                .when()
                .log()
                .all(true)
                .get(partOfUrl);
    }

    protected Response post(Map<String, Object> body, String partOfUrl){
        return given()
                .spec(reqSpec)
                .body(body)
                .contentType("application/json")
                .accept(JSON)
                .when()
                .log()
                .all(true)
                .post(partOfUrl);
    }

    protected Response post(BaseEntity body, String partOfUrl){
        return given()
                .spec(reqSpec)
                .contentType(JSON)
                .body(body)
                .when()
                .log()
                .all(true)
                .get(partOfUrl);
    }

}
