package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query("select c from Customer c where c.customerStatus = 'open'")
    List<Customer> getAllCustomer();

    @Query("SELECT count(c) from Customer c where c.customerStatus = 'open'")
    long getCustomerCount();

    @Query(
            "select c from Customer c where (c.customer_NIC like ?1% " +
                    "or c.customerName like ?1% or " +
                    "" +
                    "c.address like  ?1%" +
                    "" +
                    ")" +
                    " and c.customerStatus = 'open'"
    )
    List<Customer> getCustomerByKeySearch(String key);
}
