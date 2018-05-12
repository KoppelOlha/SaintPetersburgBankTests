package pages;

import framework.BrowserManager;
import framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage {

    @FindBy(name = "message.text")
    WebElement messageForm;

    @FindBy(id = "send-button")
    WebElement sendButton;

    public MessagesPage fillMessageForm(String someMessage) {
        messageForm.sendKeys(someMessage);
        Utils.clickWithJS(sendButton);
        return PageFactory.initElements(BrowserManager.browser, MessagesPage.class);
    }
}
