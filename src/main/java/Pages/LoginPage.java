package Pages;

import Framework.BrowserManager;
import Framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BrowserManager {

    @FindBy(id = "login-button")
    WebElement loginButton;

    public ConfirmCodePage loginPasswordEnter() {
        Utils.clickWithJS(loginButton);
        return PageFactory.initElements(BrowserManager.browser, ConfirmCodePage.class);
    }
}
