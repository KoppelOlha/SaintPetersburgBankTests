import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BrowserManager {

    @FindBy(id = "login-button")
    WebElement loginButton;

    public ConfirmCodePage loginPasswordEnter() {
        loginButton.click();
        return PageFactory.initElements(BrowserManager.browser, ConfirmCodePage.class);
    }
}
