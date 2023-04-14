package lk.ijse.hostelManagementSystem.bo.custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReserveBO extends SuperBO {
    ArrayList<ReservationDTO> getAllReserve() throws SQLException, ClassNotFoundException;

    ArrayList<ReservationDTO> getAllReserveSearch(String id) throws SQLException, ClassNotFoundException;

    boolean updateReserve(ReservationDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteReserve(String id) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean existReserveID(String id) throws SQLException, ClassNotFoundException;

    boolean existStudent(String id) throws SQLException, ClassNotFoundException;

    boolean PurchaseRoom(ReservationDTO dto) throws SQLException, ClassNotFoundException;

    StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException;

    RoomDTO searchRoom(String code) throws SQLException, ClassNotFoundException;

    boolean checkRoomIsAvailable(String code) throws SQLException, ClassNotFoundException;

    boolean checkStudentIsAvailable(String id) throws SQLException, ClassNotFoundException;

    String generateNewReserveID() throws SQLException, ClassNotFoundException;

    ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException;

    ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException;

}


