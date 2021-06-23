package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.ValidateUserDTO;
import lk.bigzkoop.rocketman.dto.UserSignupDTO;

public interface UserService {

    boolean addUser(UserSignupDTO dto);

    String validateUser(ValidateUserDTO dto);
}
