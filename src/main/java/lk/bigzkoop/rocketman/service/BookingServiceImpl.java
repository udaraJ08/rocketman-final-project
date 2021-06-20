package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.BookingDataDTO;
import lk.bigzkoop.rocketman.dto.PaymentDTO;
import lk.bigzkoop.rocketman.entity.Booking;
import lk.bigzkoop.rocketman.entity.BookingHold;
import lk.bigzkoop.rocketman.entity.Payment;
import lk.bigzkoop.rocketman.entity.Vehicle;
import lk.bigzkoop.rocketman.entity.queryEntity.BookingAndCustomer;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.repo.BookingHoldRepo;
import lk.bigzkoop.rocketman.repo.BookingRepo;
import lk.bigzkoop.rocketman.repo.PaymentRepo;
import lk.bigzkoop.rocketman.service.superService.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingHoldRepo bookingHoldRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Booking openStatus(BookingDataDTO dataDTO) {

        if (dataDTO.getBookingStatus().trim().length() == 0)
            throw new ValidationException("You must add booking status");
        else if (dataDTO.getId().trim().length() == 0)
            throw new ValidationException("You must add bookingHold ID");

        BookingHold hold = bookingHoldRepo.findById(Integer.parseInt(dataDTO.getId())).get();

        Booking booking = mapper.map(hold, Booking.class);

        String id = "";
        long count = bookingRepo.count();
        if (count == 0) {
            id = "B-" + (count + 1);
        } else {
            id = "B-" + (count + 1);
        }

        booking.setBookingID(id);

        hold.setBookingStatus(dataDTO.getBookingStatus());
        booking.setBookingStatus(dataDTO.getBookingStatus());
        booking.setBookingDate(Date.valueOf(LocalDate.now()));

        bookingHoldRepo.save(hold);
        return bookingRepo.save(booking);
    }

    @Override
    public boolean departureStatus(BookingDataDTO dto) {

        if (dto.getStartMileage() == 0)
            throw new ValidationException("You must add start milage");
        else if (dto.getId().trim().length() == 0)
            throw new ValidationException("You must add booking ID");

        Booking booking = bookingRepo.findById(dto.getId()).get();

        if (!booking.getBookingStatus().equalsIgnoreCase("open"))
            throw new RuntimeException("Booking must be open before departure");

        Vehicle vehicle = booking.getVehicle();
        Payment payment = new Payment();


        if (booking.getDuration().equalsIgnoreCase("day")) {
            payment.setStandardPayment(vehicle.getDailyRental());
        } else if (booking.getDuration().equalsIgnoreCase("month")) {
            payment.setStandardPayment(vehicle.getMonthlyRental());
        }

        booking.setBookingStatus("departure");
        booking.setStartMileage(dto.getStartMileage());

        payment.setDamageWaiver(vehicle.getDamageWaiver());
        payment.setBookingID(booking);
        payment.setPaymentDate(booking.getArrivalDate());
        payment.setExcess(0);
        payment.setExcessAmount(0);
        payment.setFullPayment(0);
        bookingRepo.save(booking);
        paymentRepo.save(mapper.map(payment, Payment.class));

        return true;
    }

    @Override
    public PaymentDTO arrivedStatus(BookingDataDTO dataDTO) {

        if (dataDTO.getEndMileage() == 0)
            throw new ValidationException("You must add end milage");
        else if (dataDTO.getId().trim().length() == 0)
            throw new ValidationException("You must add booking ID");


        Booking booking = bookingRepo.findById(dataDTO.getId()).get();
        Vehicle vehicle = booking.getVehicle();

        Payment payment = paymentRepo.findByBookingID(booking);

        booking.setBookingStatus("arrived");
        booking.setEndMileage(dataDTO.getEndMileage());

        long startM = booking.getStartMileage();
        long endM = booking.getEndMileage();
        int freeMileage = 0;

        if (booking.getDuration().equalsIgnoreCase("day"))
            freeMileage = vehicle.getFreeMileageForDay();
        else if (booking.getDuration().equalsIgnoreCase("month"))
            freeMileage = vehicle.getFreeMileageForMonth();

        long milf = endM - startM;

        if (milf > freeMileage) {
            int excess = (int) (milf - freeMileage);
            double excessAmount = excess * vehicle.getExcessForMonth();
            payment.setExcess(excess);
            payment.setExcessAmount(excessAmount);
            payment.setFullPayment(payment.getStandardPayment() + excessAmount);
        } else {
            payment.setExcess(0);
            payment.setExcessAmount(0);
            payment.setFullPayment(payment.getStandardPayment());
        }

        payment.setPaymentDate(Date.valueOf(LocalDate.now()));

        bookingRepo.save(booking);
        return mapper.map(paymentRepo.save(payment), PaymentDTO.class);
    }

    @Override
    public boolean cancelStatus(BookingDataDTO dataDTO) {

        if (dataDTO.getId().trim().length() == 0)
            throw new ValidationException("You must enter the booking ID");

        Booking booking = bookingRepo.findById(dataDTO.getId()).get();

        if (!booking.getBookingStatus().equalsIgnoreCase("open"))
            throw new ValidationException("Only open bookings can be deleted");

        booking.setBookingStatus("canceled");
        bookingRepo.save(booking);

        return true;
    }

    @Override
    public boolean releaseStatus(BookingDataDTO dataDto) {

        if (!dataDto.isReleaseStatus())
            throw new ValidationException("You must release the state (set True)");

        Booking booking = bookingRepo.findById(dataDto.getId()).get();

        if (!booking.getBookingStatus().equalsIgnoreCase("arrived"))
            throw new RuntimeException("Booking must be arrived before release");

        booking.setReleaseStatus(dataDto.isReleaseStatus());

        return true;
    }

    @Override
    public List<BookingAndCustomer> getAllBooking(String nic) {

        return bookingRepo.getAllBookingAndCustomer(nic);
    }

    @Override
    public List<Booking> getAllBookingByStatus(String status) {

        if (status.trim().length() == 0)
            throw new ValidationException("must include status");

        return bookingRepo.findAllByBookingStatus(status);
    }

    @Override
    public List<Booking> getAllBooking() {

        return bookingRepo.findAll();
    }

    @Override
    public List<Booking> getAllTodayBooking() {

        Date date = Date.valueOf(LocalDate.now());

        return bookingRepo.getAllTodayBookings(date);
    }
}
