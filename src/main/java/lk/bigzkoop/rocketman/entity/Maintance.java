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
public class Maintance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maintanceID;
    @OneToOne
    @JoinColumn(referencedColumnName = "vehicleNumber", name = "vehicleNumber")
    private Vehicle vehicleNumber;
    @NotNull
    private Date maintanceDate;
    @NotNull
    private String status;
}
