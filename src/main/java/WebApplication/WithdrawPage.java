package WebApplication;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class WithdrawPage extends GeneralPage {
//    Locators
//    Định nghĩa các biến chứa locators sử dụng trong tìm kiếm web elements trên trang
    private final By fieldAccountNo = By.name("accountno");
    private final By labelAccountNo = By.id("message2");
    private final By fieldAmount = By.name("ammount");
    private final By labelAmount = By.id("message1");
    private final By fieldDescription = By.name("desc");
    private final By labelDescription = By.id("message17");

//    Elements
//    Định nghĩa các phương thức gọi lệnh findElement để chọn các web element cần thiết
    private WebElement getFieldAccountNo(WebDriver driver) {
        return driver.findElement(fieldAccountNo);
    }
    private WebElement getFieldAmount(WebDriver driver) {
        return driver.findElement(fieldAmount);
    }
    private WebElement getFieldDescription(WebDriver driver) {
        return driver.findElement(fieldDescription);
    }
    private WebElement getLabelAccountNo(WebDriver driver) {
        return driver.findElement(labelAccountNo);
    }
    private WebElement getLabelAmount(WebDriver driver) {
        return driver.findElement(labelAmount);
    }
    private WebElement getLabelDescription(WebDriver driver) {
        return driver.findElement(labelDescription);
    }

//    Methods
//    Định nghĩa các phương thức cần sử dụng trong quá trình kiểm thử
    public String getAccountNoMessage(WebDriver driver, String accountNo) {
        WebElement textField = this.getFieldAccountNo(driver);

        new Actions(driver)
                .sendKeys(textField, accountNo)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelAccountNo(driver).getText();
    }
    public String getAmountMessage(WebDriver driver, String amount) {
        WebElement textField = this.getFieldAmount(driver);

        new Actions(driver)
                .sendKeys(textField, amount)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelAmount(driver).getText();
    }
    public String getDescriptionMessage(WebDriver driver, String description) {
        WebElement textField = this.getFieldDescription(driver);

        new Actions(driver)
                .sendKeys(textField, description)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelDescription(driver).getText();
    }
}