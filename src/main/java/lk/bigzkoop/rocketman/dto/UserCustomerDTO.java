package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCustomerDTO {

    private String customerNIC;
    private String customerUsername;
    private String customerPassword;
}
