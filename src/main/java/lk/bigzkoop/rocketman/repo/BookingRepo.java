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

    @Query(
            "SELECT b from Booking b where b.bookingDate = ?1 and not" +
                    " b.bookingStatus = 'cancel'"
    )
    List<Booking> getAllTodayBookings(Date date);

    @Query("select b from Booking b where b.driver.driver_NIC  = ?1 " +
            "and b.bookingStatus = 'open'")
    List<Booking> getAllBookingByDriverNIC(String NIC);

    @Query("select count(b) from Booking b where" +
            " b.bookingStatus = 'arrived' and b.driver.driver_NIC = ?1")
    long getBookingCountByDriver(String nic);
}
