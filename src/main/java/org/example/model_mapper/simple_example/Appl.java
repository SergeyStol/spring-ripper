package org.example.model_mapper.simple_example;

import org.modelmapper.ModelMapper;

/**
 * @author Sergey Stol
 * 2021-12-15
 */
public class Appl {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        Order order = new Order(new Customer("customer1"),
                new Address("street1", "city1"),
                new Address("street11", "city11"));
        OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        System.out.println(orderDto);
    }
}
