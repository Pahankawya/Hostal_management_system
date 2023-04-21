package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.ReserveBO;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.util.NotificationController;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {

    @FXML
    private JFXButton btnStudent;

    @FXML
    private AnchorPane MainAnchorPane;

    @FXML
    private JFXButton btnReserve;

    @FXML
    private JFXComboBox<String> cmbStudentId;

    @FXML
    private JFXTextField txtStudentName;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtDOB;

    @FXML
    private JFXTextField txtGender;

    @FXML
    private JFXTextField txtRoomType;

    @FXML
    private JFXTextField txtMonthlyRent;

    @FXML
    private JFXComboBox<String> cmbRoomId;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtKeyMoney;

    @FXML
    private Label llbResId;

    private String RegID;

    private final ReserveBO purchaseRoomBO = (ReserveBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVE);


    public void btnReserveOnAction(ActionEvent actionEvent) {

        cmbStudentId.setDisable(false);
        cmbRoomId.setDisable(false);
        txtRoomType.setEditable(false);
        txtQty.setEditable(false);
        txtMonthlyRent.setEditable(false);
        txtStudentName.setEditable(false);
        txtQty.setEditable(false);
        txtAddress.setEditable(false);
        txtDOB.setEditable(false);
        txtGender.setEditable(false);
        txtContactNo.setEditable(false);


        double roomFee = Double.parseDouble(txtMonthlyRent.getText());
        double advance = Double.parseDouble(txtKeyMoney.getText());
        String status = String.valueOf(roomFee - advance);

        boolean b = saveReserve(RegID, cmbStudentId.getValue(), cmbRoomId.getValue(), LocalDate.now(), txtMonthlyRent.getText(), advance, status);
        if (b) {
            NotificationController.SuccessfulTableNotification("Room Reserve", "Room Reserved in student ");
        } else {
            System.out.println(b);
            NotificationController.UnSuccessfulTableNotification("Room Reserve", "Room Reserved in student ");
        }

        RegID = generateNewOrderId(); //Generate id
        llbResId.setText(RegID);
        cmbRoomId.getSelectionModel().clearSelection();
        cmbStudentId.getSelectionModel().clearSelection();
        txtRoomType.clear();
        txtKeyMoney.clear();
        txtQty.clear();
        txtMonthlyRent.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtDOB.clear();
        txtGender.clear();
        txtContactNo.clear();
    }

    public boolean saveReserve(String resId, String stId, String roomId, LocalDate orderDate, String keyMoney, double advance, String status) {
        try {
            return purchaseRoomBO.PurchaseRoom(new ReservationDTO(resId, orderDate, stId, roomId, keyMoney, advance, status));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    @FXML
    void btnStudentOnAction(ActionEvent event) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ManageStudentForm");
    }
    private void setUi(String ui) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        MainAnchorPane.getChildren().clear();
        MainAnchorPane.getChildren().add(load);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        RegID = generateNewOrderId();
        llbResId.setText(RegID);
        btnReserve.setDisable(true);
        loadAllRoomIds();
        loadAllStudentIds();

        //---------Student to Combo-------------//
        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            enableOrDisableRegisterButton();

            if (newValue != null) {
                try {
                    if (!exitStudent(newValue + "")) {
                        NotificationController.WarringError("Search Student Warning", newValue, "There is no such student associated with the ");
                    }
                    /*Search student*/
                    StudentDTO studentDTO = purchaseRoomBO.searchStudent(newValue + "");
                    txtStudentName.setText(studentDTO.getName());
                    txtAddress.setText(studentDTO.getAddress());
                    txtDOB.setText(studentDTO.getDob() + "");
                    txtGender.setText(studentDTO.getGender());
                    txtContactNo.setText(studentDTO.getContact_no());

                } catch (SQLException | ClassNotFoundException e) {
                    NotificationController.WarringError("Search Student Warning", newValue, "Failed to find the Student ");
                }
            } else {
                txtStudentName.clear();
            }
        });

        //---------Room to Combo-------------//
        cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newRoomId) -> {
            btnReserve.setDisable(newRoomId == null);


            if (newRoomId != null) {
                try {
                    exitRooms(newRoomId + "");
                    RoomDTO room = purchaseRoomBO.searchRoom(newRoomId + "");
                    txtRoomType.setText(room.getType());
                    txtQty.setText(String.valueOf(room.getQty()));
                    txtMonthlyRent.setText(room.getKey_money());

                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }

            } else {
                txtMonthlyRent.clear();
                txtQty.clear();
                txtStudentName.clear();
                txtMonthlyRent.clear();
            }
        });
    }

    private boolean exitStudent(String id) throws SQLException, ClassNotFoundException {
        return purchaseRoomBO.checkStudentIsAvailable(id);
    }

    private boolean exitRooms(String id) throws SQLException, ClassNotFoundException {
        return purchaseRoomBO.checkRoomIsAvailable(id);
    }

    private void enableOrDisableRegisterButton() {
        btnReserve.setDisable(cmbRoomId.getSelectionModel().getSelectedItem() == null);

    }

    private String generateNewOrderId() {
        try {
            return purchaseRoomBO.generateNewReserveID();
        } catch (SQLException e) {
            NotificationController.Warring("Generate Order Id", "Failed to generate a new order id...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "REG-001";
    }

    private void loadAllStudentIds() {
        try {
            ArrayList<StudentDTO> all = purchaseRoomBO.getAllStudents();
            for (StudentDTO studentDTO : all) {
                cmbStudentId.getItems().add(studentDTO.getStudent_id());
            }

        } catch (SQLException e) {
            NotificationController.Warring("Student Load", "Failed to load customer ids.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllRoomIds() {
        try {
            ArrayList<RoomDTO> all = purchaseRoomBO.getAllRooms();
            for (RoomDTO roomDTO : all) {
                cmbRoomId.getItems().add(roomDTO.getRoom_type_id());
            }
        } catch (SQLException e) {
            NotificationController.Warring("Rooms Load", "Failed to load customer ids.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}