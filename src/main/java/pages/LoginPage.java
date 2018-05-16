package pages;

import framework.BrowserManager;
import framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BrowserManager {

    @FindBy(id = "login-button")
    WebElement loginButton;

    public ConfirmCodePage loginPasswordEnter() {
        Utils.logInfo("Entered login and password");
        Utils.clickWithJS(loginButton);
        return PageFactory.initElements(BrowserManager.browser, ConfirmCodePage.class);
    }
}
