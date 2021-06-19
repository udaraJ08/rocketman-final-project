package lk.bigzkoop.rocketman.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingHold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "driver_NIC", name = "driver_NIC")
    private Driver driver;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "customer_NIC", name = "customer_NIC")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "vehicleNumber", name="vehicleNumber")
    private Vehicle vehicle;

    @NotNull
    private String duration;
    @NotNull
    private long startMileage;
    @NotNull
    private long endMileage;
    @NotNull
    private Date departureDate;
    @NotNull
    private String time;
    @NotNull
    private Date arrivalDate;
    @NotNull
    private Date releaseDate;
    @NotNull
    private boolean releaseStatus;
    @NotNull
    private String bookingStatus;
    @NotNull
    private String bookingType;
    @NotNull
    private Date bookingDate;
}
