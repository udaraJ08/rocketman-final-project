package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {

//    private int paymentID;
    private BookingDTO bookingDTO;
    private Date paymentDate;
    private double damageWaiver;
    private double standardPayment;
    private int excess;
    private double excessAmount;
    private double fullPayment;
}
