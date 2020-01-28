package page.objects.bestbuy;

import common.Util;
import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.bestbuy.common.BasePage;

@Log4j2
public class HomePage extends BasePage {
    @FindBy(id = "gh-search-input")
    private WebElement searchBox;

    @FindBy(className = "header-search-button")
    private WebElement searchButton;

    @FindBy(className = "logo")
    private WebElement bestBuyLogo;

    @FindBy(xpath = "//div[@id='suggestViewClientComponent']/div")
    private WebElement suggestionDropDown;

    public HomePage() {
        // hack added to close the model pop-ups are coming randomly
        try {
            DriverManager.getDriver().findElement(By.xpath("//button[@class='close']")).click();
        } catch (Exception e) {
            log.info("Handling the Model Popups, These are not displayed every time!");
        }
    }

    public void searchForProduct(String productName) {
        this.searchBox.clear();
        this.searchBox.sendKeys(productName);
        Util.moveToElementAndClick(searchBox);
        Util.waitForElementToBeDisplayed(suggestionDropDown);
        this.searchButton.click();
    }
}
