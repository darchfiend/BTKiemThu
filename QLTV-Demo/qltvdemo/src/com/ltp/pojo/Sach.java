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
public class Sach {
    private int id;
    private String tenSach;
    private String tacGia;
    private String moTa;
    private int namXB;
    private String noiXB;
    private String danhMuc;
    private String ngayNhapSach;
    private String viTri;



    public Sach(String ts, String tg, String dm, int nam)
    {
        this.tenSach = ts;
        this.tacGia = tg;
        this.danhMuc = dm;
        this.namXB = nam;
    }
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tenSach
     */
    public String getTenSach() {
        return tenSach;
    }

    /**
     * @param tenSach the tenSach to set
     */
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    /**
     * @return the tacGia
     */
    public String getTacGia() {
        return tacGia;
    }

    /**
     * @param tacGia the tacGia to set
     */
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return the namXB
     */
    public int getNamXB() {
        return namXB;
    }

    /**
     * @param namXB the namXB to set
     */
    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    /**
     * @return the noiXB
     */
    public String getNoiXB() {
        return noiXB;
    }

    /**
     * @param noiXB the noiXB to set
     */
    public void setNoiXB(String noiXB) {
        this.noiXB = noiXB;
    }

    /**
     * @return the danhMuc
     */
    public String getDanhMuc() {
        return danhMuc;
    }

    /**
     * @param danhMuc the danhMuc to set
     */
    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    /**
     * @return the ngayNhapSach
     */
    public String getNgayNhapSach() {
        return ngayNhapSach;
    }

    /**
     * @param ngayNhapSach the ngayNhapSach to set
     */
    public void setNgayNhapSach(String ngayNhapSach) {
        this.ngayNhapSach = ngayNhapSach;
    }

    /**
     * @return the viTri
     */
    public String getViTri() {
        return viTri;
    }

    /**
     * @param viTri the viTri to set
     */
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    
    
}
