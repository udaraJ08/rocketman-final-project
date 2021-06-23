package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.DriverDTO;
import lk.bigzkoop.rocketman.dto.UserSignupDTO;
import lk.bigzkoop.rocketman.dto.ValidateUserDTO;

public interface DriverUserService {

    DriverDTO validateDriver(ValidateUserDTO dto);

    String signupDriver(UserSignupDTO dto);
}
