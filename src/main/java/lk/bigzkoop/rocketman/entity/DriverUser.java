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
public class DriverUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverUID;
    @OneToOne
    @JoinColumn(referencedColumnName = "driver_NIC", name = "driver_NIC")
    private Driver driver;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
