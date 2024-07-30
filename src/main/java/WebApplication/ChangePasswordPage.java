package WebApplication;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ChangePasswordPage extends GeneralPage {
//    Locators
//    Định nghĩa các biến chứa locators sử dụng trong tìm kiếm web elements trên trang
    private final By fieldOldPassword = By.name("oldpassword");
    private final By labelOldPassword = By.id("message20");
    private final By fieldNewPassword = By.name("newpassword");
    private final By labelNewPassword = By.id("message21");
    private final By fieldConfirmPassword = By.name("confirmpassword");
    private final By labelConfirmPassword = By.id("message22");

//    Elements
//    Định nghĩa các phương thức gọi lệnh findElement để chọn các web element cần thiết
    private WebElement getFieldOldPassword(WebDriver driver) {
        return driver.findElement(fieldOldPassword);
    }
    private WebElement getFieldNewPassword(WebDriver driver) {
        return driver.findElement(fieldNewPassword);
    }
    private WebElement getFieldConfirmPassword(WebDriver driver) {
        return driver.findElement(fieldConfirmPassword);
    }
    private WebElement getLabelOldPassword(WebDriver driver) {
        return driver.findElement(labelOldPassword);
    }
    private WebElement getLabelNewPassword(WebDriver driver) {
        return driver.findElement(labelNewPassword);
    }
    private WebElement getLabelConfirmPassword(WebDriver driver) {
        return driver.findElement(labelConfirmPassword);
    }

//    Methods
//    Định nghĩa các phương thức cần sử dụng trong quá trình kiểm thử
    public String getOldPasswordMessage(WebDriver driver, String oldPassword) {
        WebElement textField = this.getFieldOldPassword(driver);

        new Actions(driver)
                .sendKeys(textField, oldPassword)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelOldPassword(driver).getText();
    }
    public String getNewPasswordMessage(WebDriver driver, String newPassword) {
        WebElement textField = this.getFieldNewPassword(driver);

        new Actions(driver)
                .sendKeys(textField, newPassword)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelNewPassword(driver).getText();
    }
    public String getConfirmPasswordMessage(WebDriver driver, String newPassword, String confirmPassword) {
        WebElement textField = this.getFieldNewPassword(driver);

        new Actions(driver)
                .sendKeys(textField, newPassword)
                .sendKeys(Keys.TAB)
                .sendKeys(confirmPassword)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelConfirmPassword(driver).getText();
    }
}
