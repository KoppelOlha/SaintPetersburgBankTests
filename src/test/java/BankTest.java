import framework.BrowserManager;
import framework.CSVParser;
import framework.Navigation;
import framework.Utils;
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
        Utils.logInfo("The browser has been opened");
    }

    @Test
    public void enterAccount() {
        String userNameText = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .getUserNameText();
        Assert.assertTrue(userNameText.contains("Королёва Ольга"), "The name of the account's owner should be present");
        Utils.logInfo("Enter account SUCCESS");
    }

    @Test
    public void checkClosingBalance() {
        Float statementPage = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .openStatementPage()
                .getClosingBalance();
        Assert.assertTrue(statementPage > 0, "The closing balanse should be positive");
        Utils.logInfo("Closing balance is positive");
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
        Utils.logInfo("The exchange is successful");
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
        Utils.logInfo("The message has been received by the system");

    }


    @Test(dataProvider = "csv")
    public void messageSearch(String someMessage) {
        String sentMessageText1 = Navigation.openLoginPage()
                .loginPasswordEnter()
                .confirmSmsCode()
                .openEmailsPage()
                .openNewMessagePage()
                .fillMessageForm(someMessage)
                .getSentMessageText();
        Assert.assertTrue(sentMessageText1.contains(someMessage), "The sent message should be in the list of messages");
        Utils.logInfo("The messages is in the list");
    }


    @AfterTest
    public void closedBrowser() {
        BrowserManager.closedBrowser();
        Utils.logInfo("The browser has been closed");
    }
}
