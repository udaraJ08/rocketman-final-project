package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {

    private String vehicleNumber;
    private int vehicleCount;
    private String type;

    private String fuelType;
    private double damageWaiver;
    private int freeMileageForMonth;

    private int freeMileageForDay;

    private double monthlyRental;
    private double dailyRental;
    private double excessForMonth;

    private int numberOfPassengers;
    private String brandName;
    private String frontImg;

    private String backImg;
    private String leftImg;
    private String rightImg;

    private String transmission;
    private String color;

    private String vehicleStatus;
}
