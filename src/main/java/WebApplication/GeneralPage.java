package WebApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class GeneralPage {
//    Locators
//    Định nghĩa các biến chứa locators sử dụng trong tìm kiếm web elements trên trang
    private final By tabWithdraw = By.xpath("//a[text()='Withdrawal']");
    private final By tabChangePassword = By.xpath("//a[text()='Change Password']");
    private final By tabFundTransfer = By.xpath("//a[text()='Fund Transfer']");

//    Elements
//    Định nghĩa các phương thức gọi lệnh findElement để chọn các web element cần thiết
    protected WebElement getTabWithdraw(WebDriver driver) {
        return driver.findElement(tabWithdraw);
    }
    protected WebElement getTabChangePassword(WebDriver driver) {
        return driver.findElement(tabChangePassword);
    }
    protected WebElement getTabFundTransfer(WebDriver driver) {
        return driver.findElement(tabFundTransfer);
    }

//    Methods
//    Định nghĩa các phương thức cần sử dụng trong quá trình kiểm thử
    public WithdrawPage gotoWithdraw(WebDriver driver) {
        WebElement element = this.getTabWithdraw(driver);
        new Actions(driver)
                .moveToElement(element)
                .click()
                .perform();
        this.adsRemove(driver);
        return new WithdrawPage();
    }

    public ChangePasswordPage gotoChangePassword(WebDriver driver) {
        WebElement element = this.getTabChangePassword(driver);
        new Actions(driver)
                .moveToElement(element)
                .click()
                .perform();
        this.adsRemove(driver);
        return new ChangePasswordPage();
    }

    public FundTransferPage gotoFundTransfer(WebDriver driver) {
        WebElement element = this.getTabFundTransfer(driver);
        new Actions(driver)
                .moveToElement(element)
                .click()
                .perform();
        this.adsRemove(driver);
        return new FundTransferPage();
    }

    protected void adsRemove(WebDriver driver) {
        if (driver.getCurrentUrl().contains("#google_vignette")) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
            driver.switchTo().frame(frame1);
            try {
                driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
            } catch (NoSuchElementException e) {
                WebElement frame2 = driver.findElement(By.id("ad_iframe"));
                driver.switchTo().frame(frame2);
                driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
            }
            driver.switchTo().defaultContent();
        }
    }
}
