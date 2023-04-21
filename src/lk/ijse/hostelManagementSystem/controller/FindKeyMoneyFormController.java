package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.ReserveBO;
import lk.ijse.hostelManagementSystem.dto.ReservationDTO;
import lk.ijse.hostelManagementSystem.util.NotificationController;
import lk.ijse.hostelManagementSystem.view.TM.ReservationTM;


import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FindKeyMoneyFormController implements Initializable {
    public AnchorPane MainAnchorPane;
    public JFXTextField txtSearch;
    public TableView <ReservationTM>tblRemain;

    private final ReserveBO reserveBO = (ReserveBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVE);


    public void txtSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (txtSearch.getText().trim().isEmpty()) {
            NotificationController.Warring("Empty Search Id", "Please Enter Current ID.");
            loadAllReserve();
        } else {
            if (RegExit(txtSearch.getText())) {
                tblRemain.getItems().clear();
                ArrayList<ReservationDTO> arrayList = reserveBO.getAllReserveSearch(txtSearch.getText());
                if (arrayList != null) {
                    for (ReservationDTO reservationDTO : arrayList) {
                        tblRemain.getItems().add(new ReservationTM(reservationDTO.getRes_id(), reservationDTO.getDate(), reservationDTO.getStudent_id(), reservationDTO.getRoom_type_id(), reservationDTO.getKey_money(), reservationDTO.getAdvance(), reservationDTO.getStatus()));
                    }
                }
            } else {
                tblRemain.getItems().clear();
                NotificationController.Warring("Empty Data Set", "Please Enter Current ID.");
            }
        }
    }


    private boolean RegExit(String id) throws SQLException, ClassNotFoundException {
        return reserveBO.existReserveID(id);
    }

    private void loadAllReserve() {
        tblRemain.getItems().clear();
        /*Get all Reserve*/
        try {
            ArrayList<ReservationDTO> allReserve = reserveBO.getAllReserve();
            for (ReservationDTO reservationDTO : allReserve) {
                tblRemain.getItems().add(new ReservationTM(reservationDTO.getRes_id(), reservationDTO.getDate(), reservationDTO.getStudent_id(), reservationDTO.getRoom_type_id(), reservationDTO.getKey_money(), reservationDTO.getAdvance(), reservationDTO.getStatus()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblRemain.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("res_id"));
        tblRemain.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("student_id"));
        tblRemain.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        tblRemain.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblRemain.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("key_money"));
        tblRemain.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("advance"));
        tblRemain.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("status"));
        loadAllReserve();
    }
}
