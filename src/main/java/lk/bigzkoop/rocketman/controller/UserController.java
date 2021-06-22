package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.CustomerValidateDTO;
import lk.bigzkoop.rocketman.dto.UserCustomerDTO;
import lk.bigzkoop.rocketman.service.superService.UserService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user-customer")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public boolean signupCustomer(@RequestBody UserCustomerDTO dto){

        return userService.addUser(dto);
    }

    @PostMapping("/check")
    public ResponseEntity<StandardDataFormat> checkValidity(@RequestBody CustomerValidateDTO dto){

        return new ResponseEntity<>(new StandardDataFormat(
           "validity",
           "valid customer",
           userService.validateUser(dto)
        ), HttpStatus.FOUND);
    }
}
