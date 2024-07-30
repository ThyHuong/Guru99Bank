package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

public class SoftwareInterfaceTest {
    protected String baseURL = "https://demo.guru99.com/V4";
    protected int expectedStatusCode = 200;
    protected String validCustomerID = "68195";
    protected String invalidCustomerID = "681";
    protected String validPassword = "1234!";
    protected String invalidPassword = "123";
    protected String validAccountNo = "1";
    protected String invalidAccount = "145";

    private Response getResponse(String URL, String customerID, String password, String accountNo) {
        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given()
                .params("CUSTOMER_ID", customerID,
                        "PASSWORD", password,
                        "Account_No", accountNo);
        return request.get(URL);
    }
    private String formatJSON(String jsonString) {
        return jsonString.replaceAll("&quot;", "\"").replaceAll(":\":","\":");
    }
    private String getErrorMessage(Response response) {
        String json = formatJSON(response.asString());
        JsonPath jsonPath = new JsonPath(json).setRootPath("message");
        return jsonPath.get("ErrorMsg");
    }
    @BeforeClass
    public void beforeAPITestcases() {
        System.out.println("SOFTWARE INTERFACE:\n");
    }
    @AfterClass
    public void afterClass() {
        System.out.println();
    }
    @Test
    public void API_TC_01() {
        System.out.println("API_TC_01 - Không nhập Account No khi sử dụng Mini Statement API");
        Response response = getResponse("/sinkministatement.php", validCustomerID, validPassword, "");
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "NoData";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_02() {
        System.out.println("API_TC_02 - Nhập Account No không tồn tại trong hệ thống khi sử dụng Mini Statement API");
        Response response = getResponse("/sinkministatement.php", validCustomerID, validPassword, invalidAccount);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "NoData";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_03() {
        System.out.println("API_TC_03 - Nhập Customer ID không tồn tại trong hệ thống khi sử dụng Mini Statement API");
        Response response = getResponse("/sinkministatement.php", invalidCustomerID, validPassword, validAccountNo);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "Login Credentials Incorrect";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_04() {
        System.out.println("API_TC_04 - Không nhập Password khi sử dụng Mini Statement API");
        Response response = getResponse("/sinkministatement.php", validCustomerID, "", validAccountNo);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "Login Credentials Incorrect";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_05() {
        System.out.println("API_TC_05 - Nhập sai Password khi sử dụng Mini Statement API");
        Response response = getResponse("/sinkministatement.php", validCustomerID, invalidPassword, validAccountNo);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "Login Credentials Incorrect";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_06() {
        System.out.println("API_TC_06 - Nhập tất cả thông tin hợp lệ khi sử dụng Mini Statement API");
        Response response = getResponse("/sinkministatement.php", validCustomerID, validPassword, validAccountNo);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "Success";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_07() {
        System.out.println("API_TC_07 - Không nhập Account No khi sử dụng Balance Enquiry API");
        Response response = getResponse("/sinkbalanceenquiry.php", validCustomerID, validPassword, "");
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "Success";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_08() {
        System.out.println("API_TC_08 - Nhập Account No không tồn tại trong hệ thống khi sử dụng Balance Enquiry API");
        Response response = getResponse("/sinkbalanceenquiry.php", validCustomerID, validPassword, invalidAccount);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "NoData";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_09() {
        System.out.println("API_TC_09 - Nhập Account No hợp lệ khi sử dụng Balance Enquiry API");
        Response response = getResponse("/sinkbalanceenquiry.php", validCustomerID, validPassword, validAccountNo);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "Success";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_10() {
        System.out.println("API_TC_10 - Nhập Customer ID không tồn tại trong hệ thống khi sử dụng Balance Enquiry API");
        Response response = getResponse("/sinkbalanceenquiry.php", invalidCustomerID, validPassword, validAccountNo);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "Login Credentials Incorrect";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_11() {
        System.out.println("API_TC_11 - Không nhập Password khi sử dụng Balance Enquiry API");
        Response response = getResponse("/sinkbalanceenquiry.php", validCustomerID, "", validAccountNo);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "Login Credentials Incorrect";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void API_TC_12() {
        System.out.println("API_TC_12 - Nhập sai Password khi sử dụng Balance Enquiry API");
        Response response = getResponse("/sinkbalanceenquiry.php", validCustomerID, invalidPassword, validAccountNo);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Không thể thực hiện API");
        String actualErrorMsg = getErrorMessage(response);
        String expectedErrorMsg = "Login Credentials Incorrect";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Thông báo lỗi hiển thị không như mong đợi");
    }
}
