package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.BookingDataDTO;
import lk.bigzkoop.rocketman.dto.VehicleDataDTO;
import lk.bigzkoop.rocketman.service.superService.BookingService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<StandardDataFormat> getAllData(){

        return new ResponseEntity<>(new StandardDataFormat(
                "booking list", "success", bookingService.getAllBooking()),
                HttpStatus.ACCEPTED
        );
    }

    @PostMapping("/open")
    public ResponseEntity<StandardDataFormat> openBooking(@RequestBody BookingDataDTO dataDTO) {

        return new ResponseEntity<>(
                new StandardDataFormat("opened  ", "success", bookingService.openStatus(dataDTO)),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/departure")
    public ResponseEntity<StandardDataFormat> departureBooking(@RequestBody BookingDataDTO dataDTO) {

        return new ResponseEntity<>(
                new StandardDataFormat("departured", "success", bookingService.departureStatus(dataDTO)),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/arrived")
    public ResponseEntity<StandardDataFormat> arrivedBooking(@RequestBody BookingDataDTO dataDTO) {

        return new ResponseEntity<>(
                new StandardDataFormat("arrived", "success", bookingService.arrivedStatus(dataDTO)),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<StandardDataFormat> deleteBooking(@RequestBody BookingDataDTO dataDTO) {

        return new ResponseEntity<>(
                new StandardDataFormat("canceled", "success", bookingService.cancelStatus(dataDTO)),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/release")
    public ResponseEntity<StandardDataFormat> releaseBooking(@RequestBody BookingDataDTO dataDTO) {

        return new ResponseEntity<>(
                new StandardDataFormat("released", "success", bookingService.releaseStatus(dataDTO)),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<StandardDataFormat> getBooking(@RequestParam String nic) {

        return new ResponseEntity<>(
                new StandardDataFormat("booking details by customer", "success",
                        bookingService.getAllBooking(nic)),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getAll/today")
    public ResponseEntity<StandardDataFormat> getTodayBookings(){

        return new ResponseEntity<>(
                new StandardDataFormat(
                        "Bookings",
                        "Today Booking",
                        bookingService.getAllTodayBooking()
                ),HttpStatus.FOUND
        );
    }
}
