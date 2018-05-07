import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        Actions action = new Actions(browser);
        action.moveToElement(accountsMenu).build().perform();
        Utils.waitForElementVisible(statement);
        statement.click();
        return PageFactory.initElements(BrowserManager.browser, StatementPage.class);
    }

    public ExchangePage openExchangePage() {
        Actions action = new Actions(browser);
        action.moveToElement(currencyMenu).build().perform();
        Utils.waitForElementVisible(currencyExchange);
        currencyExchange.click();
        return PageFactory.initElements(BrowserManager.browser, ExchangePage.class);
    }

    public MessagesPage openEmailsPage() {
        email.click();
        return PageFactory.initElements(BrowserManager.browser, MessagesPage.class);
    }
}


