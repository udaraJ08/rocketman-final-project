package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.ValidateUserDTO;
import lk.bigzkoop.rocketman.dto.VehicleDataDTO;
import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.entity.Vehicle;

import java.util.List;

public interface AdminUserService {

    boolean validateAdmin(ValidateUserDTO dto);
}
