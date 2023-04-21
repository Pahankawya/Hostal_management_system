package lk.ijse.hostelManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Login {

    @Id
    @Column(columnDefinition = "VARCHAR(200)")
    private String userID;
    private String name;
    private String address;
    private String contact_no;
    private String Password;
    private String gender;

}
