package Framework;

import Pages.LoginPage;
import org.openqa.selenium.support.PageFactory;

public class Navigation {

    public static LoginPage openLoginPage() {
        BrowserManager.browser.get("https://idemo.bspb.ru");
        return PageFactory.initElements(BrowserManager.browser, LoginPage.class);
    }
}
