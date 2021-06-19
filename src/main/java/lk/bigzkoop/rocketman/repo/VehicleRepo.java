package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {

    @Query(
            "SELECT count(v) from Vehicle v where v.type = ?1 " +
                    "and v.vehicleStatus = 'open'"
    )
    long countByType(String type);

    @Query(
            "select count(v) from Vehicle v where v.vehicleStatus = 'open'"
    )
    long getAllCount();

    @Query(
            "select v from Vehicle v where (v.vehicleNumber like ?1% " +
                    "or v.type like ?1% or " +
                    "v.brandName like ?1% or " +
                    "v.fuelType like  ?1% or " +
                    "v.type like ?1% or " +
                    "v.transmission like ?1%)" +
                    " and v.vehicleStatus = 'open'"
    )
    List<Vehicle> getVehiclesBySearch(String key);

    @Query(
            "select v from Vehicle  v where v.vehicleStatus = ?1"
    )
    List<Vehicle> getAllByStatus(String status);
}
