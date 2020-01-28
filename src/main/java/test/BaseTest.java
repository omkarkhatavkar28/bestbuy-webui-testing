package test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import config.Configuration;
import driver.DriverFactory;
import driver.DriverManager;
import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({ExtentITestListenerClassAdapter.class, TestListener.class})
public abstract class BaseTest {

    @BeforeSuite
    @Parameters("environment")
    public void setConfiguration(@Optional("dev") String environment) {
        ConfigFactory.setProperty("env", environment);
    }

    @BeforeMethod
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        ConfigFactory.setProperty("env_browser", browser);
        Configuration configuration = ConfigCache.getOrCreate(Configuration.class);

        WebDriver driver = DriverFactory.startInstance(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().get(configuration.url());
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void postCondition() {
        DriverManager.quit();
    }
}
