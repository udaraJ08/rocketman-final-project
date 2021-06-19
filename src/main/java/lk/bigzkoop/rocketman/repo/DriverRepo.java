package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver, String> {

    @Query(
            "select d from Driver  d where d.driverStatus = 'open'"
    )
    List<Driver> getAllActiveDrivers();

    @Query(
            "select count(d) from Driver d where " +
                    "d.driverStatus = 'open'"
    )
    long getActiveDriverCount();

    @Query(
            "select d from Driver d where (d.driver_NIC like ?1% " +
                    "or d.driverName like ?1% or " +
                    "d.driverStatus like ?1% or " +
                    "d.address like  ?1% or " +
                    "d.contact like ?1% or " +
                    "d.gmail like ?1%)" +
                    " and d.driverStatus = 'open'"
    )
    List<Driver> getAllDriverBySearch(String key);
}
