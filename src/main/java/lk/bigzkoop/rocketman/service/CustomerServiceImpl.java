package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.CustomerDTO;
import lk.bigzkoop.rocketman.entity.Customer;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.repo.CustomerRepo;
import lk.bigzkoop.rocketman.service.superService.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    public CustomerDTO addCustomer(CustomerDTO dto){

        if (customerRepo.existsById(dto.getCustomer_NIC()))
            throw new RuntimeException("customer already exist");
        else {
            if (dto.getAddress().trim().length() > 0
                    && String.valueOf(dto.getContact()).trim().length() > 0
                    && dto.getCustomerName().trim().length() > 0
                    && dto.getCustomer_NIC().trim().length() > 0
            ) {
                return mapper.map(customerRepo.save(mapper.map(dto, Customer.class)), CustomerDTO.class);
            } else
                throw new ValidationException("Empty fields detected");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {

        return mapper.map(customerRepo.getAllCustomer(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public List<CustomerDTO> searchCustomer(String key) {

        if (key.trim().length()==0)
            throw new ValidationException("no key to search");

        return mapper.map(customerRepo.getCustomerByKeySearch(key), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public long getCustomerCount() {

        return customerRepo.getCustomerCount();
    }
}
