package WebApplication;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FundTransferPageTest {
    protected WebDriver edgeDriver;
    protected FundTransferPage fundTransferPage;
    protected String baseURL = "https://demo.guru99.com/V4/";
    protected String validUserID = "mngr582955";
    protected String validPassword = "tehYzyp";

    @BeforeClass
    public void beforeFundTransferTestcases() {
        System.out.println("CHỨC NĂNG 'FUND TRANSFER':");
        System.out.println("Tiền điều kiện:");
        System.out.println(" - Đã đăng nhập thành công\n - Giao diện Fund Transfer đang hiển thị\n");
    }
    @AfterClass
    public void afterClass() {
        System.out.println();
    }

    @BeforeMethod
    public void beforeMethod() {
        edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();
        edgeDriver.navigate().to(baseURL);
        LoginPage loginPage = new LoginPage();
        GeneralPage generalPage = loginPage.successLogin(edgeDriver, validUserID, validPassword);
        fundTransferPage = generalPage.gotoFundTransfer(edgeDriver);
    }

    @AfterMethod
    public void afterMethod() {
        edgeDriver.quit();
    }

    @Test
    public void FT_TC_01() {
        System.out.println("FT_TC_01 - Không nhập Payers Account Number");
        String expectedMessage = "Payers Account Number must not be blank";
        String actualMessage = fundTransferPage.getPayersNoMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_02() {
        System.out.println("FT_TC_02 - Nhập Payers Account Number chứa ký tự đặc biệt");
        String expectedMessage = "Special characters are not allowed";
        String payersNo = "1245!@#";
        String actualMessage = fundTransferPage.getPayersNoMessage(edgeDriver, payersNo);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_03() {
        System.out.println("FT_TC_03 - Nhập Payers Account Number chứa ký tự chữ");
        String expectedMessage = "Characters are not allowed";
        String payersNo = "1345Abc";
        String actualMessage = fundTransferPage.getPayersNoMessage(edgeDriver, payersNo);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_04() {
        System.out.println("FT_TC_04 - Nhập Payers Account Number hợp lệ");
        String expectedMessage = "";
        String payersNo = "136236";
        String actualMessage = fundTransferPage.getPayersNoMessage(edgeDriver, payersNo);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_05() {
        System.out.println("FT_TC_05 - Không nhập Payees Account Number");
        String expectedMessage = "Payees Account Number must not be blank";
        String actualMessage = fundTransferPage.getPayeesNoMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_06() {
        System.out.println("FT_TC_06 - Nhập Payees Account Number chứa ký tự đặc biệt");
        String expectedMessage = "Special characters are not allowed";
        String payeesNo = "1245!@#";
        String actualMessage = fundTransferPage.getPayeesNoMessage(edgeDriver, payeesNo);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_07() {
        System.out.println("FT_TC_07 - Nhập Payees Account Number chứa ký tự chữ");
        String expectedMessage = "Characters are not allowed";
        String payeesNo = "1345Abc";
        String actualMessage = fundTransferPage.getPayeesNoMessage(edgeDriver, payeesNo);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_08() {
        System.out.println("FT_TC_08 - Nhập Payees Account Number hợp lệ");
        String expectedMessage = "";
        String payeesNo = "136236";
        String actualMessage = fundTransferPage.getPayeesNoMessage(edgeDriver, payeesNo);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_09() {
        System.out.println("FT_TC_09 - Không nhập Amount");
        String expectedMessage = "Amount field must not be blank";
        String actualMessage = fundTransferPage.getAmountMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_10() {
        System.out.println("FT_TC_10 - Nhập Amount chứa ký tự đặc biệt");
        String expectedMessage = "Special characters are not allowed";
        String amount = "200%$";
        String actualMessage = fundTransferPage.getAmountMessage(edgeDriver, amount);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_11() {
        System.out.println("FT_TC_11 - Nhập Amount chứa ký tự chữ");
        String expectedMessage = "Characters are not allowed";
        String amount = "200abc";
        String actualMessage = fundTransferPage.getAmountMessage(edgeDriver, amount);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_12() {
        System.out.println("FT_TC_12 - Nhập Amount hợp lệ");
        String expectedMessage = "";
        String amount = "200";
        String actualMessage = fundTransferPage.getAmountMessage(edgeDriver, amount);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_13() {
        System.out.println("FT_TC_13 - Không nhập Description");
        String expectedMessage = "Description can not be blank";
        String actualMessage = fundTransferPage.getDescriptionMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void FT_TC_14() {
        System.out.println("FT_TC_14 - Nhập Description hợp lệ");
        String expectedMessage = "";
        String description = "fund transfer description";
        String actualMessage = fundTransferPage.getDescriptionMessage(edgeDriver, description);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
}
