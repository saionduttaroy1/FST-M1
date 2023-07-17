package RESTAssured_Project;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTAssuredProject {
    private RequestSpecification requestSpec;
    private String sshKeyId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        requestSpec = new RequestSpecBuilder()
                .setContentType("application/json")
                .addHeader("Authorization", "token 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")
                .build();
    }

    @Test
    public void testAddSSHKey() {
        String requestBody = """
                {
                    "title": "TestAPIKey",
                    "key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIATonUM0VH+JeSyJnvDEOTYBraEY9RVNTRTmT4gBB4v2"
                }""";

        Response response = RestAssured.given()
                .spec(requestSpec)
                .body(requestBody)
                .post("/user/keys");

        Assert.assertEquals(response.getStatusCode(), 201);

        sshKeyId = response.jsonPath().getString("id");
        Assert.assertNotNull(sshKeyId);
    }

    @Test(dependsOnMethods = "testAddSSHKey")
    public void testGetSSHKey() {
        Response response = RestAssured.given()
                .spec(requestSpec)
                .pathParam("keyId", sshKeyId)
                .get("/user/keys/{keyId}");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody); // or use Reporter.log(responseBody);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(dependsOnMethods = "testGetSSHKey")
    public void testDeleteSSHKey() {
        Response response = RestAssured.given()
                .spec(requestSpec)
                .pathParam("keyId", sshKeyId)
                .delete("/user/keys/{keyId}");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody); // or use Reporter.log(responseBody);

        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
