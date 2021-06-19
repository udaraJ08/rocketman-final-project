package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.Booking;
import lk.bigzkoop.rocketman.entity.Maintance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintanceRepo extends JpaRepository<Maintance, Integer> {


}
