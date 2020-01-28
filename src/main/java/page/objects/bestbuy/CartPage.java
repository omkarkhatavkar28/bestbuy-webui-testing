package page.objects.bestbuy;

import common.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.bestbuy.common.BasePage;

public class CartPage extends BasePage {

    @FindBy(xpath = "h1[text()='Your Cart']")
    WebElement cartPageHeader;

    @FindBy(className = "listing-header__button")
    WebElement topCheckoutButton;

    @FindBy(className = "cart-listing__items")
    WebElement cartListingItems;


    public void checkout() {
        Util.waitForElementToBeDisplayed(cartListingItems);
        this.topCheckoutButton.click();
    }
}
