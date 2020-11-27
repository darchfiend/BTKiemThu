/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo1;

import com.ltp.Services.DocGiaServices;
import com.ltp.Services.MuonSachServices;
import static com.ltp.Services.MuonSachServices.getInfoMuonSach;
import static com.ltp.Services.SachServices.getInfoSach;
import com.ltp.pojo.DocGia;
import com.ltp.pojo.MuonSach;
import com.ltp.pojo.Sach;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Le Tran Phu
 */

public class FXMLDocumentController implements Initializable {
    

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
    @FXML private TableView<Sach> tbSach;
    @FXML private TableColumn tcTenSach;
    @FXML private TableColumn tcTenTacGia;
    @FXML private TableColumn tcDanhMuc;
    @FXML private TableColumn tcNam;
    @FXML private TableView<MuonSach> tbMuon;
    @FXML private TableColumn tcIdMuon;
    @FXML private TableColumn tcSachMuon;
    @FXML private TableColumn tcNgayMuon;
    
    
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
        //
        tcIdMuon.setCellValueFactory(new PropertyValueFactory<>("idMuon"));
        tcSachMuon.setCellValueFactory(new PropertyValueFactory<>("tenSachMuon"));
        tcNgayMuon.setCellValueFactory(new PropertyValueFactory<>("NgayMuon"));
        ObservableList<MuonSach> dataListMuon = FXCollections.observableArrayList();
        dataListMuon.addAll(getInfoMuonSach(tim));
        tbMuon.setItems(dataListMuon);
    }
        private final ObservableList<Sach> dataList = FXCollections.observableArrayList();
    @FXML
    private void loadSachFilterHandler()
    {
        //tạo filteredList cho Sach
        FilteredList<Sach> filteredData = new FilteredList<>(dataList, p -> true);

        //Sự kiện change listener được gọi khi có sự thay đổi giá trị
        txtKeyTenSach.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Sach -> {
                //khi giá trị mới nhập vào bằng rỗng(chưa nhập) thì xuất ra tableview tất cả giá trị trong bảng
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                //chuyển giá trị mới nhập vào thành lowercase
                String lowerCaseFilter = newValue.toLowerCase();
                //so sánh giá trị nhập vào và giá trị trong bảng
                if (Sach.getTenSach().toLowerCase().contains(lowerCaseFilter)) {
                    return true;//Trùng nhau


                } else if (Sach.getTacGia().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if(Sach.getDanhMuc().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                } else if(String.valueOf(Sach.getNamXB()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }

                return false; //không trùng
            });
        });

        //bỏ filterted vào sortedList
        SortedList<Sach> sortedData = new SortedList<>(filteredData);

        //bind comparator của sortedList với comparator của TableView
        sortedData.comparatorProperty().bind(tbSach.comparatorProperty());
        //Thêm sorted và filtered data vào TableView
        tbSach.setItems(sortedData);

    }
    @FXML private void muonSachHandler(ActionEvent evt) throws SQLException, ParseException
    {
        int sachDaMuon = tbMuon.getItems().size();
        Date hanThe = new SimpleDateFormat("yyy-MM-dd").parse(txtHT2.getText());
        String ngayMuon = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Date dateMuon = new SimpleDateFormat("yyy-MM-dd").parse(ngayMuon);
        //dateMuon = ngày hiện tại
        if(sachDaMuon < 5 && hanThe.compareTo(dateMuon) >= 0){
        //them vao database

            Sach s = tbSach.getSelectionModel().getSelectedItem();
            String ts = s.getTenSach();

            MuonSach m = new MuonSach(parseInt(txtId.getText()),ts,ngayMuon);
            MuonSachServices.addMuon(m);
            //update table
            ObservableList<MuonSach> dataListMuon = FXCollections.observableArrayList();
            dataListMuon.addAll(getInfoMuonSach(txtId.getText()));
            tbMuon.setItems(dataListMuon);
        }
        else
        {
            if(sachDaMuon >= 5)
                JOptionPane.showMessageDialog(null, "Không được mượn nhiều hơn 5 cuốn");
            if(hanThe.compareTo(dateMuon) < 0)
                JOptionPane.showMessageDialog(null, "Thẻ thư viện đã hết hạn");
        }
    }
    @FXML private void traSachHandler(ActionEvent evt) throws ParseException, SQLException
    {
        ObservableList<MuonSach> dataListMuon = FXCollections.observableArrayList();
        dataListMuon.addAll(getInfoMuonSach(txtId.getText()));
        String ngayMuon = dataListMuon.get(0).getNgayMuon();
        //
        Date hanThe = new SimpleDateFormat("yyy-MM-dd").parse(txtHT2.getText());
        Date dateMuon = new SimpleDateFormat("yyy-MM-dd").parse(ngayMuon);
        long soNgayKhac = dateMuon.getTime() - hanThe.getTime();
        TimeUnit.DAYS.convert(soNgayKhac, TimeUnit.MILLISECONDS);
        long phat = soNgayKhac*5000;
        if(hanThe.compareTo(dateMuon) < 0)
            JOptionPane.showMessageDialog(null, "Đã trễ "+ soNgayKhac + "ngày Phải trả phạt " +phat+ "Đ");
        else
            JOptionPane.showMessageDialog(null, "Trả đúng ngày");
        MuonSachServices.xoaMuon(parseInt(txtId.getText()));
        //refresh lai table
        ObservableList<MuonSach> dataList = FXCollections.observableArrayList();
        dataList.addAll(getInfoMuonSach(txtId.getText()));
        tbMuon.setItems(dataList);
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
            System.out.println(ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        loadSachFilterHandler();
    }    
    
}
