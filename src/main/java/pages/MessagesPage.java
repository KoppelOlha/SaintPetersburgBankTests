package pages;

import framework.BrowserManager;
import framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagesPage {

    @FindBy(id = "new-message-btn")
    WebElement newMessageButton;

    @FindBy(id = "messages")
    WebElement listOfMessages;

    public NewMessagePage openNewMessagePage() {
        Utils.clickWithJS(newMessageButton);
        return PageFactory.initElements(BrowserManager.browser, NewMessagePage.class);
    }

    public String getSentMessageText() {
        return listOfMessages.getText();
    }
}
