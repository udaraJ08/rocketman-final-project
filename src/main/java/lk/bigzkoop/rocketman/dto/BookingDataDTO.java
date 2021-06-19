package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDataDTO {

    private String id;
    private String bookingStatus;
    private long startMileage;
    private long endMileage;
    private boolean releaseStatus;
}
