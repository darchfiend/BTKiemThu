/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.Services;

import com.ltp.pojo.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class SachServices {
     public static List<Sach> getInfoSach() throws SQLException, NumberFormatException
    {
        String sql = "SELECT * FROM sach";
        Connection conn = Utils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        rs.first();
        List<Sach> Sachs = new ArrayList<>();
        while(rs.next())
        {
        Sach d = new Sach(rs.getString("TenSach"),rs.getString("TacGia"),
                rs.getString("DanhMuc"),rs.getInt("NamXuatBan"));
        Sachs.add(d);
        }
        return Sachs;
    }
     
}
