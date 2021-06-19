package lk.bigzkoop.rocketman.controller;

import lk.bigzkoop.rocketman.dto.ValidityDateDTO;
import lk.bigzkoop.rocketman.service.superService.PaymentService;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/search/byDateRange")
    public ResponseEntity<StandardDataFormat> getPaymentListByDateRange(@RequestBody ValidityDateDTO dateDTO) {

        return new ResponseEntity<>(new StandardDataFormat(
                "Payments",
                "Payments by Date range",
                paymentService.getPaymentByDateRange(dateDTO)
        ), HttpStatus.FOUND);
    }

    @GetMapping("search/today")
    public ResponseEntity<StandardDataFormat> getTodayPayments() {

        return new ResponseEntity<>(new StandardDataFormat(
                "today payments",
                "today payments list",
                paymentService.getTodayPaymentData()
        ), HttpStatus.FOUND);
    }

    @GetMapping("count/holdPayment")
    public ResponseEntity<StandardDataFormat> getHoldPaymentCount() {

        return new ResponseEntity<>(new StandardDataFormat(
                "hold payments",
                "count of hold payments",
                paymentService.getHoldPaymentCount()
        ), HttpStatus.FOUND);
    }
}
