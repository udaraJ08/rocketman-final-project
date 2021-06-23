package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.UserSignupDTO;
import lk.bigzkoop.rocketman.dto.ValidateUserDTO;
import lk.bigzkoop.rocketman.service.superService.AdminUserService;
import lk.bigzkoop.rocketman.service.superService.DriverUserService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("driver-user")
public class DriverUserController {

    @Autowired
    private DriverUserService driverUserService;

    @PostMapping
    public ResponseEntity<StandardDataFormat> validateDriver(@RequestBody ValidateUserDTO dto) {

        return new ResponseEntity<>(new StandardDataFormat(
                "validate",
                "authorized driver",
                driverUserService.validateDriver(dto)
        ), HttpStatus.FOUND);
    }

    @PostMapping("/signup")
    public ResponseEntity<StandardDataFormat> addDriverUser(@RequestBody UserSignupDTO dto) {

        return new ResponseEntity<>(new StandardDataFormat(
                "signup",
                "new Driver signed up",
                driverUserService.signupDriver(dto)
        ), HttpStatus.FOUND);
    }
}
