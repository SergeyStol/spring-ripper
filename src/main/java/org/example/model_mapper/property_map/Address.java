package org.example.model_mapper.property_map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sergey Stol
 * 2021-12-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    String street;
    String city;
}
