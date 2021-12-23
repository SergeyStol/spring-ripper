package org.example.model_mapper.simple_example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sergey Stol
 * 2021-12-15
 */
@Data
public class OrderDto {
    String customerName;
    String shippingStreetAddress;
    String shippingCity;
    String billingStreetAddress;
    String billingCity;
}
