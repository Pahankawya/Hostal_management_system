package lk.ijse.hostelManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UserLoginFormController {

    @FXML
    private AnchorPane mainAdmin2;

    @FXML
    private PasswordField passwordHidden;

    @FXML
    private TextField passwordText;

    @FXML
    private CheckBox checkBox;

    @FXML
    void changeVisibility(ActionEvent event) {
        if (checkBox.isSelected()) {
            passwordText.setText(passwordHidden.getText());
            passwordText.setVisible(true);
            passwordHidden.setVisible(false);
            return;
        }
        passwordHidden.setText(passwordText.getText());
        passwordHidden.setVisible(true);
        passwordText.setVisible(false);
    }

    @FXML
    void goBack(ActionEvent event) {

    }

    @FXML
    void gofoward1(ActionEvent event) {

    }

}
