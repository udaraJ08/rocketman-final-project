package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.ValidateUserDTO;
import lk.bigzkoop.rocketman.entity.AdminUser;
import lk.bigzkoop.rocketman.repo.AdminUserRepo;
import lk.bigzkoop.rocketman.service.superService.AdminUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AdminUserRepo adminUserRepo;

    @Override
    public boolean validateAdmin(ValidateUserDTO dto) {

        AdminUser user = adminUserRepo.checkValidityAdminUser(dto.getUsername(), dto.getPassword());

        return user != null;
    }
}
