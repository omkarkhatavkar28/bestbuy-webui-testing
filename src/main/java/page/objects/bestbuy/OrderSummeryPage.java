package page.objects.bestbuy;

import common.Util;
import lombok.extern.log4j.Log4j2;
import model.BillingAddress;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.bestbuy.common.BasePage;

@Log4j2
public class OrderSummeryPage extends BasePage {

    @FindBy(id = "user.emailAddress")
    public WebElement emailAddress;

    @FindBy(id = "user.phone")
    public WebElement phoneNumber;

    @FindBy(xpath = "//div[@class='button--continue']/button")
    WebElement continueToPaymentButton;


    public void fillTheContactDetails(BillingAddress billingAddress) {
        Util.waitForElementToBeDisplayed(continueToPaymentButton);
        this.emailAddress.clear();
        this.emailAddress.sendKeys(billingAddress.getEmail());
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(billingAddress.getPhoneNumber());
        this.continueToPaymentButton.click();
    }


}
