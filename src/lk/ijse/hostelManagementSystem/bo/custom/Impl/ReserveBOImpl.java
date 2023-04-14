package lk.ijse.hostelManagementSystem.bo.custom.Impl;

import lk.ijse.hostelManagementSystem.bo.custom.ReserveBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.ReserveDAO;
import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.entity.Reservation;
import lk.ijse.hostelManagementSystem.entity.Student;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReserveBOImpl implements ReserveBO {
    private final ReserveDAO reserveDAO = (ReserveDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVE);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public ArrayList<ReservationDTO> getAllReserve() throws SQLException, ClassNotFoundException {
        ArrayList<Reservation> all = reserveDAO.getAll();
        ArrayList<ReservationDTO> allReserve = new ArrayList<>();
        for (Reservation r : all) {
            allReserve.add(new ReservationDTO(r.getRes_id(), r.getDate(), r.getStudent_id().getStudent_id(), r.getRoom_id().getRoom_id(), r.getKey_money(), r.getAdvance(), r.getStatus()));
        }
        return allReserve;
    }

    @Override
    public ArrayList<ReservationDTO> getAllReserveSearch(String id) throws SQLException, ClassNotFoundException {
        Reservation all = reserveDAO.search(id);
        ArrayList<ReservationDTO> allSearchReserve = new ArrayList<>();
        allSearchReserve.add(new ReservationDTO(all.getRes_id(), all.getDate(), all.getStudent_id().getStudent_id(), all.getRoom_id().getRoom_id(), all.getKey_money(), all.getAdvance(), all.getStatus()));
        return allSearchReserve;
    }

    @Override
public boolean updateReserve(ReservationDTO dto) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, dto.getStudent_id());
        Room

    }
