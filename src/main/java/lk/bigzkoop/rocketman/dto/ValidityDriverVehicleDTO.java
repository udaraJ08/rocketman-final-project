package lk.bigzkoop.rocketman.dto;

import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidityDriverVehicleDTO {

    private List<Driver> driverDTOList;
    private List<Vehicle> vehicleDTOList;
}
