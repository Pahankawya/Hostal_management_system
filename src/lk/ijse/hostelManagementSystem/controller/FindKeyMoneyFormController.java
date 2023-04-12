package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FindKeyMoneyFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXButton btnsearch;

    @FXML
    private TableView<?> tbl;

    @FXML
    private TableColumn<?, ?> tblReserveID;

    @FXML
    private TableColumn<?, ?> tblStudendID;

    @FXML
    private TableColumn<?, ?> tblRoomID;

    @FXML
    private TableColumn<?, ?> tblDate;

    @FXML
    private TableColumn<?, ?> tblKeyMoney;

    @FXML
    private TableColumn<?, ?> tblAdvanced;

    @FXML
    private TableColumn<?, ?> tblStatus;

    @FXML
    private TextField txtID1;

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
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void searchOnAction(ActionEvent event) {

    }

}
