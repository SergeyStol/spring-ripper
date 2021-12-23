package org.example.model_mapper.property_map;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 * @author Sergey Stol
 * 2021-12-16
 */
public class Appl {
    public static void main(String[] args) {
        Person person = new Person(new Address("street1", "city1"));
        ModelMapper mapper = getModelMapper();
        PersonDto personDto = mapper.map(person, PersonDto.class);
        System.out.println(personDto);
    }

    private static ModelMapper getModelMapper() {
        PropertyMap<Person, PersonDto> personPersonDto =
                new PropertyMap<>() {
                    @Override
                    protected void configure() {
                        map().setCity(source.getAddress().getCity());
                        map(source.getAddress().getStreet(), destination.street);
                    }
                };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(personPersonDto);
        return mapper;
    }
}
