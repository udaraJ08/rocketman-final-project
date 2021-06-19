package lk.bigzkoop.rocketman.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingHoldDTO {

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
}
