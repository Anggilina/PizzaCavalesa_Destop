/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcontroller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import koneksi.Koneksi2;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MenuTerlakuController implements Initializable {

    @FXML
    private AnchorPane rootTopMovingItem;
    
    @FXML
    private JFXButton btnMainMenu;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private Label lblItemDetails;
    
    @FXML
    private PieChart pchaPizza;

    @FXML
    private JFXDatePicker txtODate;

    private String date;

    ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList() ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            chartPizza();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pchaPizza.setData(pieChartData);
    }  
    
    public void chartPizza() throws SQLException, ClassNotFoundException {
        pieChartData.clear();

        String  SQL="select p.pizza_nama, count(pesan_id) as no_of_order\n" +
                "from pizza p ,pesandetail pd\n" +
                "where p.pizza_id=pd.pizza_id\n" +
                "group by p.pizza_id \n" +
                "order by 2 desc limit 10;"; 
        try {
            Connection c = Koneksi2.getDBConnection().getConnection();
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while(rs.next()){
                //adding data on piechart data
                pieChartData.add(new PieChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }

        pchaPizza.setData(pieChartData);
        
    }
    
    @FXML
    private void btnLogOut(ActionEvent actionEvent){
        try {
            AnchorPane loginForm = FXMLLoader.load(getClass().getResource(("/view/Masuk.fxml")));
            rootTopMovingItem.getChildren().setAll(loginForm);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void btnMainMenu(ActionEvent actionEvent){
        try {
            AnchorPane fxml = FXMLLoader.load(getClass().getResource(("/view/BerandaAdmin.fxml")));
            rootTopMovingItem.getChildren().setAll(fxml);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void itemDetailsEvent(MouseEvent event) {
        pchaPizza.getData().stream()
                .forEach(data -> {data.getNode().addEventHandler(MouseEvent.ANY,event1 -> {
                    lblItemDetails
                            .setText(
                                    data.getName()+" ("+
                                            (int)data.getPieValue()+")"+"\nPresentage : "+
                                            Double.parseDouble(String.valueOf(((
                                                    data.getPieValue()/100)*360)))+"%");
                });
        });
    }


    @FXML
    private void chartChanging(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        date= String.valueOf(txtODate.getValue());
        String SQL2="select p.pizza_nama, count(pd.pesan_id) as no_of_order\n" +
                "from pizza p ,pesandetail pd,pesan o\n" +
                "where p.pizza_id=pd.pizza_id && o.tanggal='"+date+"'\n" +
                "group by p.pizza_id\n" +
                "order by 2 desc limit 10;";
        pieChartData.clear();
        try {
            Connection c = Koneksi2.getDBConnection().getConnection();
            ResultSet rs = c.createStatement().executeQuery(SQL2);
            while(rs.next()){
                pieChartData.add(new PieChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }catch (SQLException|ClassNotFoundException e){
            System.out.println(e);
        }

        pchaPizza.setData(pieChartData);
    }
    
}
