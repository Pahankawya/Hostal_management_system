package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class DashBoardFormController {
        @FXML
        private JFXButton btnUser;

        @FXML
        private JFXButton btnStudent;

        @FXML
        private JFXButton btnRooms;

        @FXML
        private JFXButton btnKeymoney;

        @FXML
        private AnchorPane pane;

        boolean StudentManagement = true;
        boolean RoomManagement = true;
        boolean keyMoney = true;
        boolean UserManagement = true;

        @FXML
        void btnGo1OnAction(ActionEvent event) throws IOException {
                setUi("/lk/ijse/hostelManagementSystem/view/ManageStudentForm");
                loadCL();
                if (StudentManagement) {
                        btnStudent.setStyle("-fx-background-color: #1620A1");
                        StudentManagement = false;
                }
                StudentManagement = true;
        }


        @FXML
        void btnGo3OnAction(ActionEvent event) throws IOException {
                setUi("/lk/ijse/hostelManagementSystem/view/ManageRoomForm");
                loadCL();
                if (RoomManagement) {
                        btnRooms.setStyle("-fx-background-color: #1620A1");
                        RoomManagement = false;
                }
                RoomManagement = true;
        }



        @FXML
        void btnGo5OnAction(ActionEvent event) throws IOException {
                setUi("/lk/ijse/hostelManagementSystem/view/PaymentForm");
                loadCL();
                if (keyMoney) {
                        btnKeymoney.setStyle("-fx-background-color: #1620A1");
                        keyMoney = false;
                }
                keyMoney = true;
        }






        @FXML
        void btngo8OnAction(ActionEvent event) throws IOException {
                setUi("/lk/ijse/hostelManagementSystem/view/ManageUserForm");
                loadCL();
                if (UserManagement) {
                        btnUser.setStyle("-fx-background-color: #1620A1");
                        UserManagement = false;
                }
                UserManagement = true;

        }


        @FXML
        void goBackOnAction(ActionEvent event) throws IOException {
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/UserLoginForm.fxml"))));
                stage.centerOnScreen();
                Notifications notificationsBuilder = Notifications.create()
                        .title("Logging out!")
                        .text("Successfully Logged out!!")
                        .graphic(null)
                        .hideAfter(Duration.seconds(8))
                        .position(Pos.BOTTOM_RIGHT);
                notificationsBuilder.showError();

        }

        private void setUi(String ui) throws IOException {
                Parent load = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
                pane.getChildren().clear();
                pane.getChildren().add(load);
        }

        public void loadCL() {
                btnStudent.setStyle("-fx-background-color: #05071F");
                StudentManagement = true;
                btnRooms.setStyle("-fx-background-color: #05071F");
                RoomManagement = true;
                btnKeymoney.setStyle("-fx-background-color: #05071F");
                keyMoney = true;
                btnUser.setStyle("-fx-background-color: #05071F");
                UserManagement = true;

        }
}
