package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Customer;
import ro.ubb.catalog.web.dto.CustomerDto;
@Component
public class CustomerConverter extends BaseConverter<Customer, CustomerDto> {

    @Override
    public Customer convertDtoToModel(CustomerDto dto) {
        Customer customer = Customer.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .yearOfBirth(dto.getYearOfBirth())
                .gender(dto.getGender())
                .build();
        customer.setId(dto.getId());
        return customer;
    }

    @Override
    public CustomerDto convertModelToDto(Customer customer) {
        CustomerDto customerDto = CustomerDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .yearOfBirth(customer.getYearOfBirth())
                .gender(customer.getGender())
                .build();
        customerDto.setId(customer.getId());
        return customerDto;

    }
}
