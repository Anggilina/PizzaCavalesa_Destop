package viewcontroller;
import koneksi.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import controller.CustomerController;
import controller.PesanController;
import controller.PizzaController;
import model.PesanTableModel;
import model2.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KelolahPesanController implements Initializable {

    @FXML
    private JFXTextField txtcustomer_Id;
    
    @FXML
    private JFXTextField txtTpno;
    
    @FXML
    private JFXTextField txtcustomer_Nama;
    
    @FXML
    private JFXTextField txtalamat;
   
    @FXML
    private JFXTextField txtemail;
    
    @FXML
    private JFXButton btnCari;
    
    @FXML
    private JFXButton btnKeluar;
    
    @FXML
    private JFXButton btnBeranda;
    
    @FXML
    private JFXButton btnCariItem;
    
    @FXML
    private JFXTextField txtpizza_Id;
    @FXML
    private JFXTextField txtpizza_Nama;
    @FXML
    private JFXTextField txtdeskripsi;
    @FXML
    private JFXTextField txtharga;
    
    @FXML
    private JFXTextField txtJumlah;
    
    @FXML
    private JFXButton btnAddItem;
    
    @FXML
    private JFXButton btntambah;
    
    @FXML
    private JFXButton btnRemoveItem;
    
    @FXML
    private JFXButton btnCustomized;
    
    @FXML
    private JFXComboBox cbxDiscount;
    
    @FXML
    private Text lblSubTotal;
    
    @FXML
    private TableView tblPesan;

    @FXML
    private TableColumn tblCode;

    @FXML
    private TableColumn tblPizza_Nama;

    @FXML
    private TableColumn tblHarga;

    @FXML
    private TableColumn tblJumlah;

    @FXML
    private TableColumn tblSubTotal;
    
    @FXML
    private AnchorPane rootOrderForm;
    
    @FXML
    private Text lblTotal;
    
    @FXML
    private Text lblKembalian;
    
    @FXML
    private JFXTextField txtOID;
    
    @FXML
    private JFXTextField txtUang;
    
    @FXML
    private JFXDatePicker txtODate;
    
    private int total;
    
    private int subjumlah;
    
    private String customized_Amount;
    
    private int order_Discount;
    
    private int discountAmount;
    
    private final ObservableList<PesanTableModel> data = FXCollections.observableArrayList();

    public ArrayList<PesanDetail> orderDetailList=new ArrayList<>();
    
      
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idGenerator();
        idGeneratorCustomer();
        total=0;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
//        System.out.println(dateFormat.format(date));
        String todayDate=dateFormat.format(date);
        //txtODate.setValue(LocalDate.parse(todayDate));
    }
    
    @FXML
    private void addCustomer(ActionEvent event) {
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
                alert.setTitle("Customer Pelanggan");
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
    
    
    
    @FXML
    private void CariItem(ActionEvent event) {
        try {
            String Pizza_id = txtpizza_Id.getText();
            Pizza c = PizzaController.searchItem(Pizza_id);
            if (c != null) {
                txtpizza_Id.setText(c.getPizza_Id());
                txtpizza_Nama.setText(c.getPizza_Nama());
                txtdeskripsi.setText(c.getDescripsi());
                txtharga.setText(c.getHarga() + "");
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Cari Pizza");
                alert.setHeaderText("Salah");
                alert.setContentText("Pizza Tidak Ditemukan");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PizzaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/Masuk.fxml")));
            rootOrderForm.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/BerandaKasir.fxml")));
            rootOrderForm.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
     @FXML
    private void setKembalian(ActionEvent actionEvent){
        try{
            int total1=Integer.parseInt(lblTotal.getText());
            int uang=Integer.parseInt(txtUang.getText());
            int kembalian=(int) (uang-total1);
        
            lblKembalian.setText(""+kembalian);
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    
    private void comboBoxDiscount(){
        cbxDiscount.getItems().addAll("0","5","10","20","50");
    }
    
    
    @FXML
    private void setOrderPrice(ActionEvent actionEvent){
        try{
            
            int harga=Integer.parseInt(txtharga.getText());
            int jumlah=Integer.parseInt(txtJumlah.getText());
            int subjumlah=harga * jumlah;
        
            lblSubTotal.setText(""+subjumlah);
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    @FXML
    private void btnAddOrder(ActionEvent actionEvent){
        try {
             tblCode.setCellValueFactory(new PropertyValueFactory<PesanTableModel,String>("pizza_Id"));
            tblPizza_Nama.setCellValueFactory(new PropertyValueFactory<PesanTableModel,String>("pizza_Nama"));
            tblHarga.setCellValueFactory(new PropertyValueFactory<PesanTableModel,Integer>("harga"));
            tblJumlah.setCellValueFactory(new PropertyValueFactory<PesanTableModel,Integer>("jumlah"));
            tblSubTotal.setCellValueFactory(new PropertyValueFactory<PesanTableModel,Integer>("SubJumlah"));
        
            tblPesan.setItems(data);
        //
            PesanTableModel otm= new PesanTableModel();
            otm.setPizza_Id(txtpizza_Id.getText());
            otm.setPizza_Nama(txtpizza_Nama.getText());
            otm.setHarga(Integer.parseInt(txtharga.getText()));
            otm.setJumlah(Integer.parseInt(txtJumlah.getText()));
            otm.setSubJumlah(Integer.parseInt(lblSubTotal.getText()));
            data.add(otm);

            //Order Details to Array List

            String order_Id=txtOID.getText();
            String itemCode=txtpizza_Id.getText();
            int qty= Integer.parseInt(txtJumlah.getText());
            int unitPrice= Integer.parseInt(txtharga.getText());

            PesanDetail od=new PesanDetail(order_Id,itemCode,qty,unitPrice);
            orderDetailList.add(od);
            
            subjumlah=Integer.parseInt(lblSubTotal.getText());
            total+=subjumlah;
            lblTotal.setText(""+total);
            
            txtpizza_Id.setText(null);
            txtpizza_Nama.setText(null);
            txtharga.setText(null);
            txtJumlah.setText(null);
            lblSubTotal.setText(null);

            btnCustomized.setDisable(false);

            txtpizza_Id.requestFocus();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void btntambah(ActionEvent event) {
        try {
            String order_Id=txtOID.getText();
            LocalDate date =txtODate.getValue();
            String order_Date=date.format(DateTimeFormatter.ISO_DATE);
            String customer_Id=txtcustomer_Id.getText();
            
            Pesan order=new Pesan(order_Id,customer_Id,order_Date,orderDetailList);                
            boolean isAdded = PesanController.addNewOrder(order);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                alert.setTitle("Tambah Pesan");
                alert.setHeaderText("Ini adalah informasi");
                alert.setContentText("Berhasil Menambah Pesanan!!");
                alert.showAndWait();
                tblPesan.refresh();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Tambah Pesan");
                alert.setHeaderText("Ini adalah informasi");
                alert.setContentText("Tidak Berhasil Menambah Pesanan");
                alert.showAndWait();
                tblPesan.getItems().clear();
                tblPesan.refresh();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PizzaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnRemoveItem(ActionEvent actionEvent){
        
        int removeIndex=tblPesan.getSelectionModel().getSelectedIndex();
        tblPesan.getItems().remove(removeIndex);
        int remove_UnitPrice =orderDetailList.get(removeIndex).getItem_UnitPrice();
        int remove_Qty=orderDetailList.get(removeIndex).getItem_Qty();
        int remove_Amount=remove_Qty*remove_UnitPrice;
        total-=remove_Amount;
        orderDetailList.remove(removeIndex);
        if ((total >0)) {
            lblTotal.setText(String.valueOf(total));
        } else {
            lblTotal.setText(String.valueOf(0));

        }

    }

    @FXML
    private void idGenerator(){
        try {
            txtOID.setText(lain.IDGenarator.getNewID("pesan","pesan_id","O"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void idGeneratorCustomer(){
        try {
            txtcustomer_Id.setText(lain.IDGenarator.getNewID("customer","customer_id","C"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
