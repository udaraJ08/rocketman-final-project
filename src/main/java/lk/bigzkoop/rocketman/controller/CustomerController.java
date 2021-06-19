package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.CustomerDTO;
import lk.bigzkoop.rocketman.service.superService.CustomerService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<StandardDataFormat> getBase(@RequestBody CustomerDTO dto) {

        return new ResponseEntity<>(
                new StandardDataFormat(
                        "New Customer Added",
                        "success",
                        customerService.addCustomer(dto)),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<StandardDataFormat> getAllCustomer() {

        return new ResponseEntity<>(
                new StandardDataFormat(
                        "Customers",
                        "all customers",
                        customerService.getAllCustomer()),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/search")
    public ResponseEntity<StandardDataFormat> getAllCustomerBySearch(@RequestParam String key) {

        return new ResponseEntity<>(
                new StandardDataFormat(
                        "Customer",
                        "customer list",
                        customerService.searchCustomer(key)
                ), HttpStatus.FOUND
        );
    }

    @GetMapping("/count")
    public ResponseEntity<StandardDataFormat> getCustomerCount() {

        return new ResponseEntity<>(new StandardDataFormat(
                "Customer",
                "customer count",
                customerService.getCustomerCount()
        ), HttpStatus.FOUND);
    }

}
