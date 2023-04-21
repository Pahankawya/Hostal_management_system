package lk.ijse.hostelManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.UserBO;
import lk.ijse.hostelManagementSystem.dto.LoginDTO;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import lk.ijse.hostelManagementSystem.util.NotificationController;
import lk.ijse.hostelManagementSystem.util.UILoader;
import org.controlsfx.control.Notifications;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserLoginFormController {

    @FXML
    private AnchorPane mainAdmin2;

    @FXML
    private TextField UserName_Id;

    @FXML
    private PasswordField Pasword_Id;

    @FXML
    private TextField passwordText;

    @FXML
    private CheckBox checkBox;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnback;

    @FXML
    private Label warningmsgLbl;
    int attempts = 0;
    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    @FXML
    void changeVisibility(ActionEvent event) {
        if (checkBox.isSelected()) {
            passwordText.setText(Pasword_Id.getText());
            passwordText.setVisible(true);
            Pasword_Id.setVisible(false);
            return;
        }
        Pasword_Id.setText(passwordText.getText());
        Pasword_Id.setVisible(true);
        passwordText.setVisible(false);
    }

    @FXML
    void goBack(ActionEvent event) {
        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.close();
    }

    @FXML
    void LoggingOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {


            NotificationController.LoginUnSuccessfulNotification("admin");
            ArrayList<LoginDTO> loginDTOS = userBO.getAllUsers();
            attempts++;
            loginDTOS.forEach(e -> {
                if (attempts <= 3) {
                    if (e.getUserID().equals(UserName_Id.getText()) && e.getPassword().equals(Pasword_Id.getText())) {
                        try {
                            Stage stage = (Stage) mainAdmin2.getScene().getWindow();
                            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/DashBoardForm.fxml"))));
                            stage.centerOnScreen();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {

                    }
                } else {
                    UserName_Id.setEditable(false);
                    Pasword_Id.setEditable(false);
                    NotificationController.LoginUnSuccessfulNotification("Account is Temporarily Disabled or You Did not Sign in Correctly.");
                }
            });

        }

    @FXML
    void passwordOnAction(ActionEvent event) {

    }

    @FXML
    void userNameOnAction(ActionEvent event) {

    }



}
