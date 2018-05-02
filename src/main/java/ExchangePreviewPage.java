import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExchangePreviewPage {

    @FindBy(css = "[id~=confirm]")
    WebElement confirmButton;

    public ExchangeResult confirmExchange() {
        BrowserManager.browser.switchTo().frame("confirmation-frame");
        confirmButton.click();
        BrowserManager.browser.switchTo().defaultContent();
        return PageFactory.initElements(BrowserManager.browser, ExchangeResult.class);
    }
}
