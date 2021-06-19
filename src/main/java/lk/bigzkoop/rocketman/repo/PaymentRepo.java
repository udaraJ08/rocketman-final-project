package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.Booking;
import lk.bigzkoop.rocketman.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

    Payment findByBookingID(Booking bookingID);

    int deleteByBookingID(Booking bookingID);

    @Query(
            "SELECT p from Payment p where " +
                    "p.paymentDate between ?1 and ?2"
    )
    List<Payment> getPaymentListByDateRange(Date startDate, Date endDate);

    @Query(
            "SELECT p from Payment p where " +
                    "p.paymentDate = ?1"
    )
    List<Payment> getTodaypaymentList(Date today);

    @Query("SELECT count(p) from Payment p " +
            "where p.fullPayment = 0")
    long getHoldPaymentCount();
}
