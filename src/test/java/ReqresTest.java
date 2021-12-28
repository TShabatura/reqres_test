import endpoints.Endpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ReqresTest {

    @Test
    public void getUserByIdTest (){
        Response response = new Endpoints().getUserById(2);
        response.then().statusCode(200);
    }

    @Test
    public void getListOfUsersTest(){
        Response response = new Endpoints().getListOfUsersByPage(2);
        response.then().statusCode(200);
    }

    @Test
    public void getInexistentUserTest(){
        Response response = new Endpoints().getUserById(100);
        response.then().statusCode(404);
    }

    @Test
    public void getResourceByIdTest(){
        Response response = new Endpoints().getResourceById(1);
        response.then().statusCode(200);
    }

    @Test
    public void getListOfResourcesTest(){
        Response response = new Endpoints().getListOfResourcesByPage(1);
        response.then().statusCode(200);
    }

    @Test
    public void getInexistentResourceTest(){
        Response response = new Endpoints().getResourceById(100);
        response.then().statusCode(404);
    }

    @Test
    public void createNewUserTest(){
        String body = """
                        {
                            "name": "morpheus",
                            "job": "leader"
                        }
                """;
        Response response = new Endpoints().createUser(body);
        response.then().statusCode(201);
    }

    @Test
    public void updateExistedUserTest(){
        int id = 1;
        String body = """
                        {
                            "name": "morpheus",
                            "job": "leader"
                        }
                """;
        Response response = new Endpoints().updateUserById(id, body);
        response.then().statusCode(200);
    }

    @Test
    public void patchExistedUserTest(){
        int id = 1;
        String body = """
                        {
                            "name": "morpheus",
                            "job": "leader"
                        }
                """;
        Response response = new Endpoints().patchUserById(id, body);
        response.then().statusCode(200);
    }

    @Test
    public void deleteExistedUserTest(){
        int id = 1;
        Response response = new Endpoints().deleteUserById(id);
        response.then().statusCode(204);
    }

    @Test
    public void successfulRegisterTest(){
        String body = """
                        {
                            "email": "eve.holt@reqres.in",
                            "name": "pistol"
                        }
                """;
        Response response = new Endpoints().register(body);
        response.then().statusCode(200);
    }

    @Test
    public void unsuccessfulRegisterTest(){
        String body = """
                        {
                            "email": "eve.holt@reqres.in"                       
                        }
                """;
        Response response = new Endpoints().register(body);
        response.then().statusCode(400);
    }

    @Test
    public void successfulLoginTest(){
        String body = """
                        {
                            "email": "eve.holt@reqres.in",
                            "password": "cityslicka"
                        }
                """;
        Response response = new Endpoints().login(body);
        response.then().statusCode(200);
    }

    @Test
    public void unsuccessfulLoginTest() {
        String body = """
                        {
                            "email": "eve.holt@reqres.in"
                        }
                """;
        Response response = new Endpoints().login(body);
        response.then().statusCode(400);
    }

    @Test
    public void delayedResponseTest(){
        Response response = new Endpoints().delayedResponse(3);
        response.then().statusCode(200);
    }
}
