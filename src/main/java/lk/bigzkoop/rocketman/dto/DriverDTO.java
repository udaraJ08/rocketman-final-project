package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DriverDTO {

    private String driver_NIC;
    private String driverName;
    private String address;
    private String contact;
    private String gmail;
    private String driverStatus;
}
