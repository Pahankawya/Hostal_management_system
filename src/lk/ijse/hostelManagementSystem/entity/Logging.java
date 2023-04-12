package lk.ijse.hostelManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logging {
    @Id
    private String userID;
    private String name;
    private String address;
    private String contact_no;
    private String Password;
    private String gender;

}
