/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.pojo;

/**
 *
 * @author dell
 */
public class MuonSach {
    private int idMuon;
    private String tenSachMuon;
    private String NgayMuon;

    public MuonSach(int aInt, String ts, String nm) {
        this.idMuon = aInt;
        this.tenSachMuon = ts;
        this.NgayMuon = nm;
    }

    /**
     * @return the id
     */
    public int getIdMuon() {
        return idMuon;
    }

    /**
     * @param id the id to set
     */
    public void setIdMuon(int id) {
        this.idMuon = id;
    }

    /**
     * @return the tenSach
     */
    public String getTenSachMuon() {
        return tenSachMuon;
    }

    /**
     * @param tenSach the tenSach to set
     */
    public void setTenSachMuon(String tenSach) {
        this.tenSachMuon = tenSach;
    }

    /**
     * @return the NgayMuon
     */
    public String getNgayMuon() {
        return NgayMuon;
    }

    /**
     * @param NgayMuon the NgayMuon to set
     */
    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }
    
}
