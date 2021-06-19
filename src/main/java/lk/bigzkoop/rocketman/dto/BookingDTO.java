package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {

    private String bookID;
    private String driver_NIC;
    private String customer_NIC;
    private String vehicleNumber;
    private String duration;
    private long startMileage;
    private long endMileage;
    private Date departureDate;
    private String time;
    private Date arrivalDate;
    private Date releaseDate;
    private boolean releaseStatus;
    private String bookingStatus;
    private String bookingType;
    private Date bookingDate;

    private PaymentDTO paymentDTO;
}
