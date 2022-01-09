package endpoints;

import io.restassured.response.Response;
import models.CreateModel;
import models.LoginModel;
import models.RegisterModel;
import models.UpdateModel;

import static io.restassured.RestAssured.given;

public class Endpoints {
    private final static String BASE_ENDPOINT = "https://reqres.in/api/";

    public Response getUserById(int id){
        return given().
                when().get(BASE_ENDPOINT + "users/" + id).
                then().extract().response();
    }

    public Response getListOfUsersByPage(int page){
        return given().
                when().get(BASE_ENDPOINT + "users?page=" + page).
                then().extract().response();
    }

    public Response getResourceById(int id){
        return given().
                when().get(BASE_ENDPOINT + "unknown/" + id).
                then().extract().response();
    }

    public Response getListOfResourcesByPage(int page){
        return given().
                when().get(BASE_ENDPOINT + "unknown?page=" + page).
                then().extract().response();
    }

    public Response createUser(CreateModel body){
        return given().body(body).
                when().post(BASE_ENDPOINT + "users").
                then().extract().response();
    }

    public Response updateUserById(int id, UpdateModel body){
        return given().body(body).
                when().put(BASE_ENDPOINT + "users/" + id).
                then().extract().response();
    }

    public Response patchUserById(int id, UpdateModel body){
        return given().body(body).
                when().patch(BASE_ENDPOINT + "users/" + id).
                then().extract().response();
    }

    public Response deleteUserById(int id){
        return given().
                when().delete(BASE_ENDPOINT + "users/" + id).
                then().extract().response();
    }

    public Response register(RegisterModel registerData){
        return given().body(registerData).
                when().post(BASE_ENDPOINT + "register").
                then().extract().response();
    }

    public Response login(LoginModel loginData){
        return given().body(loginData).
                when().post(BASE_ENDPOINT + "login").
                then().extract().response();
    }

    public Response delayedResponse(int delay){
        return given().
                when().get(BASE_ENDPOINT + "users?delay=" + delay).
                then().extract().response();
    }
}
