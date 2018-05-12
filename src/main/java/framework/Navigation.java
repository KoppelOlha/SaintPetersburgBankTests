package framework;

import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

public class Navigation {

    public static LoginPage openLoginPage() {
        BrowserManager.browser.get("https://idemo.bspb.ru");
        return PageFactory.initElements(BrowserManager.browser, LoginPage.class);
    }
}
