/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.Services;

import com.ltp.pojo.DocGia;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Le Tran Phu
 */
public class DocGiaServices {
    public static void add(DocGia d) throws SQLException, NumberFormatException
    {
        Connection conn = Utils.getConn();
        String sql = "INSERT INTO docgia(id,name,gioitinh,ns,doituong"
                + ",bophan,hanthe,hanthe2,email,sdt,diachi) VALUES"
                + " (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, d.getId());
        stm.setString(2, d.getName());
        stm.setString(3, d.getGioiTinh());
        stm.setString(4, d.getNgaySinh());
        stm.setString(5, d.getDoiTuong());
        stm.setString(6, d.getBoPhan());
        stm.setString(7, d.getHanThe());
        stm.setString(8, d.getHanThe2());
        stm.setString(9, d.getEmail());
        stm.setInt(10, d.getSdt());
        stm.setString(11, d.getDiaChi());
        stm.executeUpdate();
        stm.close();
    }
    public static DocGia getInfoDocGia(String id) throws SQLException, NumberFormatException
    {
        String sql = "SELECT * FROM docgia WHERE id=?";
        Connection conn = Utils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, parseInt(id));
        ResultSet rs = stm.executeQuery();
        rs.first();
        DocGia d = new DocGia(rs.getInt("id"),rs.getString("name"),rs.getString("gioitinh"),
                rs.getString("ns"),rs.getString("doituong"),rs.getString("bophan"),rs.getString("hanthe"),rs.getString("hanthe2"),rs.getString("email"),rs.getInt("sdt"),rs.getString("diachi"));
        return d;
    }
}
