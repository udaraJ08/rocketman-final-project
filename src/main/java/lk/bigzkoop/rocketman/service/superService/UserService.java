package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.CustomerValidateDTO;
import lk.bigzkoop.rocketman.dto.UserCustomerDTO;

public interface UserService {

    boolean addUser(UserCustomerDTO dto);

    String validateUser(CustomerValidateDTO dto);
}
