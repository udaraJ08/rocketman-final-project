package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.ValidityDateDTO;
import lk.bigzkoop.rocketman.entity.Payment;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.repo.PaymentRepo;
import lk.bigzkoop.rocketman.service.superService.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Payment> getPaymentByDateRange(ValidityDateDTO dateDTO) {

        if (null == dateDTO.getEndDate() || null == dateDTO.getStartDate())
            throw new ValidationException("must give start and end date");

        return paymentRepo.getPaymentListByDateRange(dateDTO.getStartDate(), dateDTO.getEndDate());
    }

    @Override
    public List<Payment> getTodayPaymentData() {

        Date today = Date.valueOf(LocalDate.now());
        return paymentRepo.getTodaypaymentList(today);
    }

    @Override
    public double getPaymentAmount(ValidityDateDTO dateDTO) {
        return 0;
    }

    @Override
    public double getHoldPaymentAmount(ValidityDateDTO dateDTO) {
        return 0;
    }

    @Override
    public long getHoldPaymentCount() {

        return paymentRepo.getHoldPaymentCount();
    }
}
