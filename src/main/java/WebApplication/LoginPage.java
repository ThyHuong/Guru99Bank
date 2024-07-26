package WebApplication;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
//    Locators
//    Định nghĩa các biến chứa locators sử dụng trong tìm kiếm web elements trên trang
    private final By fieldUserID = By.name("uid");

//    Elements
//    Định nghĩa các phương thức gọi lệnh findElement để chọn các web element cần thiết
    private WebElement getFieldUserID(WebDriver driver) {
        return driver.findElement(fieldUserID);
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
}
