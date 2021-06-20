package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.BookingHold;
import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface BookingHoldRepo extends JpaRepository<BookingHold, Integer> {

    List<BookingHold> findAllByBookingStatus(String status);

    @Query("select b.vehicle from Booking b where " +
            "((b.departureDate <= ?1 and ?2 <=b.releaseDate) or " +
            "(b.departureDate >= ?1 and ?2 >=b.releaseDate))" +
            "and (b.releaseStatus = false )")
    List<Vehicle> getVehicleListByDate(Date startDate, Date releaseDate);


    @Query("select b.driver from Booking b where " +
            "((b.departureDate <= ?1 and ?2 <=b.releaseDate) or " +
            "(b.departureDate >= ?1 and ?2 >=b.releaseDate))" +
            "group by b.driver")
    List<Driver> getDriverListByDate(Date startDate, Date releaseDate);

}
