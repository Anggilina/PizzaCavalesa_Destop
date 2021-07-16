/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.AdminController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author user
 */
public class MasukController {
    @FXML
    private AnchorPane rootLogin;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnLogin;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void btnLoginAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        String userName=txtUserName.getText();
        String password=txtPassword.getText();
        boolean bool=AdminController.Login(userName, password);
        
        try {
            AnchorPane mainMenu = FXMLLoader.load(getClass().getResource("/view/BerandaKasir.fxml"));
            AnchorPane mainMenuAdmin = FXMLLoader.load(getClass().getResource("/view/BerandaAdmin.fxml"));
            if(bool){ 
               
                boolean type=AdminController.AccountType(userName);
               if(type){
                rootLogin.getChildren().setAll(mainMenuAdmin);
               }else{
                rootLogin.getChildren().setAll(mainMenu);
               }
           }else{
               Alert alert=new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Gagal Masuk !");
               alert.setHeaderText("Gagal Masuk!");
               alert.setContentText("Username/Password ada yang salah");
               
               alert.showAndWait();
               System.out.println("Wrong login details");
           }  
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }
}
