package ir.teherany.controller;

import ir.teherany.entity.Person;
import ir.teherany.model.service.PersonServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonController implements Initializable {
    @FXML private Button btnSave;
    @FXML private TextField txtName;
    @FXML private TextField txtFamily;
    @FXML private TextField txtAge;
    @FXML private TextField txtNational;

    public void save(String name, String family, Integer age, String nationalCode) {
        try {
            Person person = null;
            if (name.length() != 0 && family.length() != 0) {
                person = new Person(name, family, age, nationalCode);
            }
            PersonServiceImpl.getInstance().save(person);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String nameText = txtName.getText();
                String familyText = txtFamily.getText();
                String ageText = txtAge.getText();
                String nationalText = txtNational.getText();
                save(nameText, familyText, Integer.valueOf(ageText),nationalText);
            }
        });
    }
}
