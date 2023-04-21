package lk.ijse.hostelManagementSystem.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case ROOM:
                window.setTitle("Room Form");
                initUI("ManageRoomForm.fxml");
                break;
            case STUDENT:
                window.setTitle("Student Form");
                initUI("ManageStudentForm.fxml");
                break;
            case PAYMENT:
                window.setTitle("Payment Dashboard");
                initUI("FindKeyMoneyForm.fxml");
                break;
            case CATEGORY:
                window.setTitle("Category Form");
                initUI("categoryUpdate.fxml");
                break;
            case RESERVATION:
                window.setTitle("Category Form");
                initUI("ReservationForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();


        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/hostelManagementSystem/view/" + location)));
    }

//    public static void swatchNavigation(String link, ActionEvent event) throws IOException {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(Navigation.class.getResource("/lk/ijse/librarydb/view/categoryUpdate.fxml"));
//            Parent root1 = (Parent) fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setTitle("Category Window");
//            stage.setScene(new Scene(root1));
//            stage.show();

//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }

    }


