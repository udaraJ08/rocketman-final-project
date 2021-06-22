package lk.bigzkoop.rocketman.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    @OneToOne
    @JoinColumn(referencedColumnName = "customer_NIC", name = "customer_NIC")
    private Customer customer;
    @NotNull
    private String userName;
    @NotNull
    private String password;
}
