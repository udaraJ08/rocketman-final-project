package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.DriverDTO;
import lk.bigzkoop.rocketman.dto.VehicleDTO;

import java.util.List;

public interface DriverService {

    DriverDTO addDriver(DriverDTO dto);

    List<DriverDTO> getAllDrivers();

    long getDriverCount();

    List<VehicleDTO> getDriversBySearch(String key);

    DriverDTO updateDriver(DriverDTO driverDTO);

    DriverDTO removeDriver(String driverNIC);
}
