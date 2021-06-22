package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.VehicleDTO;
import lk.bigzkoop.rocketman.entity.Booking;

import java.util.List;

public interface VehicleService {

    VehicleDTO addVehicle(VehicleDTO dto);

    long getVehicleCountByType(String type);

    List<VehicleDTO> getAllVehicle(String status);

    List<VehicleDTO> getAllVehicleBySearch(String key);

    long getAllCount();

    VehicleDTO deleteVehicleByID(String vehicleNumber);

}
