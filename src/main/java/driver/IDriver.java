package driver;

import org.openqa.selenium.WebDriver;

public interface IDriver {
    WebDriver startInstance(String browser);
}
