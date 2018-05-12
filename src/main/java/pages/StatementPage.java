package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatementPage {

    @FindBy(xpath = ".//*[@id='closing-balance-row']/th[2]")
    WebElement balance;

    public Float getClosingBalance() {
        String text = balance.getText();
        String numbersWithoutSpaces = text.replaceAll(" ", "");
        return Float.parseFloat(numbersWithoutSpaces);
    }
}
