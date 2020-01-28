package data;

import com.aventstack.extentreports.service.ExtentTestManager;
import lombok.extern.log4j.Log4j2;
import model.Product;

import java.util.Collections;
import java.util.Random;

@Log4j2
public class ProductDataFactory {

    public Product createProductData() {
        String[] productInfo = returnRandomProduct().split("/");
        Product productDetails = Product.builder().
                productSearchName(productInfo[0]).
                productFilters(Collections.singletonMap(productInfo[1], productInfo[2])).
                productModelID(productInfo[3]).build();

        log.info(productDetails);
        ExtentTestManager.getTest().info(productDetails.toString());
        return productDetails;
    }

    private String returnRandomProduct() {
        return returnRandomItemOnArray(new String[]{
                "Watch/Brand/Fossil/FTW4019",
        });
    }

    private String returnRandomItemOnArray(String[] array) {
        return array[(new Random().nextInt(array.length))];
    }

}
