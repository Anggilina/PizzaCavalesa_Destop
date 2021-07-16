package viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.AdminController;
import model.AdminTableModel;
import model2.Admin;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;


public class KelolaDataPenggunaController implements Initializable {

    @FXML
    private AnchorPane rootUser;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtTpNo;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXComboBox cbxType;

    @FXML
    private TableView tblUser;

    @FXML
    private TableColumn tblUserName;

    @FXML
    private TableColumn tblUserPassword;

    @FXML
    private TableColumn tblUserType;

    @FXML
    private TableColumn tblUserEmail;

    @FXML
    private JFXButton addUser;
    @FXML
    private JFXButton deleteUser;
    @FXML
    private JFXButton searchUser;
    @FXML
    private JFXButton refreshtbl;

    private final ObservableList<AdminTableModel> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxType();
        try {
            tblUserName.setCellValueFactory(new PropertyValueFactory<AdminTableModel, String>("user_Name"));
            tblUserPassword.setCellValueFactory(new PropertyValueFactory<AdminTableModel, String>("user_Password"));
            tblUserEmail.setCellValueFactory(new PropertyValueFactory<AdminTableModel, String>("user_Email"));
            tblUserType.setCellValueFactory(new PropertyValueFactory<AdminTableModel, String>("user_Type"));

            tblUser.setItems(data);
            ArrayList<Admin> users = null;
            users = AdminController.getAllUsers();
            for (Admin user : users) {
                AdminTableModel ctm = new AdminTableModel();
                ctm.setUser_Name(user.getUser_Name());
                ctm.setUser_Password(user.getUser_Password());
                ctm.setUser_Type(user.getUser_Type());
                ctm.setUser_Email(user.getUser_Email());
                data.add(ctm);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addUser(ActionEvent event) {
        try {
            String User_Name = txtUserName.getText();
            String User_Password = txtPassword.getText();
            String email = txtEmail.getText();
            String user_Type = (String) cbxType.getValue();

            Admin a = new Admin(User_Name, User_Password, email, user_Type);
            int i = AdminController.addUser(a);
            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Tambah Pengguna");
                alert.setHeaderText("Informasi");
                alert.setContentText("Penngguna Berhasil Ditambah!!");
                alert.showAndWait();
                tblUser.getItems().clear();
                tblUser.refresh();
                refreshtbl();

                txtUserName.setText(null);
                txtPassword.setText(null);
                txtEmail.setText(null);
                cbxType.setValue(null);

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Tambah pengguna");
                alert.setHeaderText("Salah");
                alert.setContentText("Username sudah digunakan");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        try {
            String user_Name = txtUserName.getText();
            int deleteItem = AdminController.deleteUser(user_Name);
            if (deleteItem > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Hapus Pengguna");
                alert.setHeaderText("Infomasi");
                alert.setContentText("Pengguna Berhasil Dihapus");
                alert.showAndWait();
                tblUser.refresh();
                refreshtbl();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Hapus Pengguna");
                alert.setHeaderText("Infomasi");
                alert.setContentText("Pengguna Tidak Berhasil Dihapus");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchUser(ActionEvent event) {
        try {
            String user_Name = txtUserName.getText();
            Admin c = AdminController.searchUser(user_Name);
            if (c != null) {
                txtUserName.setText(c.getUser_Name());
                txtPassword.setText(c.getUser_Password());
                txtEmail.setText(c.getUser_Email());
                cbxType.setValue(c.getUser_Type());

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/view/DialogStyle.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                //
                alert.setTitle("Cari Pengguna");
                alert.setHeaderText("Informasi");
                alert.setContentText("Pengguna Tidak Ditemunakan");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void comboBoxType() {
        cbxType.getItems().addAll("admin", "kasir");
    }

    @FXML
    private void refreshtbl() {
        try {
            tblUserName.setCellValueFactory(new PropertyValueFactory<AdminTableModel, String>("user_Name"));
            tblUserPassword.setCellValueFactory(new PropertyValueFactory<AdminTableModel, String>("user_Password"));
            tblUserEmail.setCellValueFactory(new PropertyValueFactory<AdminTableModel, String>("user_Email"));
            tblUserType.setCellValueFactory(new PropertyValueFactory<AdminTableModel, String>("user_Type"));

            tblUser.setItems(data);
            ArrayList<Admin> users = null;
            users = AdminController.getAllUsers();
            for (Admin user : users) {
                AdminTableModel ctm = new AdminTableModel();
                ctm.setUser_Name(user.getUser_Name());
                ctm.setUser_Password(user.getUser_Password());
                ctm.setUser_Type(user.getUser_Type());
                ctm.setUser_Email(user.getUser_Email());
                data.add(ctm);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnMainMenu(ActionEvent actionEvent) {
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/BerandaAdmin.fxml")));
            rootUser.getChildren().setAll(fxml);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent) {
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/Masuk.fxml")));
            rootUser.getChildren().setAll(loginForm);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
