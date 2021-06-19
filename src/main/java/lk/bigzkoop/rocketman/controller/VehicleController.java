package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.VehicleDTO;
import lk.bigzkoop.rocketman.service.superService.VehicleService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<StandardDataFormat> addVehicle(@RequestBody VehicleDTO dto) {

        return new ResponseEntity<>(new StandardDataFormat(
                "created",
                "vehicle added",
                vehicleService.addVehicle(dto)

        ), HttpStatus.CREATED);
    }

    @GetMapping("/count")
    public ResponseEntity<StandardDataFormat> getCountByType(@RequestParam String id) {

        return new ResponseEntity<>(new StandardDataFormat(
                "fetch",
                "vehicle count",
                vehicleService.getVehicleCountByType(id)
        ), HttpStatus.FOUND
        );
    }

    @GetMapping("/count/all")
    public ResponseEntity<StandardDataFormat> getCountByType() {

        return new ResponseEntity<>(new StandardDataFormat(
                "fetch",
                "vehicle count",
                vehicleService.getAllCount()
        ), HttpStatus.FOUND
        );
    }

    @GetMapping
    public ResponseEntity<StandardDataFormat> getVehicleAll(@RequestParam String status){

        return new ResponseEntity<>(new StandardDataFormat(
                "fetch",
                "all vehicles",
                vehicleService.getAllVehicle(status)
        ), HttpStatus.FOUND);
    }

    @GetMapping("/searchAll")
    public ResponseEntity<StandardDataFormat> getVehicleBySearch(@RequestParam String key){

        return new ResponseEntity<>(new StandardDataFormat(
                "search",
                "all vehicles by key",
                vehicleService.getAllVehicleBySearch(key)
        ), HttpStatus.FOUND);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<StandardDataFormat> removeVehicle(@RequestParam String vehicleNumber){

        return new ResponseEntity<>(new StandardDataFormat(
                "delete",
                "vehicle deleted",
                vehicleService.deleteVehicleByID(vehicleNumber)
        ), HttpStatus.ACCEPTED);
    }
}
