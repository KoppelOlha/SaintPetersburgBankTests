import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExchangeResult {

    @FindBy(xpath = ".//*[@class='alert alert-success']")
    WebElement isNotificationPresent;

    public String isSuccessTextPresent() {
        return isNotificationPresent.getText();
    }

    public ExchangeResult exchangeResultInit() {
        return PageFactory.initElements(BrowserManager.browser, ExchangeResult.class);
    }
}
