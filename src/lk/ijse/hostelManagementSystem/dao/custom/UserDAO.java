package lk.ijse.hostelManagementSystem.dao.custom;

import lk.ijse.hostelManagementSystem.dao.CrudDAO;
import lk.ijse.hostelManagementSystem.entity.Login;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO extends CrudDAO<Login, String> {
    ArrayList<Login> getAllUsers() throws SQLException, ClassNotFoundException;
}
