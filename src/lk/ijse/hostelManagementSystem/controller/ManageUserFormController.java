package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class ManageUserFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtuserName;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXTextField txtUserAddress;

    @FXML
    private JFXButton btnAddonactionId;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private TableView<?> tbl;

    @FXML
    private TableColumn<?, ?> tblId;

    @FXML
    private TableColumn<?, ?> tblname;

    @FXML
    private TableColumn<?, ?> tblAddress;

    @FXML
    private TableColumn<?, ?> tblContact;

    @FXML
    private TableColumn<?, ?> tblPassword;

    @FXML
    private TableColumn<?, ?> tblGender;

    @FXML
    private Label lblUserNameWarning;

    @FXML
    private Label lblUserNameWarning1;

    @FXML
    private Label lblUserNameWarning2;

    @FXML
    private Label lblUserNameWarning3;

    @FXML
    private Label lblWarning4;

    @FXML
    private JFXComboBox<?> cmbGender;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnContactOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnIdOnAction(ActionEvent event) {

    }

    @FXML
    void btnPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnUserAddressOnAction(ActionEvent event) {

    }

    @FXML
    void btnUsernameOnAction(ActionEvent event) {

    }

    @FXML
    void txtIdOnAction(KeyEvent event) {

    }

    @FXML
    void txtPriceOnAction(KeyEvent event) {

    }

    @FXML
    void txtQtyOnReleased(KeyEvent event) {

    }

    @FXML
    void txtTypeOnAction(KeyEvent event) {

    }

    @FXML
    void txttitleOnAction(KeyEvent event) {

    }

}
