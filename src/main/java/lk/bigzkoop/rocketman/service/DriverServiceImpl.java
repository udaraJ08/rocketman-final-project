package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.DriverDTO;
import lk.bigzkoop.rocketman.dto.VehicleDTO;
import lk.bigzkoop.rocketman.entity.Booking;
import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.exceptions.NotFoundException;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.repo.BookingRepo;
import lk.bigzkoop.rocketman.repo.DriverRepo;
import lk.bigzkoop.rocketman.service.superService.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper mapper;

    public DriverDTO addDriver(DriverDTO dto) {

        if (driverRepo.existsById(dto.getDriver_NIC()))
            throw new RuntimeException("driver already exist");
        else {
            if (dto.getAddress().trim().length() > 0
                    && String.valueOf(dto.getContact()).trim().length() > 0
                    && dto.getDriverName().trim().length() > 0
            ) {
                return mapper.map(driverRepo.save(mapper.map(dto, Driver.class)), DriverDTO.class);
            } else
                throw new ValidationException("Empty fields detected");
        }

    }

    @Override
    public List<DriverDTO> getAllDrivers() {

        return mapper.map(driverRepo.getAllActiveDrivers(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public long getDriverCount() {

        return driverRepo.getActiveDriverCount();
    }

    @Override
    public List<VehicleDTO> getDriversBySearch(String key) {

        if (key.trim().length() == 0)
            throw new ValidationException("You must enter a key to search");

        return mapper.map(driverRepo.getAllDriverBySearch(key), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public DriverDTO updateDriver(DriverDTO driverDTO) {

        if (driverDTO.getAddress().trim().length() == 0 ||
                driverDTO.getDriverName().trim().length() == 0 ||
                driverDTO.getDriver_NIC().trim().length() == 0 ||
                driverDTO.getContact().trim().length() == 0
        )
            throw new ValidationException("Empty fields Detected");

        Driver driver = driverRepo.findById(driverDTO.getDriver_NIC()).get();

        if (null == driver)
            throw new NotFoundException("No Driver found by that name");

        return mapper.map(driverRepo.save(mapper.map(driverDTO, Driver.class)), DriverDTO.class);
    }

    @Override
    public DriverDTO removeDriver(String driverNIC) {

        if(driverNIC.trim().length()==0)
            throw new ValidationException("must send driver NIC");

        Driver driver = driverRepo.findById(driverNIC).get();

        if (null == driver)
            throw new NotFoundException("No driver found by that NIC");

        driver.setDriverStatus("close");

        driverRepo.save(driver);

        return mapper.map(driver, DriverDTO.class);
    }

    @Override
    public DriverDTO getDriver(String nic) {

        if (Integer.parseInt(nic)==0 || !driverRepo.existsById(nic))
            throw new NotFoundException("No Driver by that number");

        return mapper.map(driverRepo.getDriverByNIC(nic), DriverDTO.class);
    }

    @Override
    public List<Booking> getAllBookingsByDriverNIC(String NIC) {

        return bookingRepo.getAllBookingByDriverNIC(NIC);
    }

    public long allBookingCountByDriver(String nic) {

        if(!driverRepo.existsById(nic))
            throw new NotFoundException("No driver by that number");
        else if(nic.trim().length() == 0)
            throw new ValidationException("Must include nic number to search");

        return bookingRepo.getBookingCountByDriver(nic);
    }
}
