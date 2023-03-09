package ro.ubb.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Customer;
import ro.ubb.catalog.core.service.CustomerService;
import ro.ubb.catalog.web.converter.CustomerConverter;
import ro.ubb.catalog.web.dto.CustomerDto;
import ro.ubb.catalog.web.dto.CustomerDtos;

import java.util.List;
import java.util.Set;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerConverter customerConverter;

    @RequestMapping(value = "/customers")
    Set<CustomerDto> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        Set<CustomerDto> customerDtos = customerConverter.convertModelsToDtos(allCustomers);
        //CustomerDtos dtos =  new CustomerDtos(customerDtos);
       // return dtos;
        return customerDtos;
    }

    @PostMapping(value = "/customers")
    CustomerDto saveCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = customerConverter.convertDtoToModel(customerDto);
        Customer savedCustomer = customerService.saveCustomer(customer);
        return customerConverter.convertModelToDto(savedCustomer);
    }

    @PutMapping(value = "/customers/{id}")
    CustomerDto updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        return customerConverter.convertModelToDto(
                customerService.updateCustomer(id,
                        customerConverter.convertDtoToModel(customerDto))
        );
    }

    @DeleteMapping(value = "/customers/{id}")
    ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
