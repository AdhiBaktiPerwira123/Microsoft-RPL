
package controller;

import static javafx.collections.FXCollections.observableArrayList;

import java.io.DataInput;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import Model.BerandaDLH;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Model.BerandaDLH;

public class BerandaDLHController implements Initializable {

    ArrayList<BerandaDLH> Data = new ArrayList<>();
    XStream xST = new XStream(new StaxDriver());

    void bukaXML() {
        FileInputStream input = null;
        xST.addPermission(AnyTypePermission.ANY);
        xST.allowTypesByWildcard(new String[] { "Model.BerandaDLH" });
        try {
            input = new FileInputStream("BerandaDLH.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1) {
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            Data = (ArrayList<BerandaDLH>) xST.fromXML(stringnya);
        } catch (Exception e) {
            System.err.println("test: " + e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // ObservableList data = observableArrayList();
    ObservableList<BerandaDLH> data = observableArrayList();

    @FXML
    private TableView History;

    @FXML
    private TextField buatSungai;

    @FXML
    private TextField buatPencemaran;

    @FXML
    private TableColumn<BerandaDLH, String> sgSungai;

    @FXML
    private TableColumn<BerandaDLH, String>  sgPencemaran;

    // @FXML
    // private void tombolKebenaran(ActionEvent event) {
    // String Temp1 = buatSungai.getText();
    // String Temp2 = buatPencemaran.getText();

    // data.add(new BerandaDLH(Temp1, Temp2));
    // buatSungai.setText("");
    // buatPencemaran.setText("");

    // }

    // @FXML
    // private void tombolKebenaran(ActionEvent event) {
        // String Temp1 = buatSungai.getText();
        // String Temp2 = buatPencemaran.getText();

        // Data.add(new BerandaDLH(Temp1, Temp2));
        // buatSungai.setText("");
        // buatPencemaran.setText("");

        // String Sungai = buatSungai.getText();
        // String Pencemaran = buatPencemaran.getText();

        // BerandaDLH stockMakan = new BerandaDLH(
        //         Sungai.toString(),
        //         Pencemaran.toString());

    //     BerandaDLH di = new BerandaDLH(Sungai, Pencemaran);
    //     data.add(di);

    //     buatSungai.setText("");
    //     buatPencemaran.setText("");

    //     String xml = xST.toXML(Data);
    //     FileOutputStream output = null;
    //     try {
    //         output = new FileOutputStream("BerandaDLH.xml");
    //         byte[] bytes = xml.getBytes("UTF-8");
    //         output.write(bytes);
    //     } catch (Exception e) {
    //         System.err.println("Perhatian: " + e.getMessage());
    //     } finally {
    //         if (output != null) {
    //             try {
    //                 output.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }

    // }

    // public void start(Stage stage) throws Exception {
    //     Parent root = FXMLLoader.load(getClass().getResource("/View/Pilihan.fxml"));

    //     Scene scene = new Scene(root);

    //     stage.setScene(scene);
    //     stage.show();
    // }

    @FXML
    private void kembali(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Pilihan.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void tombolKebenaran(ActionEvent event) {
    String Sungai = buatSungai.getText();
    String Pencemaran = buatPencemaran.getText();

    BerandaDLH stockMakan = new BerandaDLH(Sungai.toString(), Pencemaran.toString());
    Data.add(stockMakan);

    // Menyimpan data ke file XML
    String xml = xST.toXML(Data);
    FileOutputStream output = null;
    try {
        output = new FileOutputStream("BerandaDLH.xml");
        byte[] bytes = xml.getBytes("UTF-8");
        output.write(bytes);
    } catch (Exception e) {
        System.err.println("Perhatian: " + e.getMessage());
    } finally {
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Membersihkan inputan teks
    buatSungai.setText("");
    buatPencemaran.setText("");

    History.refresh();
}


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
        for (int i = 0; i < Data.size(); i++) {
            BerandaDLH sm =  Data.get(i);
            // BerandaDLH di = new BerandaDLH(sm.getSungai(), sm.getPencemaran());
            data.add(sm);
        }
        sgSungai.setCellValueFactory(new PropertyValueFactory<BerandaDLH, String>("Sungai"));
        sgPencemaran.setCellValueFactory(new PropertyValueFactory<BerandaDLH, String>("Pencemaran"));
        History.setItems(data);

    }

}
