package lk.bigzkoop.rocketman.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {

    @Id
    private String driver_NIC;
    @NotNull
    @Column(length = 60)
    private String driverName;
    @NotNull
    @Column(length = 100)
    private String address;
    @NotNull
    @Column(length = 11)
    private String contact;
    @Column(length = 20)
    private String gmail;
    @NotNull
    @Column(length = 10)
    private String driverStatus;
}
