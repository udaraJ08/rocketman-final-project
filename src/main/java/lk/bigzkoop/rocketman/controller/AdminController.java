package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.VehicleDataDTO;
import lk.bigzkoop.rocketman.service.superService.AdminService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
}
