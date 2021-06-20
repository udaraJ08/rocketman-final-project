package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.*;
import lk.bigzkoop.rocketman.entity.BookingHold;
import lk.bigzkoop.rocketman.entity.Customer;
import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.entity.Vehicle;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.repo.BookingHoldRepo;
import lk.bigzkoop.rocketman.repo.CustomerRepo;
import lk.bigzkoop.rocketman.repo.DriverRepo;
import lk.bigzkoop.rocketman.repo.VehicleRepo;
import lk.bigzkoop.rocketman.service.superService.BookingHoldService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingHoldServiceImpl implements BookingHoldService {

    @Autowired
    private BookingHoldRepo bookingHoldRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addBookingHold(BookingHoldDTO dto) {

        Optional<Driver> driver = driverRepo.findById(dto.getDriver_NIC());
        Optional<Customer> customer = customerRepo.findById(dto.getCustomer_NIC());
        Optional<Vehicle> vehicle = vehicleRepo.findById(dto.getVehicleNumber());

        BookingHold hold = mapper.map(dto, BookingHold.class);
        hold.setCustomer(customer.get());
        hold.setDriver(driver.get());
        hold.setVehicle(vehicle.get());
        hold.setBookingDate(Date.valueOf(LocalDate.now()));

        bookingHoldRepo.save(hold);
        return true;
    }

    @Override
    public List<BookingHold> findAllByBookingStatus(String status) {

        if (status.trim().length() == 0)
            throw new ValidationException("musr have a status (open/request/arrived/departure/closed)");

        return bookingHoldRepo.findAllByBookingStatus(status);
    }

    public boolean deleteBookingHold(int id){

        if(id==0)
            throw new ValidationException("No data to remove");

        bookingHoldRepo.deleteById(id);
        return true;
    }

    @Override
    public ValidityDriverVehicleDTO getValidityVehicleDriverAll(ValidityDateDTO dataDTO) {

        List<Vehicle> vehicleList = bookingHoldRepo.getVehicleListByDate(dataDTO.getStartDate(), dataDTO.getEndDate());
        List<Driver> driverList = bookingHoldRepo.getDriverListByDate(dataDTO.getStartDate(), dataDTO.getEndDate());

        ValidityDriverVehicleDTO dto = new ValidityDriverVehicleDTO();

        dto.setDriverDTOList(driverList);
        dto.setVehicleDTOList(vehicleList);

        return dto;
    }
}
