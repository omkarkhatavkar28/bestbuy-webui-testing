package driver.local;

import driver.IDriver;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Log4j2
public class LocalDriverManager implements IDriver {

    @Override
    public WebDriver startInstance(String browser) {
        WebDriver driver = null;

        try {
            DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
            Class<?> driverClass = Class.forName(driverManagerType.browserClass());
            WebDriverManager.getInstance(driverManagerType).setup();
            // hack to run on my local linux machine in case throwing the DevTools Active Port Error
            if (browser.toUpperCase().equalsIgnoreCase("CHROME")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
            } else {
                driver = (WebDriver) driverClass.newInstance();
            }

        } catch (IllegalArgumentException | IllegalAccessException | ClassNotFoundException e) {
            log.error("The browser class could not be found", e);
        } catch (InstantiationException e) {
            log.error("Problem during driver instantiation", e);
        }
        return driver;
    }
}
