package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.DriverDTO;
import lk.bigzkoop.rocketman.service.superService.DriverService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public ResponseEntity<StandardDataFormat> getAllDrivers() {

        return new ResponseEntity<>(
                new StandardDataFormat("fetch",
                        "all driver details",
                        driverService.getAllDrivers()
                ),
                HttpStatus.FOUND
        );
    }

    @PostMapping("/add")
    public ResponseEntity<StandardDataFormat> addDriver(@RequestBody DriverDTO dto) {

        return new ResponseEntity<>(
                new StandardDataFormat("created",
                        "driver added",
                        driverService.addDriver(dto))
                , HttpStatus.CREATED
        );
    }
    @GetMapping("/count")
    public long getDriverCount() {
        return driverService.getDriverCount();
    }

    @PostMapping("/search")
    public ResponseEntity<StandardDataFormat> getDriversBySearch(@RequestParam String key) {

        return new ResponseEntity<>(new StandardDataFormat(
                "drivers",
                "search drivers",
                driverService.getDriversBySearch(key)
        ), HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<StandardDataFormat> updateDriver(@RequestBody DriverDTO driverDTO){

        return new ResponseEntity<>(new StandardDataFormat(
                "drivers",
                "update drivers",
                driverService.updateDriver(driverDTO)
        ), HttpStatus.FOUND);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<StandardDataFormat> removeDriver(@RequestParam String driverNIC){

        return new ResponseEntity<>(new StandardDataFormat(
                "driver",
                "driver deleted",
                driverService.removeDriver(driverNIC)
        ), HttpStatus.FOUND);
    }
}
