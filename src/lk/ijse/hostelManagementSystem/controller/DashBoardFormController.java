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
        private JFXButton btnBooks;


        @FXML
        private JFXButton btnCustomer;



        @FXML
        private JFXButton btnBorrow;



        @FXML
        private JFXButton btnAttendance;


        @FXML
        private JFXButton btnReports;

        @FXML
        private AnchorPane pane;

        boolean bookManagementCL = true;
        boolean customerManagementCL = true;
        boolean borrowCL = true;
        boolean attendanceCL = true;
        boolean reportsCL = true;

        @FXML
        void btnGo1OnAction(ActionEvent event) throws IOException {
                setUi("/lk/ijse/hostelManagementSystem/view/RoomForm");
                loadCL();
                if (bookManagementCL) {
                        btnBooks.setStyle("-fx-background-color: #1620A1");
                        bookManagementCL = false;
                }
                bookManagementCL = true;
        }


        @FXML
        void btnGo3OnAction(ActionEvent event) throws IOException {
                setUi("/lk/ijse/hostelManagementSystem/view/StudentForm");
                loadCL();
                if (customerManagementCL) {
                        btnCustomer.setStyle("-fx-background-color: #1620A1");
                        customerManagementCL = false;
                }
                customerManagementCL = true;
        }



        @FXML
        void btnGo5OnAction(ActionEvent event) throws IOException {
                setUi("/lk/ijse/hostelManagementSystem/view/PaymentForm");
                loadCL();
                if (borrowCL) {
                        btnBorrow.setStyle("-fx-background-color: #1620A1");
                        borrowCL = false;
                }
                borrowCL = true;
        }


        @FXML
        void btnGo6OnAction(ActionEvent event) throws IOException {
                setUi("/lk/ijse/librarydb/view/attendanceManagement");
                loadCL();
                if (attendanceCL) {
                        btnAttendance.setStyle("-fx-background-color: #1620A1");
                        attendanceCL = false;
                }
                attendanceCL = true;

        }



        @FXML
        void btngo8OnAction(ActionEvent event) throws IOException {
                setUi("/lk/ijse/librarydb/view/reportForm");
                loadCL();
                if (reportsCL) {
                        btnReports.setStyle("-fx-background-color: #1620A1");
                        reportsCL = false;
                }
                reportsCL = true;

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
                btnBooks.setStyle("-fx-background-color: #05071F");
                bookManagementCL = true;
                btnCustomer.setStyle("-fx-background-color: #05071F");
                customerManagementCL = true;
                btnBorrow.setStyle("-fx-background-color: #05071F");
                borrowCL = true;
                btnAttendance.setStyle("-fx-background-color: #05071F");
                attendanceCL = true;
                btnReports.setStyle("-fx-background-color: #05071F");
                reportsCL = true;

        }
}
