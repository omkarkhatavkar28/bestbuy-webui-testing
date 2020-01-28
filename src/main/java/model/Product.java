package model;

import lombok.*;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    String productSearchName;
    Map<String, String> productFilters;
    String productModelID;
}
