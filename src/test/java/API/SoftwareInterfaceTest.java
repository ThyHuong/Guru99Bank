package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftwareInterfaceTest {
    protected String baseURL = "https://demo.guru99.com/V4";
    int expectedStatusCode = 200;
    protected String validCustomerID = "68195";
    protected String invalidCustomerID = "681";
    protected String validPassword = "1234!";
    protected String invalidPassword = "123";
    protected String validAccountNo = "1";
    protected String invalidAccount = "145";
    @Test
    public void API_TC_06() {
        System.out.println("API_TC_06 - Nhập tất cả thông tin hợp lệ khi sử dụng Mini Statement API");
        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given()
                .params("CUSTOMER_ID", validCustomerID,
                        "PASSWORD", validPassword,
                        "Account_No", validAccountNo);
        Response response = request.get("/sinkministatement.php");
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String json = response.asString()
                .replaceAll("&quot;", "\"")
                .replaceAll(":\":","\":");
        JsonPath jsonPath = new JsonPath(json).setRootPath("message");
        String actualErrorMsg = jsonPath.get("ErrorMsg");
        String expectedErrorMsg = "Success";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
}
