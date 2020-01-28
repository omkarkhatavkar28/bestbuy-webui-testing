package page.objects;

import config.Configuration;
import driver.DriverManager;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AbstractPageObject {

    protected AbstractPageObject() {
        Configuration configuration = ConfigCache.getOrCreate(Configuration.class);
        int timeout = Integer.parseInt(configuration.timeout());

        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), timeout), this);
    }
}
