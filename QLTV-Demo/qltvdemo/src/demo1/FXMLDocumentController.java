/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo1;

import com.ltp.Services.DocGiaServices;
import com.ltp.Services.SachServices;
import static com.ltp.Services.SachServices.getInfoSach;
import com.ltp.pojo.DocGia;
import com.ltp.pojo.Sach;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Le Tran Phu
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML private TextField txtId;
    @FXML private TextField txtTen;
    @FXML private TextField txtGT;
    @FXML private TextField txtNS;
    @FXML private TextField txtDT;
    @FXML private TextField txtBP;
    @FXML private TextField txtHT;
    @FXML private TextField txtHT2;
    @FXML private TextField txtEMAIL;
    @FXML private TextField txtSDT;
    @FXML private TextField txtDIACHI;  
    @FXML private TextField txtKeyTenSach;
    @FXML private TextField txtTenTacGia;
    @FXML private TextField txtTenDanhMuc;
    @FXML private TextField txtNamXuatBan;
    @FXML private TableView<Sach> tbSach;
    @FXML private TableColumn tcTenSach;
    @FXML private TableColumn tcTenTacGia;
    @FXML private TableColumn tcDanhMuc;
    @FXML private TableColumn tcNam;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, NumberFormatException {
        try{
        DocGia d = new DocGia(parseInt(txtId.getText()),txtTen.getText(),txtGT.getText(),txtNS.getText(),
        txtDT.getText(),txtBP.getText(),txtHT.getText(),txtHT2.getText(),
                txtEMAIL.getText(),parseInt(txtSDT.getText()),txtDIACHI.getText());
        DocGiaServices.add(d);
            System.out.println("Thành Công");
        }catch(SQLException| NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void RefreshHandler(ActionEvent event)
    {
        txtId.setText("");
        txtTen.setText("");
        txtGT.setText("");
        txtNS.setText("");
        txtDT.setText("");
        txtBP.setText("");
        txtHT.setText("");
        txtHT2.setText("");
        txtEMAIL.setText("");
        txtSDT.setText("");
        txtDIACHI.setText("");
    }
    @FXML 
    private void TimDocGiaHandler(ActionEvent evt) throws SQLException
    {
        String tim = txtId.getText();
        DocGia d = DocGiaServices.getInfoDocGia(tim);
        txtTen.setText(d.getName());
        txtGT.setText(d.getGioiTinh());
        txtNS.setText(d.getNgaySinh());
        txtDT.setText(d.getDoiTuong());
        txtBP.setText(d.getBoPhan());
        txtHT.setText(d.getHanThe());
        txtHT2.setText(d.getHanThe2());
        txtEMAIL.setText(d.getEmail());
        txtSDT.setText(Integer.toString(d.getSdt()));
        txtDIACHI.setText(d.getDiaChi());
    }
        private final ObservableList<Sach> dataList = FXCollections.observableArrayList();
    @FXML
    private void loadSachFilterHandler()
    {
        FilteredList<Sach> filteredData = new FilteredList<>(dataList, p -> true);

        
        txtKeyTenSach.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Sach -> {
 
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }


                String lowerCaseFilter = newValue.toLowerCase();

                if (Sach.getTenSach().toLowerCase().contains(lowerCaseFilter)) {
                    return true;


                } else if (Sach.getTacGia().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if(Sach.getDanhMuc().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                } else if(String.valueOf(Sach.getNamXB()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }

                return false; 
            });
        });

     
        SortedList<Sach> sortedData = new SortedList<>(filteredData);

       
        sortedData.comparatorProperty().bind(tbSach.comparatorProperty());
     
        tbSach.setItems(sortedData);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tcTenSach.setCellValueFactory(new PropertyValueFactory<>("tenSach"));
            tcTenTacGia.setCellValueFactory(new PropertyValueFactory<>("tacGia"));
            tcDanhMuc.setCellValueFactory(new PropertyValueFactory<>("danhMuc"));
            tcNam.setCellValueFactory(new PropertyValueFactory<>("namXB"));
            dataList.addAll(getInfoSach());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadSachFilterHandler();
    }    
    
}
