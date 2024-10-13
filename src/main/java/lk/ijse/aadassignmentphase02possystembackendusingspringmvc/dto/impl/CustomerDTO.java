package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String customerId;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
}
