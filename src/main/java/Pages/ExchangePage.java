package Pages;

import Framework.BrowserManager;
import Framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        new WebDriverWait(BrowserManager.browser, 3).until(ExpectedConditions.visibilityOf(sellCurrencyAccount)).click();
        inputSum.sendKeys(textSum);
        Utils.clickWithJS(buyToAccount);
        new WebDriverWait(BrowserManager.browser, 3).until(ExpectedConditions.visibilityOf(buyCurrencyAccount)).click();
        inputDetails.sendKeys(someText);
        Utils.clickWithJS(calculateButton);
        return PageFactory.initElements(BrowserManager.browser, ExchangePreviewPage.class);
    }
}
