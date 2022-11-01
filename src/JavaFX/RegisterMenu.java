/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFX;

import javax.swing.event.ChangeListener;

import Users.Users;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Class que representa o menu de registro.
 * 
 * @author henri
 */
public class RegisterMenu extends VBox {

    private Users users;
    private ComboBox<String> type;

    /**
     * Constroí um menu de registro.
     * Inicializa os users, coloca um padding de 5 e vai chamar o método show().
     * 
     */
    public RegisterMenu() {
        users = new Users();
        setPadding(new Insets(5));
        show();
    }

    /**
     * Método privado que vai criar toda a interface do menu de registro.
     * 
     */
    private void show() {

        HBox menuLabelBox = new HBox();
        menuLabelBox.setAlignment(Pos.CENTER);
        menuLabelBox.setPadding(new Insets(10));

        Label menuLabel = new Label("Register Menu");
        menuLabel.setStyle("-fx-font-weight: bold");
        menuLabel.setFont(new Font("Arial", 25));
        menuLabel.setTextFill(Color.NAVY);
        menuLabel.setAlignment(Pos.CENTER);

        menuLabelBox.getChildren().add(menuLabel);

        // -----------------------------------------------------------------------------------------------------------------

        GridPane main = new GridPane();
        main.setAlignment(Pos.CENTER);

        VBox v1 = new VBox();

        Label nameLabel = new Label("Username");
        nameLabel.setStyle("-fx-font-weight: bold");
        nameLabel.setFont(new Font("Arial", 12));

        Label passwordLabel = new Label("Password");
        passwordLabel.setStyle("-fx-font-weight: bold");
        passwordLabel.setFont(new Font("Arial", 12));

        Label nifLabel = new Label("NIF");
        nifLabel.setStyle("-fx-font-weight: bold");
        nifLabel.setFont(new Font("Arial", 12));

        Label dateLabel = new Label("Date Of Birth");
        dateLabel.setStyle("-fx-font-weight: bold");
        dateLabel.setFont(new Font("Arial", 12));

        Label typeLabel = new Label("Type");
        typeLabel.setStyle("-fx-font-weight: bold");
        typeLabel.setFont(new Font("Arial", 12));

        v1.setSpacing(20);
        v1.setAlignment(Pos.CENTER);
        v1.setPadding(new Insets(7));
        v1.getChildren().addAll(nameLabel, passwordLabel, nifLabel, dateLabel, typeLabel);

        // ----------------------------------------------------------------------------------------------------------------------

        VBox v2 = new VBox();

        TextField name = new TextField();
        name.setPromptText("username");
        name.setMinWidth(190);

        TextField nif = new TextField();

        int max = 9;
        nif.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > max) {
                String copy = nif.getText().substring(0, max);
                nif.setText(copy);
            }

        });

        nif.setPromptText("NIF");
        nif.setMinWidth(190);

        DatePicker dateOfBirth = new DatePicker();
        dateOfBirth.setEditable(false);
        dateOfBirth.setMinWidth(190);

        this.type = new ComboBox<>();
        type.getItems().addAll(
                "Admin",
                "Manager",
                "User");
        type.setPromptText("What's your account type?");
        type.setMinWidth(190);

        TextField password = new PasswordField();
        password.setPromptText("password");
        password.setMinWidth(190);

        v2.setSpacing(10);
        v2.setAlignment(Pos.CENTER);
        v2.setPadding(new Insets(10));
        v2.getChildren().addAll(name, password, nif, dateOfBirth, type);

        // ----------------------------------------------------------------------------------------------------------------------------------

        VBox registerBox = new VBox();
        registerBox.setAlignment(Pos.CENTER);

        Button registerButton = new Button("Register");
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (name.getText().isBlank() || name.getText().isEmpty() || nif.getText().isBlank()
                        || nif.getText().isEmpty() || dateOfBirth.getValue() == null
                        || type.getValue() == null || password.getText().isBlank() || password.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Data");
                    alert.setHeaderText("Invalid Data!");
                    alert.setContentText("Please try again!");
                    alert.showAndWait();
                    name.clear();
                    nif.clear();
                    dateOfBirth.setValue(null);
                    resetType(v2);
                    password.clear();
                } else {
                    if (users.existUserByCCNumber(nif.getText())) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("User already exists");
                        alert.setHeaderText("User already exists!");
                        alert.setContentText("Please try again!");
                        alert.showAndWait();
                        name.clear();
                        nif.clear();
                        dateOfBirth.setValue(null);
                        resetType(v2);
                        password.clear();
                    } else {
                        try {
                            String typeS = (String) type.getValue();
                            users.addUser(name.getText(), nif.getText(), dateOfBirth.getValue(), typeS,
                                    password.getText());
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("User Registration Successful");
                            alert.setHeaderText("User Registration Successful!");
                            alert.setContentText("You can now login!");
                            alert.showAndWait();
                            name.clear();
                            nif.clear();
                            dateOfBirth.setValue(null);
                            resetType(v2);
                            password.clear();
                        } catch (IllegalArgumentException e) {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Invalid Data");
                            alert.setHeaderText("Invalid Data!");
                            alert.setContentText("Please try again!");
                            alert.showAndWait();
                            name.clear();
                            nif.clear();
                            dateOfBirth.setValue(null);
                            resetType(v2);
                            password.clear();
                        }
                    }
                }
            }
        });

        registerBox.getChildren().add(registerButton);

        // -----------------------------------------------------------------------------------------------------------------------------------

        HBox loginBox = new HBox();
        loginBox.setPadding(new Insets(5));
        loginBox.setSpacing(10);
        loginBox.setAlignment(Pos.CENTER);

        Label loginLabel = new Label("Already have an account?");
        loginLabel.setFont(new Font("Arial", 12));
        loginLabel.setStyle("-fx-font-weight: bold");
        loginLabel.setAlignment(Pos.CENTER);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                Scene scene = new Scene(new LoginMenu(users), 300, 180);
                stage.setTitle("Login Menu");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        });

        loginBox.getChildren().addAll(loginLabel, loginButton);

        main.addColumn(0, v1);
        main.addColumn(1, v2);

        getChildren().add(menuLabelBox);
        getChildren().add(main);
        getChildren().add(registerBox);
        getChildren().add(loginBox);
        setStyle("-fx-background-color: #F5F6FA;");
    }

    /**
     * Método privado que vai dar reset à ComboBox dos tips de utilizador.
     * 
     * @param v2 VBox
     */
    private void resetType(VBox v2) {

        v2.getChildren().remove(this.type);

        this.type = null;
        this.type = new ComboBox<>();
        type.getItems().addAll(
                "Admin",
                "Manager",
                "User");
        type.setPromptText("What's your account type?");
        type.setMinWidth(190);

        v2.getChildren().add(type);
    }
}