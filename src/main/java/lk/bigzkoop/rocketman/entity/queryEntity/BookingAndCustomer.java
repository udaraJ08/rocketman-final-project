package lk.bigzkoop.rocketman.entity.queryEntity;

import lk.bigzkoop.rocketman.entity.Booking;
import lk.bigzkoop.rocketman.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingAndCustomer {

    private Customer customer;
    private Booking booking;
}
