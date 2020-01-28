package test;

import data.BillingAddressDataFactory;
import data.ProductDataFactory;
import model.BillingAddress;
import model.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.bestbuy.*;

public class ProductPurchaseTest  extends BaseTest{


    @Test(description = "Error message should be raised while purchasing product with Invalid Address")
    public void testPurchaseTheProductWithInvalidAddress() throws InterruptedException {
        BillingAddress billingAddressInfo = new BillingAddressDataFactory().createData();
        Product productDetails = new ProductDataFactory().createProductData();

        HomePage homePage = new HomePage();
        homePage.searchForProduct(productDetails.getProductSearchName());

        ResultPage resultPage = new ResultPage();
        resultPage.applyFilters(productDetails.getProductFilters());
        resultPage.addToCartTheProductHavingModelName(productDetails.getProductModelID());

        AddToCartConfirmationPage addToCartConfirmationPage = new  AddToCartConfirmationPage();
        addToCartConfirmationPage.navigateToOrderSummeryPage();
        CartPage cartPage = new CartPage();
        cartPage.checkout();
        SignInPage signInPage = new SignInPage();
        signInPage.clickOnContinueAsGuestButton();

        OrderSummeryPage orderSummeryPage = new OrderSummeryPage();
        orderSummeryPage.fillTheContactDetails(billingAddressInfo);

        PaymentPage paymentPage = new PaymentPage();
        paymentPage.fillAddressDetails(billingAddressInfo);
        paymentPage.fillThePaymentDetails(billingAddressInfo).placeTheOrder();

        String actualErrorMessage = paymentPage.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains("that's not a valid credit card number. " +
                "Please double-check it and try again."));
    }

}
