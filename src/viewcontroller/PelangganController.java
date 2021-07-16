/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.CustomerController;
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
import model.CustomerTableModel;
import model2.Customer;
import java.sql.Connection;
import java.util.HashMap;
import javafx.scene.input.KeyEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class PelangganController implements Initializable {
     @FXML
    private JFXTextField txtTpno;
    @FXML
    private JFXTextField txtcustomer_Nama;
    @FXML
    private JFXTextField txtalamat;
    @FXML
    private JFXTextField txtemail;
    @FXML
    private TableView tblCustomer;
    @FXML
    private TableColumn tblcustomer_Id;
    @FXML
    private TableColumn tblcustomer_Nama;
    @FXML
    private TableColumn tblTpno;
    @FXML
    private TableColumn tblemail;
    @FXML
    private TableColumn tblalamat;
    @FXML
    private JFXButton btnKeluar;
    @FXML
    private JFXButton btnBeranda;
    @FXML
    private JFXTextField txtcustomer_Id;
    @FXML
    private AnchorPane rootCustomer;

    private final ObservableList<CustomerTableModel> data = FXCollections.observableArrayList();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idGenerator();
        txtcustomer_Id.requestFocus();
        try {
            tblcustomer_Id.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Id"));
            tblcustomer_Nama.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Nama"));
            tblTpno.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, Integer>("TpNo"));
            tblemail.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("email"));
            tblalamat.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("alamat"));

            tblCustomer.setItems(data);
            ArrayList<Customer> customers = null;
            customers= CustomerController.getAllCustomer();
            for (Customer customer : customers) {
                CustomerTableModel ctm = new CustomerTableModel();
                ctm.setCustomer_Id(customer.getCustomer_Id());
                ctm.setCustomer_Nama(customer.getCustomer_Nama());
                ctm.setTpNo(customer.getTpNo());
                ctm.setAlamat(customer.getAlamat());
                ctm.setEmail(customer.getEmail());

                data.add(ctm);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void Tambah(ActionEvent event) {
        try {
            String customer_Id = txtcustomer_Id.getText();
            String customer_Nama = txtcustomer_Nama.getText();
            int Tpno = Integer.parseInt(txtTpno.getText());
            String alamat = txtalamat.getText();
            String email = txtemail.getText();

            Customer c = new Customer(customer_Id,customer_Nama,Tpno,email,alamat);
            int i = CustomerController.insertCustomer(c);
            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Tambah Pelanggan");
                alert.setHeaderText("Ini adalah informasi");
                alert.setContentText("Berhasil Menambah Pelanggan!!");
                alert.showAndWait();
                tblCustomer.refresh();
                refreshtbl();
                //refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Tambah Pelanggan");
                alert.setHeaderText("Ini adalah informasi");
                alert.setContentText("Tidak Berhasil Menambah Pelanggan ");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void Hapus(ActionEvent event) {
        try {
            String customer_Id = txtcustomer_Id.getText();
            int deleteCustomer = CustomerController.deleteCustomer(customer_Id);
            if (deleteCustomer > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Hapus Pelanggan");
                alert.setHeaderText("Informasi");
                alert.setContentText("Pelanggan berhasil dihapus!!");
                alert.showAndWait();
                tblCustomer.refresh();
                refreshtbl();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Hapus Pelanggan");
                alert.setHeaderText("Informasi");
                alert.setContentText("Pelanggan tidak berhasil dihapus");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void Cari(ActionEvent event) {
        try {
            String customer_Id = txtcustomer_Id.getText();
            Customer c = CustomerController.searchCustomer2(customer_Id);
            if (c != null) {
                txtcustomer_Id.setText(c.getCustomer_Id());
                txtcustomer_Nama.setText(c.getCustomer_Nama());
                txtTpno.setText(c.getTpNo() + "");
                txtemail.setText(c.getEmail());
                txtalamat.setText(c.getAlamat());

            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cari Pelanggan");
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setHeaderText("Salah!!");
                alert.setContentText("Pelanggan Tidak Ditemukan");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    private void refreshtbl() {
        try {
            tblcustomer_Id.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Id"));
            tblcustomer_Nama.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("customer_Nama"));
            tblTpno.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, Integer>("TpNo"));
            tblemail.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("email"));
            tblalamat.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("alamat"));

            tblCustomer.setItems(data);
            ArrayList<Customer> customers = null;
            customers = CustomerController.getAllCustomer();
            for (Customer customer : customers) {
                CustomerTableModel ctm = new CustomerTableModel();
                ctm.setCustomer_Id(customer.getCustomer_Id());
                ctm.setCustomer_Nama(customer.getCustomer_Nama());
                ctm.setTpNo(customer.getTpNo());
                ctm.setAlamat(customer.getAlamat());
                ctm.setEmail(customer.getEmail());

                data.add(ctm);

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnKeluar(ActionEvent actionEvent){
       try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/Masuk.fxml")));
            rootCustomer.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnBeranda(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/BerandaKasir.fxml")));
            rootCustomer.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void idGenerator(){
        try {
            txtcustomer_Id.setText(lain.IDGenarator.getNewID("customer","customer_id","C"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
