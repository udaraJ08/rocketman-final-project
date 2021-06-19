package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.BookingHoldDTO;
import lk.bigzkoop.rocketman.dto.ValidityDateDTO;
import lk.bigzkoop.rocketman.service.superService.BookingHoldService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/bookingHold")
public class BookingHoldController {

    @Autowired
    private BookingHoldService bookingHoldService;


    @PostMapping("/all/vehicleDriverValid")
    public ResponseEntity<StandardDataFormat> getVehicleDriverByValidity(@RequestBody ValidityDateDTO dateDTO){

        return new ResponseEntity<>(
                new StandardDataFormat(
                        "success",
                        "all booked drivers and vehicles",
                        bookingHoldService.getValidityVehicleDriverAll(dateDTO)),
                HttpStatus.FOUND
        );
    }

    @PostMapping("/hold")
    public ResponseEntity<StandardDataFormat> holdBooking(@RequestBody BookingHoldDTO dto) {

        return new ResponseEntity<>(
                new StandardDataFormat(
                        "success",
                        "booking hold",
                        bookingHoldService.addBookingHold(dto)),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/status/all")
    public ResponseEntity<StandardDataFormat> getAllByStatus(@RequestParam String status) {

        return new ResponseEntity<>(
                new StandardDataFormat("success", "booking hold",
                        bookingHoldService.findAllByBookingStatus(status)),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<StandardDataFormat> deleteBooking(@RequestParam int id) {

        return new ResponseEntity<>(
                new StandardDataFormat("success", "booking hold",
                        bookingHoldService.deleteBookingHold(id)),
                HttpStatus.CREATED
        );
    }
}
