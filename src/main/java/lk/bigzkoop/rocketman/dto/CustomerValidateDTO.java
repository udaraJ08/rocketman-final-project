package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerValidateDTO {

    private String username;
    private String password;
}
