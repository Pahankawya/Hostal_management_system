package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.UserBO;
import lk.ijse.hostelManagementSystem.dto.LoginDTO;
import lk.ijse.hostelManagementSystem.util.NotificationController;
import lk.ijse.hostelManagementSystem.view.TM.LoginTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageUserFormController implements Initializable {
    public AnchorPane UserPane;
    public JFXTextField txtId;

    public TableView <LoginTM>tblUser;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtPassword;
    public JFXComboBox <String>cmbGender;
    public Button btnAddNew;
    public Button btnSave;
    public Button btnDelete;

    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);


    public void btnAddNew_OnAction(ActionEvent actionEvent) {

        txtId.setDisable(false);
        txtName.setDisable(false);
        txtContactNo.setDisable(false);
        txtAddress.setDisable(false);
        txtPassword.setDisable(false);
        cmbGender.setDisable(false);

        txtId.clear();
        txtName.clear();
        txtContactNo.clear();
        txtAddress.clear();
        txtPassword.clear();
        cmbGender.getSelectionModel().clearSelection();
        txtId.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblUser.getSelectionModel().clearSelection();
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String cNO = txtContactNo.getText();
        String address = txtAddress.getText();
        String pws = txtPassword.getText();
        String gender = cmbGender.getValue();


        if (!id.matches("^([A-z 0-9]{6,20})$")) {
            NotificationController.Warring("User Id", "Invalid User Id.");
            txtId.requestFocus();
            return;
        } else if (!name.matches("^([A-Z a-z]{5,40})$")) {
            NotificationController.Warring("Student Name", "User Name.");
            txtName.requestFocus();
            return;
        } else if (!cNO.matches("^(07(0|1|2|4|5|6|7|8)[0-9]{7})$")) {
            NotificationController.Warring("Contact Number", "Invalid User Contact Number.");
            txtContactNo.requestFocus();
            return;
        } else if (!address.matches("^([A-Za-z]{4,10})$")) {
            NotificationController.Warring("Address", "Invalid User Address.");
            txtAddress.requestFocus();
            return;
        } else if (!pws.matches("^([A-z 0-9]{4,20})$")) {
            NotificationController.Warring("Password", "Invalid User Password.");
            txtPassword.requestFocus();
            return;
        } else if (!gender.matches("^([A-Z a-z]{4,20})$")) {
            NotificationController.Warring("Gender", "Invalid User Gender.");
            cmbGender.requestFocus();
            return;
        }

        if (btnSave.getText().equalsIgnoreCase("save")) {
            /*Save User*/
            try {
                if (exitUser(id)) {
                    NotificationController.WarringError("Save User Warning", id, "Already exists ");
                }
                userBO.saveUser(new LoginDTO(id, name, address, cNO, pws, gender));
                tblUser.getItems().add(new LoginTM(id, name, address, cNO, pws, gender));
                NotificationController.SuccessfulTableNotification("Save", "User");
            } catch (SQLException e) {
                NotificationController.WarringError("Save User Warning", id + e.getMessage(), "Failed to save the User ");
                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            /*Update User*/
            try {
                if (!exitUser(id)) {
                    NotificationController.WarringError("Update User Warning", id, "There is no such User associated with the ");
                }
                //User update
                userBO.updateUser(new LoginDTO(id, name, address, cNO, pws, gender));
                NotificationController.SuccessfulTableNotification("Update", "User");
            } catch (SQLException e) {
                NotificationController.WarringError("Update User Warning", id + e.getMessage(), "Failed to update the User ");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            LoginTM selectedItem = tblUser.getSelectionModel().getSelectedItem();
            selectedItem.setUserID(id);
            selectedItem.setName(name);
            selectedItem.setAddress(address);
            selectedItem.setContact_no(cNO);
            selectedItem.setPassword(pws);
            selectedItem.setGender(gender);
            tblUser.refresh();
        }
        btnAddNew.fire();
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {

        String code = tblUser.getSelectionModel().getSelectedItem().getUserID();
        try {
            if (!exitUser(code)) {
                NotificationController.WarringError("Delete User Warning", code, "There is no such User associated with the ");
            }
            userBO.deleteUser(code);
            tblUser.getItems().remove(tblUser.getSelectionModel().getSelectedItem());
            NotificationController.SuccessfulTableNotification("Delete", "User");
            tblUser.getSelectionModel().clearSelection();
            initUI();
        } catch (SQLException e) {
            NotificationController.WarringError("Delete User Warning", code, "Failed to delete the User ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initUI() {
        txtId.clear();
        txtName.clear();
        txtContactNo.clear();
        txtAddress.clear();
        txtPassword.clear();
        cmbGender.getSelectionModel().clearSelection();

        txtId.setDisable(true);
        txtName.setDisable(true);
        txtContactNo.setDisable(true);
        txtAddress.setDisable(true);
        txtPassword.setDisable(true);
        cmbGender.setDisable(true);

        btnSave.setDisable(true);
        btnDelete.setDisable(true);
    }

    private boolean exitUser(String id) throws SQLException, ClassNotFoundException {
        return userBO.existUser(id);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cmbGender.getItems().addAll("Male", "Female", "Other");

        tblUser.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("userID"));
        tblUser.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblUser.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblUser.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        tblUser.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Password"));
        tblUser.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));

        initUI();

        tblUser.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);

            if (newValue != null) {
                //------------------------Text Filed Load----------------------//
                txtId.setText(newValue.getUserID());
                txtName.setText(newValue.getName());
                txtContactNo.setText(newValue.getContact_no());
                txtAddress.setText(newValue.getAddress());
                txtPassword.setText(newValue.getPassword());
                cmbGender.setValue(newValue.getGender() + "");

                txtId.setDisable(false);
                txtName.setDisable(false);
                txtContactNo.setDisable(false);
                txtAddress.setDisable(false);
                txtPassword.setDisable(false);
                cmbGender.setDisable(false);
            }
        });

        txtAddress.setOnAction(event -> btnSave.fire());
        laodAllUsers();
    }

    private void laodAllUsers() {
        tblUser.getItems().clear();
        /*Get all Student*/
        try {
            ArrayList<LoginDTO> allUsers = userBO.getAllUsers();
            for (LoginDTO loginDTO : allUsers) {
                tblUser.getItems().add(new LoginTM(loginDTO.getUserID(), loginDTO.getName(), loginDTO.getAddress(), loginDTO.getContact_no(), loginDTO.getPassword(), loginDTO.getGender()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}


