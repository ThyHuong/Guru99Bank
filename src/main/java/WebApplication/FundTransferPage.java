package WebApplication;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class FundTransferPage extends GeneralPage {
//    Locators
//    Định nghĩa các biến chứa locators sử dụng trong tìm kiếm web elements trên trang
    private final By fieldPayersNo = By.name("payersaccount");
    private final By labelPayersNo = By.id("message10");
    private final By fieldPayeesNo = By.name("payeeaccount");
    private final By labelPayeesNo = By.id("message11");
    private final By fieldAmount = By.name("ammount");
    private final By labelAmount = By.id("message1");
    private final By fieldDescription = By.name("desc");
    private final By labelDescription = By.id("message17");

//    Elements
//    Định nghĩa các phương thức gọi lệnh findElement để chọn các web element cần thiết
    private WebElement getFieldPayersNo(WebDriver driver) {
        return driver.findElement(fieldPayersNo);
    }
    private WebElement getFieldPayeesNo(WebDriver driver) {
        return driver.findElement(fieldPayeesNo);
    }
    private WebElement getFieldAmount(WebDriver driver) {
        return driver.findElement(fieldAmount);
    }
    private WebElement getFieldDescription(WebDriver driver) {
        return driver.findElement(fieldDescription);
    }
    private WebElement getLabelPayersNo(WebDriver driver) {
        return driver.findElement(labelPayersNo);
    }
    private WebElement getLabelPayeesNo(WebDriver driver) {
        return driver.findElement(labelPayeesNo);
    }
    private WebElement getLabelAmount(WebDriver driver) {
        return driver.findElement(labelAmount);
    }
    private WebElement getLabelDescription(WebDriver driver) {
        return driver.findElement(labelDescription);
    }

//    Methods
//    Định nghĩa các phương thức cần sử dụng trong quá trình kiểm thử
    public String getPayersNoMessage(WebDriver driver, String payersNo) {
        WebElement textField = this.getFieldPayersNo(driver);

        new Actions(driver)
                .sendKeys(textField, payersNo)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelPayersNo(driver).getText();
    }
    public String getPayeesNoMessage(WebDriver driver, String payeesNo) {
        WebElement textField = this.getFieldPayeesNo(driver);

        new Actions(driver)
                .sendKeys(textField, payeesNo)
                .sendKeys(Keys.TAB)
                .perform();

        return this.getLabelPayeesNo(driver).getText();
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