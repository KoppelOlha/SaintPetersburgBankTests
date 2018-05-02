import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage {

    @FindBy(name = "message.text")
    WebElement messageForm;

    @FindBy(id = "send-button")
    WebElement sendButton;

    public MessagesPage fillMessageForm() {
        messageForm.sendKeys("Can I ask you a question?");
        sendButton.click();
        return PageFactory.initElements(BrowserManager.browser, MessagesPage.class);
    }
}
