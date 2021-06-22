package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.BookingHoldDTO;
import lk.bigzkoop.rocketman.dto.ValidityDateDTO;
import lk.bigzkoop.rocketman.dto.ValidityDriverVehicleDTO;
import lk.bigzkoop.rocketman.entity.BookingHold;
import lk.bigzkoop.rocketman.entity.Customer;
import lk.bigzkoop.rocketman.entity.Driver;
import lk.bigzkoop.rocketman.entity.Vehicle;
import lk.bigzkoop.rocketman.exceptions.NotFoundException;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.repo.BookingHoldRepo;
import lk.bigzkoop.rocketman.repo.CustomerRepo;
import lk.bigzkoop.rocketman.repo.DriverRepo;
import lk.bigzkoop.rocketman.repo.VehicleRepo;
import lk.bigzkoop.rocketman.service.superService.BookingHoldService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    @Autowired
    private Random rnd;

    @Override
    public boolean addBookingHold(BookingHoldDTO dto) {

        int index = 0;
        List<Driver> driverList = driverRepo.getAllActiveDrivers();

        /////////////randomly assigning a driver////////
        if (dto.getDriver_NIC().trim().equals("set")) {
            int size = driverList.size() - 1;
            index = rnd.nextInt(size - 0 + 1) + 0;

            if (index == 0)
                index++;
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(index);
        System.out.println();
        System.out.println();
        System.out.println();

        ////////////assigning over/////////////////////
        Driver driver = driverList.get(index);
        Optional<Customer> customer = customerRepo.findById(dto.getCustomer_NIC());
        Optional<Vehicle> vehicle = vehicleRepo.findById(dto.getVehicleNumber());


        Date arrDate = dto.getArrivalDate();
        String dateToPlus = arrDate.toString();
        LocalDate dateToPlusLocal = LocalDate.parse(dateToPlus);

        LocalDate releaseDate = dateToPlusLocal.plusDays(2);

        BookingHold hold = mapper.map(dto, BookingHold.class);
        hold.setCustomer(customer.get());
        hold.setDriver(driver);
        hold.setVehicle(vehicle.get());
        hold.setReleaseDate(Date.valueOf(releaseDate));
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

    public boolean deleteBookingHold(int id) {

        if (id == 0)
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

    @Override
    public List<BookingHold> getBookingByCustomerNIC(String NIC) {

        if (NIC.trim().length() == 0)
            throw new ValidationException("Must have NIC to get Data");
        else if (!customerRepo.existsById(NIC))
            throw new NotFoundException("No user found by that number");

        return bookingHoldRepo.getBookingHoldByNIC(NIC);
    }
}
