package Main;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author andhika
 */
public class OpenScene {
    private Pane halaman;

    public Pane getPane(String fileName) {
        try {
            URL fileHalaman = Ecoriver.class.getResource("/" + fileName + ".fxml");

            if (fileHalaman == null) {
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }

            halaman = FXMLLoader.load(fileHalaman);

        } catch (Exception e) {
            System.out.println("Tidak ditemukan halaman tersebut");
            if (e.getCause() != null) {
                e.getCause().printStackTrace();
            }
        }

        return halaman;
    }
}