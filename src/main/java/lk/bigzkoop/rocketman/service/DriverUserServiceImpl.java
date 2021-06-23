package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.DriverDTO;
import lk.bigzkoop.rocketman.dto.UserSignupDTO;
import lk.bigzkoop.rocketman.dto.ValidateUserDTO;
import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.entity.DriverUser;
import lk.bigzkoop.rocketman.exceptions.NotFoundException;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.repo.DriverRepo;
import lk.bigzkoop.rocketman.repo.DriverUserRepo;
import lk.bigzkoop.rocketman.service.superService.DriverUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DriverUserServiceImpl implements DriverUserService {

    @Autowired
    private DriverUserRepo driverUserRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public DriverDTO validateDriver(ValidateUserDTO dto) {

        if (dto.getUsername().trim().length() == 0 ||
                dto.getPassword().trim().length() == 0
        )
            throw new ValidationException("Must have username and email to validate");

        return mapper.map(driverUserRepo.validateDriverUser(dto.getUsername(), dto.getPassword()), DriverDTO.class);
    }

    @Override
    public String signupDriver(UserSignupDTO dto) {

        Driver driver = driverRepo.getDriverByNIC(dto.getCustomerNIC());

        if (driver == null)
            throw new NotFoundException("There is no driver by that number");

        if (driverUserRepo.isExistDriverUser(dto.getCustomerNIC()) != null)
            throw new ValidationException("Driver already signed up");


        DriverUser driverUser = mapper.map(dto, DriverUser.class);
        driverUser.setDriver(driver);

        driverUserRepo.save(driverUser);
        return "signup";
    }
}
