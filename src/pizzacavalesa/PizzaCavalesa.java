/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzacavalesa;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class PizzaCavalesa extends Application{

    /**
     * @param args the command line arguments
     */
    
      public static boolean isSplashLoaded =false;
        public void start(Stage primaryStage)throws Exception{
            Parent root=FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
            Scene scene =new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Manajemen Sistem Pizza Cavalesa");
            primaryStage.show();
        }
        public static void main(String[] args) {
           launch(args);
        }
    }
    