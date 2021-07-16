package viewcontroller;

import com.jfoenix.controls.JFXDatePicker;
import controller.PesanController;
import model.RiwayatTableModel;
import model2.Riwayat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by SHEHANKA on 6/2/2017.
 */
public class DPesanControllerAdmin implements Initializable {

     @FXML
    private AnchorPane rootViewAllOrders;

    @FXML
    private TableView tblPesan;

    @FXML
    private TableColumn tblpesan_Id;

    @FXML
    private TableColumn tblcustomer_Id;

    @FXML
    private TableColumn tblcustomer_Nama;

    @FXML
    private TableColumn tblpizza_Nama;
    
    @FXML
    private TableColumn tbltanggal;

    @FXML
    private TableColumn tbljumlah;

    @FXML
    private TableColumn tblharga;
    
    @FXML
    private TableColumn tbltotal;

    @FXML
    private JFXDatePicker txttanggal;

    private final ObservableList<RiwayatTableModel> data= FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tblpesan_Id.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("pesan_Id"));
            tblcustomer_Id.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("customer_Id"));
            tblcustomer_Nama.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("customer_Nama"));
            tbltanggal.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("tanggal"));
            tblpizza_Nama.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("pizza_Nama"));
            tbljumlah.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,Integer>("jumlah"));
            tblharga.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,Integer>("harga"));
            tbltotal.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,Integer>("total"));

            tblPesan.setItems(data);
            ArrayList<Riwayat> viewAllOrders=null;
            viewAllOrders= PesanController.getAllOrders();
            for (Riwayat allOrder:viewAllOrders) {
                RiwayatTableModel RiwayatTableModel=new RiwayatTableModel();
                RiwayatTableModel.setPesan_Id(allOrder.getPesan_Id());
                RiwayatTableModel.setCustomer_Id(allOrder.getCustomer_Id());
                RiwayatTableModel.setCustomer_Nama(allOrder.getCustomer_Nama());
                RiwayatTableModel.setTanggal(allOrder.getTanggal());
                RiwayatTableModel.setPizza_Nama(allOrder.getPizza_Nama());
                RiwayatTableModel.setJumlah(allOrder.getJumlah());
                RiwayatTableModel.setHarga(allOrder.getHarga());
                RiwayatTableModel.setTotal(allOrder.getTotal());
                data.add(RiwayatTableModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    
    public void date(){
        tblPesan.refresh();
        LocalDate date =txttanggal.getValue();
            String order_Date=date.format(DateTimeFormatter.ISO_DATE);
        try {
            tblpesan_Id.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("pesan_Id"));
            tblcustomer_Id.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("customer_Id"));
            tblcustomer_Nama.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("customer_Nama"));
            tbltanggal.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("tanggal"));
            tblpizza_Nama.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,String>("pizza_Nama"));
            tbljumlah.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,Integer>("jumlah"));
            tblharga.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,Integer>("harga"));
            tbltotal.setCellValueFactory(new PropertyValueFactory<RiwayatTableModel,Integer>("total"));

            tblPesan.setItems(data);
            ArrayList<Riwayat> viewAllOrders=null;
            viewAllOrders= PesanController.getAllOrdersDate(order_Date);
            for (Riwayat allOrder:viewAllOrders) {
                RiwayatTableModel RiwayatTableModel=new RiwayatTableModel();
                RiwayatTableModel.setPesan_Id(allOrder.getPesan_Id());
                RiwayatTableModel.setCustomer_Id(allOrder.getCustomer_Id());
                RiwayatTableModel.setCustomer_Nama(allOrder.getCustomer_Nama());
                RiwayatTableModel.setTanggal(allOrder.getTanggal());
                RiwayatTableModel.setPizza_Nama(allOrder.getPizza_Nama());
                RiwayatTableModel.setJumlah(allOrder.getJumlah());
                RiwayatTableModel.setHarga(allOrder.getHarga());
                RiwayatTableModel.setTotal(allOrder.getTotal());
                data.add(RiwayatTableModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void btnKeluar(ActionEvent actionEvent){
       try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/Masuk.fxml")));
            rootViewAllOrders.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnBeranda(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/BerandaAdmin.fxml")));
            rootViewAllOrders.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
