package viewcontroller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RiwayatController implements Initializable {

    @FXML
    private AnchorPane rootSummeryForm;

    @FXML
    private JFXButton btnTopMovingItems;

    @FXML
    private JFXButton btnTopCustomers;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnMainMenu;
    
    @FXML
    private JFXButton BtnDetailPesan;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/Masuk.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void btnMainMenu(ActionEvent event) {
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/BerandaAdmin.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void setBtnTopMovingItems(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/MenuTerlaku.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void setBtnTopCustomers(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/PelangganTerbaik.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void setBtnDetailPesan(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/DetailPesanAdmin.fxml")));
            rootSummeryForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
