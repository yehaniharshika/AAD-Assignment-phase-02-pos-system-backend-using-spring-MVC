package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.customStatusCodes;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.CustomerStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedErrorStatus implements CustomerStatus, ItemStatus{
    private int statusCode;
    private String statusMessage;
}
