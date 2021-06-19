package lk.bigzkoop.rocketman.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {

    @Id
    private String bookingID;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "driver_NIC", name = "driver_NIC")
    @Fetch(FetchMode.JOIN)
    private Driver driver;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "customer_NIC", name = "customer_NIC")
    @Fetch(FetchMode.JOIN)
    private Customer customer;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "vehicleNumber", name="vehicleNumber")
    @Fetch(FetchMode.JOIN)
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
