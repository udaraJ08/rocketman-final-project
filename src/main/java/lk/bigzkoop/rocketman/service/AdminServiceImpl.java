package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.VehicleDataDTO;
import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.entity.Vehicle;
import lk.bigzkoop.rocketman.repo.BookingRepo;
import lk.bigzkoop.rocketman.service.superService.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BookingRepo bookingRepo;
}
