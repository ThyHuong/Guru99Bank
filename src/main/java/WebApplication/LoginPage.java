package WebApplication;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
//    Locators
//    Định nghĩa các biến chứa locators sử dụng trong tìm kiếm web elements trên trang
    private final By fieldUserID = By.name("uid");
    private final By labelUserID = By.id("message23");
    private final By fieldPassword = By.name("password");
    private final By labelPassword = By.id("message18");

//    Elements
//    Định nghĩa các phương thức gọi lệnh findElement để chọn các web element cần thiết
    private WebElement getFieldUserID(WebDriver driver) {
        return driver.findElement(fieldUserID);
    }
    private WebElement getFieldPassword(WebDriver driver) {
        return driver.findElement(fieldPassword);
    }
    private WebElement getLabelUserID(WebDriver driver) {
        return driver.findElement(labelUserID);
    }
    private WebElement getLabelPassword(WebDriver driver) {
        return driver.findElement(labelPassword);
    }

//    Methods
//    Định nghĩa các phương thức cần sử dụng trong quá trình kiểm thử
    public GeneralPage successLogin(WebDriver driver, String userID, String password) {
        WebElement textField = this.getFieldUserID(driver);

        new Actions(driver)
                .sendKeys(textField, userID)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        return new GeneralPage();
    }
    public String getUserIDMessage(WebDriver driver, String userID) {
        WebElement textField = this.getFieldUserID(driver);

        new Actions(driver)
                .sendKeys(textField, userID)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelUserID(driver).getText();
    }
    public String getPasswordMessage(WebDriver driver, String password) {
        WebElement textField = this.getFieldPassword(driver);

        new Actions(driver)
                .sendKeys(textField, password)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelPassword(driver).getText();
    }
}
