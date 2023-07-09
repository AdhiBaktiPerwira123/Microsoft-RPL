package controller;

import java.io.IOException;

// import java.io.IOException;

// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Node;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;

// public class loginController {
//     @FXML
//     private void kembali(ActionEvent event) throws IOException {
//         Parent root = FXMLLoader.load(getClass().getResource("/View/Beranda.fxml"));
//         Scene scene = new Scene(root);
//         Stage stage = new Stage();
//         stage.setScene(scene);
//         stage.show();

//         Node source = (Node) event.getSource();
//         Stage oldStage = (Stage) source.getScene().getWindow();
//         oldStage.close();
//     }
// }


// import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.*;
// import javafx.stage.Stage;


// public class loginController extends Application {

//     @Override
//     public void start(Stage primaryStage) throws Exception {
//         // TODO Auto-generated method stub
//         ;
//     }

//     // @FXML
//     // private Button button;

//     // private TextField usernameField;
//     // private PasswordField passwordField;

//     // public static void main(String[] args) {
//     //     launch(args);
//     // }

//     // @Override
//     // public void start(Stage primaryStage) {
//     //     primaryStage.setTitle("Login App");

//     //     // Membuat form login
//     //     Label usernameLabel = new Label("Username:");
//     //     usernameField = new TextField();

//     //     Label passwordLabel = new Label("Password:");
//     //     passwordField = new PasswordField();

//     //     Button loginButton = new Button("Login");
//     //     loginButton.setOnAction(e -> handleLogin(e));

//     //     VBox loginForm = new VBox(10);
//     //     loginForm.setPadding(new Insets(20));
//     //     loginForm.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

//     //     primaryStage.setScene(new Scene(loginForm, 300, 200));
//     //     primaryStage.show();
//     // }

//     // @FXML
//     // private void handleLogin(ActionEvent event) {
//     //     String username = usernameField.getText();
//     //     String password = passwordField.getText();

//     //     if (username.equals("admin") && password.equals("admin123")) {
//     //         showAlert("Login Successful!", Alert.AlertType.INFORMATION);
//     //     } else {
//     //         showAlert("Invalid username or password", Alert.AlertType.ERROR);
//     //     }
//     // }

//     // private void showAlert(String message, Alert.AlertType alertType) {
//     //     Alert alert = new Alert(alertType);
//     //     alert.setTitle("Login Status");
//     //     alert.setHeaderText(null);
//     //     alert.setContentText(message);
//     //     alert.showAndWait();
//     // }
// }

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton; 

    

   

    @FXML
    private void handleLogin(ActionEvent event) throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validateLogin(username, password)) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Pilihan.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("username :" + username);
        System.out.println("password :" + password);
        } else {
            // Menampilkan pesan error jika login gagal
            
        }
    }
    @FXML
    private boolean validateLogin(String username, String password) {
        if ((username.equals("1")&& password.equals("1"))||(username.equals("akun")&&(password.equals("pass")))) {
            
            return true; // Contoh sederhana, selalu mengembalikan true
        } else {
            return false;
        }
    }


    
    @FXML
    private void kembali(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Beranda.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();
        oldStage.close();
    }
}
  

