package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.management.DescriptorKey;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DashboardApiTest {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://demo.reportportal.io/api/v1";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    @Description("Создание новго Dashboard")
    public void createNewDashboardTest(){
        //JSON тело запроса
        String requestBody = "{ \"name\": \"New Dashboard\", \"description\": \"Created via API\", \"share\": true }";

        ValidatableResponse response =
                given()
                        .body(requestBody)
                        .when()
                        .post("/dashboards")
                        .then().log().all()
                        .statusCode(201) // ожидаемый статус
                        .body("name", equalTo("New Dashboard"));
    }

    @Test
    @Description("Создание нового Dashboard с недостаточными параметрами")
    public void createDashboardWithMissingParametersTest(){
        // отсутствует обязательный параметр
        String requestBody = "{ \"description\": \"Missing name field\", \"share\": true }";

        given()
                .body(requestBody)
                .when()
                .post("/dashboards")
                .then().log().all()
                .statusCode(400)
                .body("error", notNullValue());



    }
}
