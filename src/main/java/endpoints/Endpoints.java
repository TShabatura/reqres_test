package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Endpoints {
    private final static String BASE_ENDPOINT = "https://reqres.in/api/";

    public Response getUserById(int id){
        return given().when().get(BASE_ENDPOINT + "users/" + id).then().extract().response();
    }

    public Response getListOfUsersByPage(int page){
        return given().when().get(BASE_ENDPOINT + "users?page=" + page).then().extract().response();
    }
}
