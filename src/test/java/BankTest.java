import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BankTest {

    @BeforeTest
    public void browser() {
        BrowserManager browserManager = new BrowserManager();
        browserManager.openBrowser();
    }

    @Test
    public void enterAccount() {
        String accountPage = Navigation.openLoginPage().loginPasswordEnter().confirmSmsCode().isNameAsExpected();
        Assert.assertTrue(accountPage.contains("Королёва Ольга"), "The name of the account's owner should be present");
    }

    @Test
    public void checkClosingBalance() {
        Float statementPage = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .openStatementPage()
                .getClosingBalance();
        Assert.assertTrue(statementPage > 0, "The closing balanse should be positive");
    }


    @Test
    public void exchangeTransaction() {
        String exchangeResult = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .openExchangePage()
                .exchangeOrdering()
                .confirmExchange()
                .isSuccessTextPresent();
        Assert.assertTrue(exchangeResult.contains("Перевод выполнен!"), "The exchange should be successful");
    }

    @Test
    public void checkSentMessagePresence() {
        String sentMessages = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .openEmailsPage()
                .openNewMessagePage()
                .fillMessageForm()
                .isSentMessagePresent();
        Assert.assertTrue(sentMessages.contains("Can I ask you a question?"), "The sent message should be in the list of messages");

    }

    @AfterTest
    public void closedBrowser() {
        BrowserManager.closedBrowser();
    }
}
