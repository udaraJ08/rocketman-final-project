package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.BookingDTO;
import lk.bigzkoop.rocketman.dto.BookingDataDTO;
import lk.bigzkoop.rocketman.dto.PaymentDTO;
import lk.bigzkoop.rocketman.entity.Booking;
import lk.bigzkoop.rocketman.entity.queryEntity.BookingAndCustomer;

import java.util.List;

public interface BookingService {


    Booking openStatus(BookingDataDTO dataDTO);

    boolean departureStatus(BookingDataDTO dto);

    PaymentDTO arrivedStatus(BookingDataDTO dataDTO);

    boolean cancelStatus(BookingDataDTO dataDTO);

    boolean releaseStatus(BookingDataDTO dataDto);

    List<BookingAndCustomer> getAllBooking(String nic);

    List<Booking> getAllBookingByStatus(String status);

    List<Booking> getAllBooking();
}
