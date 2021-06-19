package lk.bigzkoop.rocketman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    private String customer_NIC;
    private String nic_img;
    private String lic_no;
    private String lic_img;
    private String customerName;
    private int contact;
    private String address;
    private String customerStatus;
}
