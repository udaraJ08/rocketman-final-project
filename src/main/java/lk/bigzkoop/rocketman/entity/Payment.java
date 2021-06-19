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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;
    @NotNull
    @OneToOne
    @JoinColumn(referencedColumnName = "bookingID", name = "bookingID")
    private Booking bookingID;
    private Date paymentDate;
    @NotNull
    private double damageWaiver;
    @NotNull
    private double standardPayment;
    @NotNull
    private int excess;
    @NotNull
    private double excessAmount;
    @NotNull
    private double fullPayment;
}
