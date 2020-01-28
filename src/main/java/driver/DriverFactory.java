package driver;

import config.Configuration;
import driver.local.LocalDriverManager;
import driver.remote.RemoteDriverManager;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DriverFactory {
    public static WebDriver startInstance(String browser) {
        Configuration configuration = ConfigCache.getOrCreate(Configuration.class);
        Target target = Target.valueOf(configuration.target().toUpperCase());
        WebDriver webdriver;
        switch (target) {
            case LOCAL:
                webdriver = new LocalDriverManager().startInstance(browser);
                break;
            case GRID:
                webdriver = new RemoteDriverManager().startInstance(browser);
                break;
            default:
                throw new IllegalStateException("Unexpected Browser Name: " + target);
        }

        return webdriver;
    }

    enum Target {
        LOCAL, GRID
    }
}
