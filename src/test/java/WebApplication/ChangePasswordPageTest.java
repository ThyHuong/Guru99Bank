package WebApplication;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChangePasswordPageTest {
    protected WebDriver edgeDriver;
    protected ChangePasswordPage changePasswordPage;
    protected String baseURL = "https://demo.guru99.com/V4/";
    protected String validUserID = "mngr582955";
    protected String validPassword = "tehYzyp";

    @BeforeClass
    public void beforeChangePasswordTestcases() {
        System.out.println("CHỨC NĂNG 'CHANGE PASSWORD':");
        System.out.println("Tiền điều kiện:");
        System.out.println(" - Đã đăng nhập thành công\n - Giao diện Change Password đang hiển thị\n");
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
        changePasswordPage = generalPage.gotoChangePassword(edgeDriver);
    }

    @AfterMethod
    public void afterMethod() {
        edgeDriver.quit();
    }

    @Test
    public void CP_TC_01() {
        System.out.println("CP_TC_01 - Không nhập Old Password");
        String expectedMessage = "Old Password must not be blank";
        String actualMessage = changePasswordPage.getOldPasswordMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void CP_TC_02() {
        System.out.println("CP_TC_02 - Nhập Old Password hợp lệ");
        String expectedMessage = "";
        String actualMessage = changePasswordPage.getOldPasswordMessage(edgeDriver, validPassword);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void CP_TC_03() {
        System.out.println("CP_TC_03 - Không nhập New Password");
        String expectedMessage = "New Password must not be blank";
        String actualMessage = changePasswordPage.getNewPasswordMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void CP_TC_04() {
        System.out.println("CP_TC_04 - Nhập New Password không chứa ký tự số");
        String expectedMessage = "Enter at-least one numeric value";
        String newPassword = "abcd!@#$";
        String actualMessage = changePasswordPage.getNewPasswordMessage(edgeDriver, newPassword);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void CP_TC_05() {
        System.out.println("CP_TC_05 - Nhập New Password không chứa ký tự đặc biệt");
        String expectedMessage = "Enter at-least one special character";
        String newPassword = "abcd1234";
        String actualMessage = changePasswordPage.getNewPasswordMessage(edgeDriver, newPassword);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void CP_TC_06() {
        System.out.println("CP_TC_06 - Nhập New Password hợp lệ");
        String expectedMessage = "";
        String newPassword = "1234!@#$";
        String actualMessage = changePasswordPage.getNewPasswordMessage(edgeDriver, newPassword);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void CP_TC_07() {
        System.out.println("CP_TC_07 - Không nhập Confirm Password");
        String expectedMessage = "Confirm Password must not be blank";
        String actualMessage = changePasswordPage.getConfirmPasswordMessage(edgeDriver, "", "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void CP_TC_08() {
        System.out.println("CP_TC_08 - Nhập Confirm Password không trùng với New Password");
        String expectedMessage = "Passwords do not Match";
        String newPassword = "1234!@#$";
        String confirmPassword = "1234";
        String actualMessage = changePasswordPage.getConfirmPasswordMessage(edgeDriver, newPassword, confirmPassword);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void CP_TC_09() {
        System.out.println("CP_TC_09 - Nhập Confirm Password hợp lệ");
        String expectedMessage = "";
        String newPassword = "1234!@#$";
        String actualMessage = changePasswordPage.getConfirmPasswordMessage(edgeDriver, newPassword, newPassword);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
}
