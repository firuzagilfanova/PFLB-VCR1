package API_UXCrowd;

import Config.EnvConfig;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TestAPI {
 EnvConfig envConfig = new EnvConfig();
   @Test
    public void contact(){
       String name = given()
               .when()
               .contentType(ContentType.JSON)
               .get(envConfig.baseUrl+"/api/public/contact?description=prov&email=prov@prov.ru&name=prov&phone=7+(333)+333+3333")
               .then().statusCode(200).toString();
       System.out.println(name);
   }

   @Test
    public void getAllTariffs() {
        List<TariffBody> tariffList = given()
                .when()
                .contentType(ContentType.JSON)
                .get(envConfig.baseUrl + "/api/v2/tariff")
                .then().log().all()
                .extract().body().jsonPath().getList("$", TariffBody.class);
        System.out.println(tariffList);
    }

    @Test
    public void getOrderInfoById(){
        String order = String.valueOf(given()
                .when()
                .contentType(ContentType.JSON)
                .get(envConfig.baseUrl + "/api/public/order-info?id=28821087")
                .then().log().all());
        System.out.println(order);
    }
}
