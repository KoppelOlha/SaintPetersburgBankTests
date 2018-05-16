package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    public static WebDriver browser;

    public static void openBrowser() {
        DesiredCapabilities capabilities;
        String browserType = System.getProperty("browser");
        switch (browserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./target/classes/chromedriver.exe");
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("marionette", true);
                browser = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./target/classes/geckodriver.exe");
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                browser = new FirefoxDriver();
                break;
            case "InternetExplorer":
                System.setProperty("webdriver.ie.driver", "./target/classes/IEDriverServer.exe");
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability("marionette", true);
                browser = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Wrong browser");
        }
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static void closedBrowser() {
        browser.quit();
    }
}
