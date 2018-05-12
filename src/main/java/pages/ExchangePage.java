package pages;

import framework.BrowserManager;
import framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExchangePage extends BrowserManager {

    @FindBy(id = "acc1")
    WebElement sellFromAccount;

    @FindBy(xpath = ".//*[@id='acc1']/option[@value='10013']")
    WebElement sellCurrencyAccount;

    @FindBy(id = "from-amount")
    WebElement inputSum;

    @FindBy(id = "acc2")
    WebElement buyToAccount;

    @FindBy(xpath = ".//*[@id='acc2']/option[@value='10002']")
    WebElement buyCurrencyAccount;

    @FindBy(name = "payment.details")
    WebElement inputDetails;

    @FindBy(id = "forward")
    WebElement calculateButton;

    public ExchangePreviewPage exchangeOrdering(String textSum, String someText) {
        Utils.clickWithJS(sellFromAccount);
        Utils.waitForElementVisible(sellCurrencyAccount);
        inputSum.sendKeys(textSum);
        Utils.clickWithJS(buyToAccount);
        Utils.waitForElementVisible(buyCurrencyAccount);
        inputDetails.sendKeys(someText);
        Utils.clickWithJS(calculateButton);
        return PageFactory.initElements(BrowserManager.browser, ExchangePreviewPage.class);
    }
}
