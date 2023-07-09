package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class BerandaMasyarakat implements Initializable {
    @FXML
   private BorderPane mainPane;
    @FXML
    private Button button;


    @FXML
    private void kembali1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Beranda.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();
        oldStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
       
    }
}
