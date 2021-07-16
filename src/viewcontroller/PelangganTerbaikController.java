package viewcontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import koneksi.Koneksi2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class PelangganTerbaikController implements Initializable {

    @FXML
    private AnchorPane rootTopBuyingCustomers;

    @FXML
    private BarChart barChart;

    @FXML
    private JFXDatePicker txtODate;

    private String date;
    
    @FXML
    private JFXButton btnMainMenu;

    @FXML
    private JFXButton btnLogOut;

    ObservableList<BarChart.Series> barChartData= FXCollections.observableArrayList() ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            topCustomers();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        barChart.setData(barChartData);
    }

    public void topCustomers()throws ClassNotFoundException,SQLException{
        barChartData.clear();
        String SQL="select c.customer_nama,count(pesan_id) as no_of_orders\n" +
                "from pesan p,customer c\n" +
                "where p.customer_id=c.customer_id\n" +
                "group by c.customer_id\n" +
                "order by 2 desc limit 10;";

        try {
            Connection c = Koneksi2.getDBConnection().getConnection();
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while(rs.next()){
                BarChart.Series sr=new BarChart.Series<>();
                sr.getData().add(new XYChart.Data(rs.getString(1),rs.getInt(2)));
                sr.setName(rs.getString(1));
                barChartData.add(sr);
            }
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/Masuk.fxml")));
            rootTopBuyingCustomers.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/BerandaAdmin.fxml")));
            rootTopBuyingCustomers.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void setBarChart(ActionEvent actionEvent){
        date= String.valueOf(txtODate.getValue());
        String SQL2="select c.customer_nama,count(pesan_id) as no_of_orders\n" +
                " from pesan p,customer c \n" +
                "where p.customer_id=c.customer_id && p.tanggal='"+date+"'\n" +
                "group by c.customer_id\n" +
                "order by 2 desc limit 10;";
        try {
            barChartData.clear();
            Connection c = Koneksi2.getDBConnection().getConnection();
            ResultSet rs = c.createStatement().executeQuery(SQL2);
            while(rs.next()){
                BarChart.Series sr=new BarChart.Series<>();
                sr.getData().add(new XYChart.Data(rs.getString(1),rs.getInt(2)));
                sr.setName(rs.getString(1));
                barChartData.add(sr);
            }
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
