package lk.bigzkoop.rocketman.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {

    @Id
    private String vehicleNumber;
    @NotNull
    private int vehicleCount;
    @NotNull
    private String type;
    @NotNull
    private String fuelType;
    @NotNull
    private double damageWaiver;
    @NotNull
    private int freeMileageForMonth;
    @NotNull
    private int freeMileageForDay;
    @NotNull
    private double monthlyRental;
    @NotNull
    private double dailyRental;
    @NotNull
    private double excessForMonth;
    @NotNull
    private int numberOfPassengers;
    @NotNull
    private String brandName;
    @NotNull
    private String frontImg;
    @NotNull
    private String backImg;
    @NotNull
    private String leftImg;
    @NotNull
    private String rightImg;
    @NotNull
    private String transmission;
    @NotNull
    private String color;
    @NotNull
    private String vehicleStatus;
}
