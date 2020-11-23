/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltp.pojo;

/**
 *
 * @author Le Tran Phu
 */
public class DocGia {
    private int id;
    private String name;
    private String gioiTinh;
    private String ngaySinh;
    private String doiTuong;
    private String boPhan;
    private String hanThe;
    private String hanThe2;
    private String email;
    private int  sdt;
    private String diaChi;

    public DocGia(int id, String name, String gioiTinh, String ngaySinh, String doiTuong, String boPhan, String hanThe, String hanThe2, String email, int sdt, String diaChi) {
        this.id = id;
        this.name = name;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.doiTuong = doiTuong;
        this.boPhan = boPhan;
        this.hanThe = hanThe;
        this.hanThe2 = hanThe2;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    
    /**
     * @return the id
     */
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the ngaySinh
     */
    public String getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the doiTuong
     */
    public String getDoiTuong() {
        return doiTuong;
    }

    /**
     * @param doiTuong the doiTuong to set
     */
    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    /**
     * @return the boPhan
     */
    public String getBoPhan() {
        return boPhan;
    }

    /**
     * @param boPhan the boPhan to set
     */
    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }

    /**
     * @return the hanThe
     */
    public String getHanThe() {
        return hanThe;
    }

    /**
     * @param hanThe the hanThe to set
     */
    public void setHanThe(String hanThe) {
        this.hanThe = hanThe;
    }

    /**
     * @return the hanThe2
     */
    public String getHanThe2() {
        return hanThe2;
    }

    /**
     * @param hanThe2 the hanThe2 to set
     */
    public void setHanThe2(String hanThe2) {
        this.hanThe2 = hanThe2;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sdt
     */
    public int getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
}
