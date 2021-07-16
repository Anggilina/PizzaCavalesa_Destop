/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.PizzaController;
import model.PizzaTabelModel;
import model2.Pizza;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SHEHANKA
 */
public class MenuController implements Initializable {

    @FXML
    private JFXTextField txtpizza_Id;
    @FXML
    private JFXTextField txtpizza_nama;
    @FXML
    private JFXTextField txtdeskripsi;
    @FXML
    private JFXTextField txtharga;
    @FXML
    private JFXTextField txtpizza;
    @FXML
    private JFXButton btntambah;
    @FXML
    private JFXButton btnhapus;
    @FXML
    private JFXButton btncari;
    @FXML
    private JFXButton btnperbarui;
    @FXML
    private TableView tblPizza;
    @FXML
    private TableColumn tblpizza_Id;
    @FXML
    private TableColumn tblpizza_Nama;
    @FXML
    private TableColumn tbldeskripsi;
    @FXML
    private TableColumn tblharga;
    @FXML
    private TableColumn tbltipe_Pizza;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private JFXButton btnMainMenu; 
    @FXML
    private AnchorPane rootPizzaForm;

    private final ObservableList<PizzaTabelModel> data = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idGenerator();
        try {
            tblpizza_Id.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel, String>("pizza_Id"));
            tblpizza_Nama.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel, String>("pizza_Nama"));
            tbldeskripsi.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel, String>("Descripsi"));
            tblharga.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel,Integer>("harga"));
            tbltipe_Pizza.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel,Integer>("tipe_Pizza"));

            tblPizza.setItems(data);
            ArrayList<Pizza> pizzas = null;
            pizzas = PizzaController.getAllItem();
            for (Pizza pizza : pizzas) {
                PizzaTabelModel ctm = new PizzaTabelModel();
                ctm.setPizza_Id(pizza.getPizza_Id());
                ctm.setPizza_Nama(pizza.getPizza_Nama());
                ctm.setDescripsi(pizza.getDescripsi());
                ctm.setHarga(pizza.getHarga());
                ctm.setTipe_Pizza(pizza.getTipe_Pizza());

                data.add(ctm);
            
            
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PizzaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    


    @FXML
    private void btntambah(ActionEvent event) {
        try {
            String Pizza_id = txtpizza_Id.getText();
            String Pizza_nama = txtpizza_nama.getText();
            String Deskripsi=txtdeskripsi.getText();
            int Harga = Integer.parseInt(txtharga.getText());
            String Tipe_pizza=txtpizza.getText();
            
            Pizza c = new Pizza(Pizza_id,Pizza_nama,Harga,Deskripsi,Tipe_pizza);
            int i = PizzaController.addItem(c);
            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Pizza Tambah");
                alert.setHeaderText("Informasi");
                alert.setContentText("Menu Berhasil di tambah!!");
                alert.showAndWait();
                tblPizza.getItems().clear();
                tblPizza.refresh();
                refreshtbl();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Pizza Tambah");
                alert.setHeaderText("Informasi");
                alert.setContentText("Menu Gagal Ditambah");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PizzaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnhapus(ActionEvent event) {
        try {
            String Pizza_id = txtpizza_Id.getText();
            int deletePizza = PizzaController.deleteItem(Pizza_id);
            if (deletePizza > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Hapus Menu");
                alert.setHeaderText("Informasi");
                alert.setContentText("Menu Berhasil di Hapus!!");
                alert.showAndWait();
                tblPizza.refresh();
                refreshtbl();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Hapus Menu");
                alert.setHeaderText("Informasi");
                alert.setContentText("Menu gagal di Hapus");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PizzaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Cari(ActionEvent event) {
        try {
            String Pizza_id = txtpizza_Id.getText();
            Pizza c = PizzaController.searchItem(Pizza_id);
            if (c != null) {
                txtpizza_Id.setText(c.getPizza_Id());
                txtpizza_nama.setText(c.getPizza_Nama());
                txtharga.setText(c.getHarga() + "");
                txtdeskripsi.setText(c.getDescripsi());
                txtpizza.setText(c.getTipe_Pizza());
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Cari Menu");
                alert.setHeaderText("Informasi");
                alert.setContentText("Menu Tidak ditemukan");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PizzaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void refreshtbl(){
        try {
            tblpizza_Id.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel, String>("pizza_Id"));
            tblpizza_Nama.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel, String>("pizza_Nama"));
            tbldeskripsi.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel, String>("Descripsi"));
            tblharga.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel,Integer>("harga"));
            tbltipe_Pizza.setCellValueFactory(new PropertyValueFactory<PizzaTabelModel,Integer>("tipe_Pizza"));

            tblPizza.setItems(data);
            ArrayList<Pizza> pizzas = null;
            pizzas = PizzaController.getAllItem();
            for (Pizza pizza : pizzas) {
                PizzaTabelModel ctm = new PizzaTabelModel();
                ctm.setPizza_Id(pizza.getPizza_Id());
                ctm.setPizza_Nama(pizza.getPizza_Nama());
                ctm.setDescripsi(pizza.getDescripsi());
                ctm.setHarga(pizza.getHarga());
                ctm.setTipe_Pizza(pizza.getTipe_Pizza());

                data.add(ctm);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PizzaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnBeranda(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/BerandaAdmin.fxml")));
            rootPizzaForm.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnKeluar(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/Masuk.fxml")));
            rootPizzaForm.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void idGenerator(){
        try {
            txtpizza_Id.setText(lain.IDGenarator.getNewID("pizza","pizza_id","I"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
