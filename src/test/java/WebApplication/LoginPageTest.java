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

    @BeforeMethod
    public void beforeMethod() {
        edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();
        edgeDriver.navigate().to(baseURL);
        loginPage = new LoginPage();
    }

    @AfterTest
    public void afterMethod() {
        edgeDriver.quit();
    }

    @Test
    public void LI_TC_01() {
        System.out.println("LI_TC_01 - ...");
    }
}
