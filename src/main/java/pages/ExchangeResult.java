package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExchangeResult {

    @FindBy(xpath = ".//*[@class='alert alert-success']")
    WebElement isNotificationPresent;

    public String getSuccessText() {
        return isNotificationPresent.getText();
    }
}
