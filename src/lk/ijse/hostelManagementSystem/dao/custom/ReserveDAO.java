package lk.ijse.hostelManagementSystem.dao.custom;


import lk.ijse.hostelManagementSystem.dao.CrudDAO;
import lk.ijse.hostelManagementSystem.entity.Reservation;

import java.sql.SQLException;


public interface ReserveDAO extends CrudDAO<Reservation, String> {

    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean existStudent(String id) throws SQLException, ClassNotFoundException;
}
