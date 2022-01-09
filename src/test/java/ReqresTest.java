import endpoints.Endpoints;
import io.restassured.response.Response;
import models.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReqresTest {

    LoginModel validLoginData = new LoginModel(
            "eve.holt@reqres.in",
            "cityslicka"
    );

    LoginModel invalidLoginData = new LoginModel(
            "eve.holt@reqres.in"
    );

    RegisterModel validRegisterData = new RegisterModel(
            "eve.holt@reqres.in",
            "pistol"
    );

    RegisterModel invalidRegisterData = new RegisterModel(
            "eve.holt@reqres.in"
    );

    CreateModel createModel = new CreateModel(
            "morpheus",
            "leader"
    );

    UpdateModel updateModel = new UpdateModel(
            "morpheus",
            "zion resident"
    );
    int id = 1;


    @Test
    public void getUserByIdTest (){
        Response response = new Endpoints().getUserById(id);
        response.then().statusCode(200);
        Assert.assertEquals(response.as(User.class).getData().getId(), id);
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
        Response response = new Endpoints().getResourceById(id);
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
        Response response = new Endpoints().createUser(createModel);
        response.then().statusCode(201);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.as(CreateModel.class).getName(), createModel.getName());
        softAssert.assertEquals(response.as(CreateModel.class).getJob(), createModel.getJob());
        softAssert.assertAll();
    }

    @Test
    public void updateExistedUserTest(){
        Response response = new Endpoints().updateUserById(id, updateModel);
        response.then().statusCode(200);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.as(UpdateModel.class).getName(), updateModel.getName());
        softAssert.assertEquals(response.as(UpdateModel.class).getJob(), updateModel.getJob());
        softAssert.assertAll();
    }

    @Test
    public void patchExistedUserTest(){
        Response response = new Endpoints().patchUserById(id, updateModel);
        response.then().statusCode(200);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.as(UpdateModel.class).getName(), updateModel.getName());
        softAssert.assertEquals(response.as(UpdateModel.class).getJob(), updateModel.getJob());
        softAssert.assertAll();
    }

    @Test
    public void deleteExistedUserTest(){
        Response response = new Endpoints().deleteUserById(id);
        response.then().statusCode(204);
    }

    @Test
    public void successfulRegisterTest(){
        Response response = new Endpoints().register(validRegisterData);
        response.then().statusCode(200);
    }

    @Test
    public void unsuccessfulRegisterTest(){
        Response response = new Endpoints().register(invalidRegisterData);
        response.then().statusCode(400);
    }

    @Test
    public void successfulLoginTest(){
        Response response = new Endpoints().login(validLoginData);
        response.then().statusCode(200);
    }

    @Test
    public void unsuccessfulLoginTest() {
        Response response = new Endpoints().login(invalidLoginData);
        response.then().statusCode(400);
    }

    @Test
    public void delayedResponseTest(){
        Response response = new Endpoints().delayedResponse(3);
        response.then().statusCode(200);
    }
}
