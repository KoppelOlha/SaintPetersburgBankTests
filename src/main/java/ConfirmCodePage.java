import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmCodePage extends BrowserManager {

    @FindBy(id = "login-otp-button")
    WebElement confirmButton;

    public AccountPage confirmSmsCode() {
        confirmButton.click();
        return PageFactory.initElements(BrowserManager.browser, AccountPage.class);
    }
}
