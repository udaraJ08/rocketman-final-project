package lk.bigzkoop.rocketman.service.superService;

import lk.bigzkoop.rocketman.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO addCustomer(CustomerDTO dto);

    List<CustomerDTO> getAllCustomer();

    List<CustomerDTO> searchCustomer(String key);

    long getCustomerCount();
}
