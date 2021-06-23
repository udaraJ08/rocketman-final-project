package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.ValidateUserDTO;
import lk.bigzkoop.rocketman.service.superService.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("admin-user")
public class adminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping
    public boolean checkAdminValidity(@RequestBody ValidateUserDTO dto){

        return adminUserService.validateAdmin(dto);
    }
}
