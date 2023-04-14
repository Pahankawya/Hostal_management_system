package lk.ijse.hostelManagementSystem.bo;


import lk.ijse.hostelManagementSystem.bo.custom.Impl.ReserveBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.Impl.RoomBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.Impl.StudentBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.Impl.UserBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case RESERVE:
                return new ReserveBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        STUDENT, ROOM, RESERVE, USER
    }
}
