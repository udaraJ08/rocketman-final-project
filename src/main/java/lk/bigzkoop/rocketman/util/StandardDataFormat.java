package lk.bigzkoop.rocketman.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardDataFormat {

    private String title;
    private String body;
    private Object data;
}
