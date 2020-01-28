package page.objects.bestbuy;

import common.Util;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.bestbuy.common.BasePage;

import java.sql.Driver;
import java.util.List;
import java.util.Map;

public class ResultPage extends BasePage {

    @FindBy(id = "gh-search-input")
    private WebElement searchBox;

    @FindBy(id = "sort-by-select")
    private WebElement sortBySelect;

    @FindBy(xpath = "//div[contains(@class,'facets-column')]")
    private WebElement filterColumn;

    @FindBy(xpath = "//ul[@class='facet-list']")
    private WebElement facetList;

    @FindBy(className = "item-count")
    private WebElement itemCount;

    String itemCountLocator = "//span[@class='item-count']";
    String productListLocator = ".//li[@class='sku-item']";
    String productNameLocator = ".//h4[@class='sku-header']";
    String modelNameLocator = ".//div[@class='sku-model']";
    String addToCartButtonLocator = ".//button[text()='Add to Cart']";


    public ResultPage applyFilters(Map<String, String> filterNames) {
        for (Map.Entry<String, String> entry : filterNames.entrySet()) {
            String sectionLocator = String.format(".//fieldset[@name='%s']", entry.getKey());
            WebElement sectionsName = filterColumn.findElement(By.xpath(sectionLocator));
            String filterLocator = String.format(".//span[contains(text(),'%s')" +
                    " and @class='facet-option-label-text']", entry.getValue());
            WebElement filterName = sectionsName.findElement(By.xpath(filterLocator));
            filterName.click();
            Util.waitForElementTextInvisible(itemCountLocator, itemCount.getText());
        }
        return this;
    }

    protected void searchProductAndClickOnAddToCart(String identifier, String identifierValue) {
        List<WebElement> searchResults = DriverManager.getDriver().findElements(By.xpath(productListLocator));
        for (WebElement searchResult : searchResults) {
            String identifierElement = searchResult.findElement(By.xpath(identifier)).getText();
            if (identifierElement.contains(identifierValue)) {
                WebElement add_to_Cart_Button = searchResult.findElement(By.xpath(addToCartButtonLocator));
                add_to_Cart_Button.click();
                break;
            }
        }
    }

    public void addToCartTheProductHavingTitle(String productName) {
        searchProductAndClickOnAddToCart(productNameLocator, productName);
    }

    public void addToCartTheProductHavingModelName(String modelName) {
        searchProductAndClickOnAddToCart(modelNameLocator, modelName);
    }

}
