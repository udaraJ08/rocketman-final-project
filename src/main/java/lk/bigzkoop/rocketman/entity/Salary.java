package lk.bigzkoop.rocketman.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payRollID;
    @OneToOne
    @JoinColumn(referencedColumnName = "driver_NIC", name = "driver_NIC")
    private Driver driver_NIC;
    @NotNull
    private double salaryAmount;
}
