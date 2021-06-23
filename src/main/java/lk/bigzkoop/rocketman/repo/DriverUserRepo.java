package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.entity.DriverUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverUserRepo extends JpaRepository<DriverUser, String> {

    @Query(
            "SELECT d.driver from DriverUser d where d.username = ?1 and " +
                    "d.password = ?2"
    )
    Driver validateDriverUser(String username, String password);

    @Query(
            "SELECT d.driver from DriverUser d where  d.driver.driver_NIC = ?1"
    )
    Driver isExistDriverUser(String nic);
}
