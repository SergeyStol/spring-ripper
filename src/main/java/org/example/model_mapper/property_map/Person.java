package org.example.model_mapper.property_map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sergey Stol
 * 2021-12-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    Address address;
}
