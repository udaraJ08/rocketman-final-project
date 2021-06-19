package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.BookingHoldDTO;
import lk.bigzkoop.rocketman.dto.ValidityDateDTO;
import lk.bigzkoop.rocketman.dto.ValidityDriverVehicleDTO;
import lk.bigzkoop.rocketman.entity.BookingHold;

import java.util.List;

public interface BookingHoldService {


    boolean addBookingHold(BookingHoldDTO dto);

    List<BookingHold> findAllByBookingStatus(String status);

    boolean deleteBookingHold(int id);

    ValidityDriverVehicleDTO getValidityVehicleDriverAll(ValidityDateDTO dataDTO);
}
