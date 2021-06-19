package lk.bigzkoop.rocketman.service;

import lk.bigzkoop.rocketman.dto.VehicleDTO;
import lk.bigzkoop.rocketman.entity.Vehicle;
import lk.bigzkoop.rocketman.exceptions.NotFoundException;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.repo.VehicleRepo;
import lk.bigzkoop.rocketman.service.superService.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public VehicleDTO addVehicle(VehicleDTO dto) {
//        return mapper.map(vehicleRepo.save(mapper.map(dto, Vehicle.class)), VehicleDTO.class);

        if (vehicleRepo.existsById(dto.getVehicleNumber())) {
            Optional<Vehicle> vehicle = vehicleRepo.findById(dto.getVehicleNumber());
            int vehicleCount = vehicle.get().getVehicleCount();
            dto.setVehicleCount(vehicleCount + dto.getVehicleCount());

            return mapper.map(vehicleRepo.save(mapper.map(dto, Vehicle.class)), VehicleDTO.class);
        } else {
            if (String.valueOf(dto.getVehicleCount()).trim().length() > 0
                    && String.valueOf(dto.getFreeMileageForDay()).trim().length() > 0
                    && String.valueOf(dto.getFreeMileageForMonth()).trim().length() > 0

                    && String.valueOf(dto.getMonthlyRental()).trim().length() > 0
                    && String.valueOf(dto.getDailyRental()).trim().length() > 0
                    && String.valueOf(dto.getExcessForMonth()).trim().length() > 0

                    && String.valueOf(dto.getNumberOfPassengers()).trim().length() > 0
                    && dto.getFuelType().trim().length() > 0
                    && dto.getType().trim().length() > 0

                    && dto.getVehicleNumber().trim().length() > 0
                    && dto.getBrandName().trim().length() > 0
                    && dto.getFrontImg().trim().length() > 0

                    && dto.getBackImg().trim().length() > 0
                    && dto.getLeftImg().trim().length() > 0
                    && dto.getRightImg().trim().length() > 0

                    && dto.getTransmission().trim().length() > 0
                    && dto.getColor().trim().length() > 0
            ) {
                return mapper.map(vehicleRepo.save(mapper.map(dto, Vehicle.class)), VehicleDTO.class);
            } else
                throw new ValidationException("Empty fields detected");
        }
    }

    @Override
    public long getVehicleCountByType(String type) {


        return vehicleRepo.countByType(type);
    }

    @Override
    public List<VehicleDTO> getAllVehicle(String status) {

        return mapper.map(vehicleRepo.getAllByStatus(status), new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public List<VehicleDTO> getAllVehicleBySearch(String key) {
        return mapper.map(vehicleRepo.getVehiclesBySearch(key),
                new TypeToken<List<VehicleDTO>>() {
                }.getType());
    }

    @Override
    public long getAllCount() {

        return vehicleRepo.getAllCount();
    }

    @Override
    public VehicleDTO deleteVehicleByID(String vehicleNumber) {

        if (vehicleNumber.trim().length()==0)
            throw new ValidationException("No Vehilce number detected to delete !!!");

        Vehicle vehicle = vehicleRepo.getById(vehicleNumber);

        if (null == vehicle)
            throw new NotFoundException("No Vehicle found by this number");

        vehicle.setVehicleStatus("close");

        return mapper.map(vehicleRepo.save(vehicle), VehicleDTO.class);
    }

}
