/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcontroller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author ASUS
 */
public class BerandaKasirController implements Initializable{
    @FXML
    private JFXButton Keluar;
    @FXML
    private JFXButton KelolaDataPelanggan;
    @FXML
    private JFXButton BuatPesanan;
    @FXML
    private AnchorPane rootMainMenu;

    @FXML
    private JFXButton DetailPesanan;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void KelolaDataPelanggan(ActionEvent actionEvent){
        try {
            AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/view/KelolaDataPelanggan.fxml")));
            rootMainMenu.getChildren().setAll(parentContent);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void BuatPesanan (ActionEvent actionEvent){
        try {
            AnchorPane orderForm = FXMLLoader.load(getClass().getResource(("/view/KelolaPesan.fxml")));
            rootMainMenu.getChildren().setAll(orderForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void Keluar (ActionEvent actionEvent){
       try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/Masuk.fxml")));
            rootMainMenu.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void DetailPesanan (ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/DetailPesan.fxml")));
            rootMainMenu.getChildren().setAll(loginForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
