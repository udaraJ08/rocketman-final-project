package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidateUserDTO {

    private String username;
    private String password;
}
