package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.Booking;
import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.entity.Vehicle;
import lk.bigzkoop.rocketman.entity.queryEntity.BookingAndCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, String> {

    @Query("SELECT new " +
            "lk.bigzkoop.rocketman.entity.queryEntity.BookingAndCustomer (b.customer, b)" +
            " from Booking b JOIN b.customer " +
            "where b.customer.customer_NIC = ?1")
    List<BookingAndCustomer> getAllBookingAndCustomer(String NIC);

    List<Booking> findAllByBookingStatus(String status);
}
