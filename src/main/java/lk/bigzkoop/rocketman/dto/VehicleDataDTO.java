package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDataDTO {

    private Date bookedDate;
    private Date releaseDate;
    private String vehicleNumber;
}
