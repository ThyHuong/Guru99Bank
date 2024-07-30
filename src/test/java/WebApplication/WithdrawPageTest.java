package WebApplication;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WithdrawPageTest {
    protected WebDriver edgeDriver;
    protected WithdrawPage withdrawPage;
    protected String baseURL = "https://demo.guru99.com/V4/";
    protected String validUserID = "mngr582955";
    protected String validPassword = "tehYzyp";

    @BeforeClass
    public void beforeWithdrawTestcases() {
        System.out.println("CHỨC NĂNG 'WITHDRAW':");
        System.out.println("Tiền điều kiện:");
        System.out.println(" - Đã đăng nhập thành công role Manager\n - Giao diện Withdraw đang hiển thị\n");
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
        withdrawPage = generalPage.gotoWithdraw(edgeDriver);
    }

    @AfterMethod
    public void afterMethod() {
        edgeDriver.quit();
    }

    @Test
    public void WD_TC_01() {
        System.out.println("WD_TC_01 - Không nhập Account No");
        String expectedMessage = "Account No must not be blank";
        String actualMessage = withdrawPage.getAccountNoMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi.");
    }
    @Test
    public void WD_TC_02() {
        System.out.println("WD_TC_02 - Nhập Account No chứa ký tự đặc biệt");
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = withdrawPage.getAccountNoMessage(edgeDriver, "1245!@#");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void WD_TC_03() {
        System.out.println("WD_TC_03 - Nhập Account No chứa ký tự chữ");
        String expectedMessage = "Characters are not allowed";
        String actualMessage = withdrawPage.getAccountNoMessage(edgeDriver, "1345Abc");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void WD_TC_04() {
        System.out.println("WD_TC_04 - Nhập Account No hợp lệ");
        String expectedMessage = "";
        String actualMessage = withdrawPage.getAccountNoMessage(edgeDriver, "136235");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void WD_TC_05() {
        System.out.println("WD_TC_05 - Không nhập Amount");
        String expectedMessage = "Amount field must not be blank";
        String actualMessage = withdrawPage.getAmountMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void WD_TC_06() {
        System.out.println("WD_TC_06 - Nhập Amount chứa ký tự đặc biệt");
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = withdrawPage.getAmountMessage(edgeDriver, "200%$");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void WD_TC_07() {
        System.out.println("WD_TC_07 - Nhập Amount chứa ký tự chữ");
        String expectedMessage = "Characters are not allowed";
        String actualMessage = withdrawPage.getAmountMessage(edgeDriver, "200abc");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void WD_TC_08() {
        System.out.println("WD_TC_08 - Nhập Amount hợp lệ");
        String expectedMessage = "";
        String actualMessage = withdrawPage.getAmountMessage(edgeDriver, "200");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void WD_TC_09() {
        System.out.println("WD_TC_09 - Không nhập Description");
        String expectedMessage = "Description can not be blank";
        String actualMessage = withdrawPage.getDescriptionMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void WD_TC_10() {
        System.out.println("WD_TC_10 - Nhập Description hợp lệ");
        String expectedMessage = "";
        String actualMessage = withdrawPage.getDescriptionMessage(edgeDriver, "withdrew");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
}
