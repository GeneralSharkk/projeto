/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFX;


import Users.UserType;
import Users.Users;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
 *  Class que representa o menu de login.
 * 
 * @author henri
 */
public class LoginMenu extends VBox{
    
    private Users users;
    
    /**
     * Constroí um menu de login.
     * Inicializa os users com o Users que recebe, coloca um padding de 10 e vai chamar o método show().
     * 
     * @param users users
     */
    public LoginMenu(Users users){
        this.users = users;
        setPadding(new Insets(10));
        show();
    }
    
    /**
     * Método privado que vai criar toda a interface do menu de login.
     * 
     */
    private void show(){
        
        HBox menuLabelBox = new HBox();
        menuLabelBox.setAlignment(Pos.CENTER);
        menuLabelBox.setPadding(new Insets(10));
        
        Label menuLabel = new Label("Login Menu");
        menuLabel.setStyle("-fx-font-weight: bold");
        menuLabel.setFont(new Font("Arial", 25));
        menuLabel.setTextFill(Color.NAVY);
        menuLabel.setAlignment(Pos.CENTER);
        
        menuLabelBox.getChildren().add(menuLabel);
        
        //-----------------------------------------------------------------------------------------------------------------
        
        GridPane main = new GridPane();
        main.setAlignment(Pos.CENTER);
        
        VBox v1 = new VBox();
        
        Label nameLabel = new Label("Username");
        nameLabel.setStyle("-fx-font-weight: bold");
        nameLabel.setFont(new Font("Arial", 12));
        
        Label passwordLabel = new Label("Password");
        passwordLabel.setStyle("-fx-font-weight: bold");
        passwordLabel.setFont(new Font("Arial", 12));
        
        v1.setSpacing(20);
        v1.setAlignment(Pos.CENTER);
        v1.setPadding(new Insets(7));
        v1.getChildren().addAll(nameLabel, passwordLabel);
        
        
        
        //----------------------------------------------------------------------------------------------------------------------
        
        VBox v2 = new VBox();
        
        TextField name = new TextField();
        name.setPromptText("username");
        
        TextField password = new PasswordField();
        password.setPromptText("password");

        v2.setSpacing(10);
        v2.setAlignment(Pos.CENTER);
        v2.setPadding(new Insets(5));
        v2.getChildren().addAll(name, password);
        
        //----------------------------------------------------------------------------------------------------------------------------------
        
        VBox loginBox = new VBox();
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(5));
        
        Button loginButton = new Button("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if(name.getText().isBlank() || name.getText().isEmpty() || password.getText().isBlank() || password.getText().isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Data");
                    alert.setHeaderText("Invalid Data!");
                    alert.setContentText("Please try again!");
                    alert.showAndWait();
                    name.clear();
                    password.clear();
                }else{
                    if(!users.existUserLogin(name.getText(), password.getText())){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("User doesn't exist");
                        alert.setHeaderText("User doesn't exist!");
                        alert.setContentText("Please try again!");
                        alert.showAndWait();
                        name.clear();
                        password.clear();
                    }else{
                        UserType type = users.getUserType(name.getText(), password.getText());
                        if(type.equals(UserType.ADMIN)){
                            Stage stage = new Stage();
                            
                            VBox vbox = new VBox();
                            vbox.setAlignment(Pos.CENTER);
                            vbox.setPadding(new Insets(25));
                            
                            HBox hbox = new HBox();
                            Label label = new Label("Welcome " + UserType.ADMIN.toString() + " " + name.getText() + "!");
                            label.setStyle("-fx-font-weight: bold");
                            label.setFont(new Font("Arial", 25));
                            label.setTextFill(Color.NAVY);
                            label.setAlignment(Pos.CENTER);
                            hbox.setAlignment(Pos.CENTER);
                            hbox.getChildren().add(label);
                            
                            vbox.getChildren().addAll(hbox, new AdminMenu());
                            
                            Scene scene = new Scene(vbox, 835, 240);
                            stage.setTitle("Admin Menu");
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                        }
                        if(type.equals(UserType.MANAGER)){
                            Stage stage = new Stage();
                            
                            VBox vbox = new VBox();
                            vbox.setAlignment(Pos.CENTER);
                            vbox.setPadding(new Insets(30));
                            
                            HBox hbox = new HBox();
                            Label label = new Label("Welcome " + UserType.MANAGER.toString() + " " + name.getText() + "!");
                            label.setStyle("-fx-font-weight: bold");
                            label.setFont(new Font("Arial", 25));
                            label.setTextFill(Color.NAVY);
                            label.setAlignment(Pos.CENTER);
                            hbox.setAlignment(Pos.CENTER);
                            hbox.getChildren().add(label);
                            
                            vbox.getChildren().addAll(hbox, new ManagerMenu());
                            
                            Scene scene = new Scene(vbox, 655, 180);
                            stage.setTitle("Manager Menu");
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                        }
                        if(type.equals(UserType.USER)){
                            Stage stage = new Stage();
                            
                            VBox vbox = new VBox();
                            vbox.setAlignment(Pos.CENTER);
                            vbox.setPadding(new Insets(25));
                            
                            HBox hbox = new HBox();
                            Label label = new Label("Welcome " + UserType.USER.toString() + " " + name.getText() + "!");
                            label.setStyle("-fx-font-weight: bold");
                            label.setFont(new Font("Arial", 25));
                            label.setTextFill(Color.NAVY);
                            label.setAlignment(Pos.CENTER);
                            hbox.setAlignment(Pos.CENTER);
                            hbox.getChildren().add(label);
                            
                            vbox.getChildren().addAll(hbox, new UserMenu());
                            
                            Scene scene = new Scene(vbox, 630, 140);
                            stage.setTitle("User Menu");
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                        }
                    }  
                }
            }  
        });
        
        loginBox.getChildren().add(loginButton);
        
        main.addColumn(0, v1);
        main.addColumn(1, v2);
        
        getChildren().add(menuLabelBox);
        getChildren().add(main);
        getChildren().add(loginBox);
        setStyle("-fx-background-color: #F5F6FA;");
    }
}
