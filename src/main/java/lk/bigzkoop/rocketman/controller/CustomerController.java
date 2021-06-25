package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.CustomerDTO;
import lk.bigzkoop.rocketman.service.superService.CustomerService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

    //////////////////////Customer adding with image uploading///////////////
    @PostMapping(value = "/add/data-img", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE})

    public ResponseEntity<StandardDataFormat> addingCustomerImage(@RequestBody List<MultipartFile> file) {
        return new ResponseEntity<>(
                new StandardDataFormat(
                        "New Customer Added with images",
                        "success",
                        file),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/nic-img")
    public ResponseEntity<StandardDataFormat> saveNIC(@RequestPart("file") MultipartFile myFile) {

        System.out.println();

        try {
            String projectPath = "E:\\IJSE Projects\\Second Semester\\projects\\Final Project\\rocketman\\src\\main\\java\\lk\\bigzkoop\\rocketman\\assets\\nic";
            File uploadsDir = new File(projectPath);
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            return new ResponseEntity(new StandardDataFormat(
                    "200", "Done",
                    uploadsDir.getPath())
                    , HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(new StandardDataFormat("500", "error", false), HttpStatus.OK);
        }
    }

    @PostMapping("/lic-img")
    public ResponseEntity<StandardDataFormat> saveLIC(@RequestPart("file") MultipartFile myFile) {

        try {
            String projectPath = "E:\\IJSE Projects\\Second Semester\\projects\\Final Project\\rocketman\\src\\main\\java\\lk\\bigzkoop\\rocketman\\assets\\lic";
            File uploadsDir = new File(projectPath);
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            return new ResponseEntity(new StandardDataFormat(
                    "200", "Done",
                    uploadsDir.getPath())
                    , HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(new StandardDataFormat("500", "error", false), HttpStatus.OK);
        }
    }
}
