package lk.ijse.hostelManagementSystem.bo.custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBO extends SuperBO {
    ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException;

    ArrayList<RoomDTO> searchAllRooms(String id) throws SQLException, ClassNotFoundException;

    boolean saveRooms(RoomDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteRooms(String id) throws SQLException, ClassNotFoundException;

    boolean existRoomsID(String id) throws SQLException, ClassNotFoundException;


}
