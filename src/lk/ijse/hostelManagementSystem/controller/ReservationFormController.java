package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ReservationFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXButton btnAddonactionId;

    @FXML
    private JFXComboBox<?> cmbStudentId;

    @FXML
    private JFXTextField txtStudentName;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtDOB;

    @FXML
    private JFXTextField txtGender;

    @FXML
    private JFXTextField txtRoomType;

    @FXML
    private JFXTextField txtKeyMoney;

    @FXML
    private JFXComboBox<?> cmbRoomId;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtAdvance;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
