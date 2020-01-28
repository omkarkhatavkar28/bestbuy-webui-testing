package page.objects.bestbuy;

import common.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.bestbuy.common.BasePage;

public class SignInPage extends BasePage {

    @FindBy(xpath = "input[@type='email']")
    WebElement email;

    @FindBy(xpath = "input[@type='password']")
    WebElement password;

    @FindBy(xpath = "//a[contains(@class,'guest-button')]")
    WebElement continueAsGuestButton;

    public void clickOnContinueAsGuestButton() {
        Util.waitForElementToBeDisplayed(continueAsGuestButton);
        try {
            continueAsGuestButton.click();
        } catch (Exception e) {
            Util.moveToElementAndClick(continueAsGuestButton);
        }
    }

}
