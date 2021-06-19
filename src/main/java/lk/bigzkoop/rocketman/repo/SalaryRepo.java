package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepo extends JpaRepository<Salary, Integer> {
}
