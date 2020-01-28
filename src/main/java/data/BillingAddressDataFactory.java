package data;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import model.BillingAddress;
import java.util.Random;

@Log4j2
public class BillingAddressDataFactory {

    private final Faker faker;

    public BillingAddressDataFactory() {
        faker = new Faker();
    }

    public BillingAddress createData() {
        BillingAddress billingAddress = BillingAddress.builder().
                email(faker.internet().emailAddress()).
                city(faker.address().city()).
                phoneNumber(returnRandomPhoneNumber()).
                firstName(faker.name().firstName()).
                lastName(faker.name().lastName()).
                address(faker.address().fullAddress()).
                zipCode(faker.address().zipCode()).
                state(faker.address().stateAbbr()).
                creditCardNumber(returnCreditCardNumber()).
                month(returnRandomMonth()).
                year(returnRandomYear()).
                securityCode(returnRandomCvv()).
                build();

        log.info(billingAddress);
        ExtentTestManager.getTest().info(billingAddress.toString());
        return billingAddress;
    }

    private String returnRandomMonth() {
        return returnRandomItemOnArray(new String[]{
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"
        });
    }

    private String returnCreditCardNumber() {
        return returnRandomItemOnArray(new String[]{
                "4111111111111111",
        });
    }

    private String returnRandomYear() {
        return returnRandomItemOnArray(new String[]{
                "2021", "2022", "2023", "2024",
        });
    }

    private String returnRandomPhoneNumber() {
        return returnRandomItemOnArray(new String[]{
                "202-555-0190", "202-555-0115", "202-555-0143", "202-555-0167", "202-555-0159"
        });
    }

    private String returnRandomCvv() {
        Random random = new Random();
        return String.valueOf(random.nextInt(900) + 100);
    }


    private String returnRandomItemOnArray(String[] array) {
        return array[(new Random().nextInt(array.length))];
    }
}
