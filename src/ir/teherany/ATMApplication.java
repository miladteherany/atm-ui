package ir.teherany;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ATMApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ATMApplication.class.getResource("view/MainFrame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 240);
        stage.setTitle("Welcome to ATM!");
        stage.setScene(scene);
        stage.show();
    }
}