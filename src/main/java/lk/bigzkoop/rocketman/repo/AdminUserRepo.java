package lk.bigzkoop.rocketman.repo;

import lk.bigzkoop.rocketman.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminUserRepo extends JpaRepository<AdminUser, String> {

    @Query(
            "SELECT a from AdminUser a where a.username = ?1 " +
                    "and a.password = ?2"
    )
    AdminUser checkValidityAdminUser(String username, String password);
}
