package page.objects.bestbuy;

import common.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.bestbuy.common.BasePage;

public class AddToCartConfirmationPage extends BasePage {

    @FindBy(className = "pager-carousel")
    WebElement pageCarousel;

    @FindBy(className = "cart-nav-text")
    WebElement goToCart;

    @FindBy(className = "close-modal-text")
    WebElement continueShopping;

    public void navigateToOrderSummeryPage() {
        Util.waitForJSandJQueryToLoad();
        Util.waitForElementToBeDisplayed(goToCart);
        this.goToCart.click();
    }

}
