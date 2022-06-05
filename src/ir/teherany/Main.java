package ir.teherany;

import ir.teherany.common.JDBC;
import ir.teherany.controller.PersonController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {
    public static void main(String[] args) {
        Main.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("view/Frame1.fxml"));
        stage.setTitle("Welcome to ATM");
        stage.setScene(new Scene(parent, 300, 275));
        stage.show();
    }
}
