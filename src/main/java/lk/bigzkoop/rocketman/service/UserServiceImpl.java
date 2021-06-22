package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.CustomerValidateDTO;
import lk.bigzkoop.rocketman.dto.UserCustomerDTO;
import lk.bigzkoop.rocketman.entity.Customer;
import lk.bigzkoop.rocketman.entity.UserCustomer;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.repo.CustomerRepo;
import lk.bigzkoop.rocketman.repo.UserRepo;
import lk.bigzkoop.rocketman.service.superService.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addUser(UserCustomerDTO dto) {

        if(dto.getCustomerNIC().trim().length() == 0 ||
                dto.getCustomerUsername().trim().length() == 0 ||
                dto.getCustomerPassword().trim().length() == 0
        )
            throw new ValidationException("Empty field detected !!!");

        Customer customer = customerRepo.findById(dto.getCustomerNIC()).get();

        if (customerRepo.existsById(dto.getCustomerNIC()))
            throw new ValidationException("No Nic found by that number");

        UserCustomer userCustomer = mapper.map(dto, UserCustomer.class);
        userCustomer.setCustomer(customer);

        userRepo.save(userCustomer);
        return true;
    }


    @Override
    public String validateUser(CustomerValidateDTO dto) {

        String nic = userRepo.customerValidity(dto.getUsername(), dto.getPassword());

        return nic;
    }
}
