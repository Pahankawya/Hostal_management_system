package lk.ijse.hostelManagementSystem.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


public class UILoader {

    public static void LoginOnAction(AnchorPane anchorPane, String location) throws IOException, SQLException {

        Stage window = (Stage) anchorPane.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(UILoader.class.getResource("/lk/ijse/hostelManagementSystem/view" + location + ".fxml")))));
    }


    }

