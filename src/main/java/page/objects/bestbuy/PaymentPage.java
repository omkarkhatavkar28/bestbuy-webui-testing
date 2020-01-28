package page.objects.bestbuy;

import common.Util;
import model.BillingAddress;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.bestbuy.common.BasePage;

// extending Shipping Page is failing for locators
public class PaymentPage extends BasePage {

    @FindBy(id = "payment.billingAddress.firstName")
    protected WebElement firstName;

    @FindBy(id = "payment.billingAddress.lastName")
    protected WebElement lastName;

    @FindBy(id = "payment.billingAddress.street")
    protected WebElement billingAddress;

    @FindBy(id = "payment.billingAddress.city")
    protected WebElement city;

    @FindBy(id = "payment.billingAddress.state")
    protected WebElement state;

    @FindBy(id = "payment.billingAddress.zipcode")
    protected WebElement zipCode;

    @FindBy(id = "optimized-cc-card-number")
    public WebElement cardNumber;

    @FindBy(name = "expiration-month")
    public WebElement expirationDate;

    @FindBy(name = "expiration-year")
    public WebElement expirationYear;

    @FindBy(id = "credit-card-cvv")
    public WebElement securityCode;

    @FindBy(xpath = "//button[contains(@data-track, 'Place your Order')]")
    WebElement placeYourOrder;

    @FindBy(className = "checkout__container")
    WebElement checkoutContainer;

    @FindBy(className = "saved-addresses__select-heading")
    WebElement savedAddress;

    @FindBy(xpath = "//span[text()='Keep Address as Entered']")
    WebElement KeepAddressAsEnteredButton;

    @FindBy(className = "error-box")
    WebElement errorBoxLocator;

    public void fillAddressDetails(BillingAddress billingAddress) {
        Util.waitForElementToBeDisplayed(cardNumber);
        this.firstName.clear();
        this.firstName.sendKeys(billingAddress.getFirstName());
        this.lastName.clear();
        this.lastName.sendKeys(billingAddress.getLastName());
        this.billingAddress.clear();
        this.billingAddress.sendKeys(billingAddress.getAddress());
        this.city.clear();
        this.city.sendKeys(billingAddress.getCity());
        Util.moveToElementAndClick(this.city);
        Util.moveToElementAndClick(this.zipCode);
        this.zipCode.clear();
        this.zipCode.sendKeys(billingAddress.getZipCode());
        Util.selectFromDropDown(this.state, billingAddress.getState());

    }

    public PaymentPage fillThePaymentDetails(BillingAddress billingAddress) {
        this.cardNumber.sendKeys(billingAddress.getCreditCardNumber());
        Util.selectFromDropDown(this.expirationDate, billingAddress.getMonth());
        Util.selectFromDropDown(this.expirationYear, billingAddress.getYear());
        this.securityCode.clear();
        this.securityCode.sendKeys(billingAddress.getSecurityCode());
        return this;
    }

    public void placeTheOrder() {
        this.placeYourOrder.click();
    }

    public String getErrorMessage() {
        Util.waitForElementToBeDisplayed(KeepAddressAsEnteredButton);
        this.KeepAddressAsEnteredButton.click();
        Util.waitForElementToBeDisplayed(errorBoxLocator);
        return errorBoxLocator.getText();
    }

}
