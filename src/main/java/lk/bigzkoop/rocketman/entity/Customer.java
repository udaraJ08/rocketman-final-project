package lk.bigzkoop.rocketman.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    private String customer_NIC;
    @NotNull
    private String nic_img;
    private String lic_no;
    private String lic_img;
    @NotNull
    @Column(length = 60)
    private String customerName;
    @NotNull
    private int contact;
    @NotNull
    private String address;
    @NotNull
    private String customerStatus;
}
