import Framework.BrowserManager;
import Framework.CSVParser;
import Framework.Navigation;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

public class BankTest {

    @DataProvider(name = "csv")
    public Iterator<Object[]> searchFromCSVFile() {
        return CSVParser.loadMessageFromFile();
    }

    @BeforeTest
    public void browser() {
        BrowserManager.openBrowser();
    }

    @Test
    public void enterAccount() {
        String userNameText = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .getUserNameText();
        Assert.assertTrue(userNameText.contains("Королёва Ольга"), "The name of the account's owner should be present");
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
        String succesText = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .openExchangePage()
                .exchangeOrdering("150", "Exchange")
                .confirmExchange()
                .getSuccessText();
        Assert.assertTrue(succesText.contains("Перевод выполнен!"), "The exchange should be successful");
    }

    @Test
    public void checkSentMessagePresence() {
        String sentMessageText = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .openEmailsPage()
                .openNewMessagePage()
                .fillMessageForm("Can I ask you a question?")
                .getSentMessageText();
        Assert.assertTrue(sentMessageText.contains("Can I ask you a question?"), "The sent message should be in the list of messages");

    }


    @Test(dataProvider = "csv")
    public void messageSearch(String someMessage) throws InterruptedException {
        String sentMessageText1 = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .openEmailsPage()
                .openNewMessagePage()
                .fillMessageForm(someMessage)
                .getSentMessageText();
        Assert.assertTrue(sentMessageText1.contains(someMessage), "The sent message should be in the list of messages");
    }


    @AfterTest
    public void closedBrowser() {
        BrowserManager.closedBrowser();
    }
}
