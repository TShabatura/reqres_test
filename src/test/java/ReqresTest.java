import endpoints.Endpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    @Test
    public void getUserByIdTest (){
        Response response = new Endpoints().getUserById(2);
        response.then().statusCode(200);
    }

    @Test
    public void getListOfUsersTest(){
        String endpoint = "https://reqres.in/api/users?page=2";
        Response response = given().when().get(endpoint);
        response.then().statusCode(200);
    }

    @Test
    public void getInexistentUserTest(){
        String endpoint = "https://reqres.in/api/user/100";
        Response response = given().when().get(endpoint);
        response.then().statusCode(404);
    }

    @Test
    public void getResourceByIdTest(){
        String endpoint = "https://reqres.in/api/unknown/2";
        Response response = given().when().get(endpoint);
        response.then().statusCode(200);
    }

    @Test
    public void getListOfResourcesTest(){
        String endpoint = "https://reqres.in/api/unknown";
        Response response = given().when().get(endpoint);
        response.then().statusCode(200);
    }

    @Test
    public void getInexistentResourceTest(){
        String endpoint = "https://reqres.in/api/unknown/100";
        Response response = given().when().get(endpoint);
        response.then().statusCode(404);
    }

    @Test
    public void createNewUserTest(){
        String endpoint = "https://reqres.in/api/users";
        String body = """
                        {
                            "name": "morpheus",
                            "job": "leader"
                        }
                """;
        Response response = given().body(body).when().post(endpoint);
        response.then().statusCode(201);
    }

    @Test
    public void updateExistedUserTest(){
        String endpoint = "https://reqres.in/api/users/";
        int id = 1;
        String body = """
                        {
                            "name": "morpheus",
                            "job": "leader"
                        }
                """;
        Response response = given().body(body).when().put(endpoint + id);
        response.then().statusCode(200);
    }

    @Test
    public void patchExistedUserTest(){
        String endpoint = "https://reqres.in/api/users/";
        int id = 1;
        String body = """
                        {
                            "name": "morpheus",
                            "job": "leader"
                        }
                """;
        Response response = given().body(body).when().patch(endpoint + id);
        response.then().statusCode(200);
    }

    @Test
    public void deleteExistedUserTest(){
        String endpoint = "https://reqres.in/api/users/";
        int id = 1;
        Response response = given().when().delete(endpoint + id);
        response.then().log().body();
        response.then().statusCode(204);
    }

    @Test
    public void successfulRegisterTest(){
        String endpoint = "https://reqres.in/api/register";
        String body = """
                        {
                            "email": "eve.holt@reqres.in",
                            "name": "pistol"
                        }
                """;
        Response response = given().body(body).when().post(endpoint);
        response.then().statusCode(200);
    }

    @Test
    public void unsuccessfulRegisterTest(){
        String endpoint = "https://reqres.in/api/register";
        String body = """
                        {
                            "email": "eve.holt@reqres.in"                       
                        }
                """;
        Response response = given().body(body).when().post(endpoint);
        response.then().statusCode(400);
    }

    @Test
    public void successfulLoginTest(){
        String endpoint = "https://reqres.in/api/login";
        String body = """
                        {
                            "email": "eve.holt@reqres.in",
                            "password": "cityslicka"
                        }
                """;
        Response response = given().body(body).when().post(endpoint);
        response.then().statusCode(200);
    }

    @Test
    public void unsuccessfulLoginTest() {
        String endpoint = "https://reqres.in/api/login";
        String body = """
                        {
                            "email": "eve.holt@reqres.in"
                        }
                """;
        Response response = given().body(body).when().post(endpoint);
        response.then().statusCode(400);
    }

    @Test
    public void delayedResponseTest(){
        String endpoint = "https://reqres.in/api/users?delay=3";
        Response response = given().when().get(endpoint);
        response.then().statusCode(200);
    }
}
