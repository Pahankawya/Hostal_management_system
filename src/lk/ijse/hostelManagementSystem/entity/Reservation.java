package lk.ijse.hostelManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    private String res_id;
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_Id", referencedColumnName = "Student_Id")
    private Student student_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Room room_id;
    private String key_money;
    private Double advance;
    private String status;
}