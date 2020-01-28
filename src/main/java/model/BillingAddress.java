package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BillingAddress {
    String email;
    String phoneNumber;
    String firstName;
    String lastName;
    String address;
    String city;
    String zipCode;
    String state;
    String creditCardNumber;
    String month;
    String year;
    String securityCode;
}
