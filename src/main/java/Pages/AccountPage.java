package Pages;

import Framework.BrowserManager;
import Framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BrowserManager {

    @FindBy(xpath = "//button")
    WebElement userName;

    @FindBy(id = "accounts")
    WebElement accountsMenu;

    @FindBy(id = "statement")
    WebElement statement;

    @FindBy(id = "currency")
    WebElement currencyMenu;

    @FindBy(id = "currencyExchange")
    WebElement currencyExchange;

    @FindBy(className = "icon-email")
    WebElement email;

    public String getUserNameText() {
        return userName.getText();
    }

    public StatementPage openStatementPage() {
        Utils.navigateToDropDownList(accountsMenu);
        Utils.waitForElementVisible(statement);
        statement.click();
        return PageFactory.initElements(BrowserManager.browser, StatementPage.class);
    }

    public ExchangePage openExchangePage() {
        Utils.navigateToDropDownList(currencyMenu);
        Utils.waitForElementVisible(currencyExchange);
        currencyExchange.click();
        return PageFactory.initElements(BrowserManager.browser, ExchangePage.class);
    }

    public MessagesPage openEmailsPage() {
        Utils.clickWithJS(email);
        return PageFactory.initElements(BrowserManager.browser, MessagesPage.class);
    }
}


