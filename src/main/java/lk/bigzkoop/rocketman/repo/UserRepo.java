package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserCustomer, String> {

    @Query("select u.customer.customer_NIC from UserCustomer u where" +
            " u.userName = ?1 and" +
            " u.password = ?2")
    String customerValidity(String username, String password);
}
