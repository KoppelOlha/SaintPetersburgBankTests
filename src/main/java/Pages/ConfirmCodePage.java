package Pages;

import Framework.BrowserManager;
import Framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmCodePage extends BrowserManager {

    @FindBy(id = "login-otp-button")
    WebElement confirmButton;

    public AccountPage confirmSmsCode() {
        Utils.clickWithJS(confirmButton);
        return PageFactory.initElements(BrowserManager.browser, AccountPage.class);
    }
}
