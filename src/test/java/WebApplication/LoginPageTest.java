package WebApplication;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest {
    protected WebDriver edgeDriver;
    protected LoginPage loginPage;
    protected String baseURL = "https://demo.guru99.com/V4/";
    protected String validUserID = "mngr582955";
    protected String validPassword = "tehYzyp";

    @BeforeClass
    public void beforeLoginTestcases() {
        System.out.println("CHỨC NĂNG 'LOGIN':");
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
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        edgeDriver.quit();
    }

    @Test
    public void LI_TC_01() {
        System.out.println("LI_TC_01 - Không nhập User ID");
        String expectedMessage = "User-ID must not be blank";
        String actualMessage = loginPage.getUserIDMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo hiển thị không như mong đợi");
    }
    @Test
    public void LI_TC_02() {
        System.out.println("LI_TC_02 - Nhập User ID hợp lệ");
        String expectedMessage = "";
        String actualMessage = loginPage.getUserIDMessage(edgeDriver, validUserID);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo hiển thị không như mong đợi");
    }
    @Test
    public void LI_TC_03() {
        System.out.println("LI_TC_03 - Không nhập Password");
        String expectedMessage = "Password must not be blank";
        String actualMessage = loginPage.getPasswordMessage(edgeDriver, "");
        Assert.assertEquals(actualMessage,expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
    @Test
    public void LI_TC_04() {
        System.out.println("LI_TC_04 - Nhập Password hợp lệ");
        String expectedMessage = "";
        String actualMessage = loginPage.getPasswordMessage(edgeDriver, validPassword);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi hiển thị không như mong đợi");
    }
}
