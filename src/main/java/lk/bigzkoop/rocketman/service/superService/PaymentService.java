package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.ValidityDateDTO;
import lk.bigzkoop.rocketman.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getPaymentByDateRange(ValidityDateDTO dateDTO);

    List<Payment> getTodayPaymentData();

    double getPaymentAmount(ValidityDateDTO dateDTO);

    double getHoldPaymentAmount(ValidityDateDTO dateDTO);

    long getHoldPaymentCount();

}
