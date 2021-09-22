/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edusys_entity;

import java.util.Date;

/**
 *
 * @author top1z
 */
public class NguoiHoc {

    private String maNguoihoc;
    private String maNV;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String sdt;
    private String email;
    private String ghiChu;
    private Date ngayDK;

    public NguoiHoc() {

    }

    public NguoiHoc(String maNguoihoc, String maNV, String hoTen, Date ngaySinh, boolean gioiTinh,
            String sdt, String email, String ghiChu, Date ngayDK) {
        this.maNguoihoc = maNguoihoc;
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.ghiChu = ghiChu;
        this.ngayDK = ngayDK;
    }

    public String getMaNguoihoc() {
        return maNguoihoc;
    }

    public void setMaNguoihoc(String maNguoihoc) {
        this.maNguoihoc = maNguoihoc;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    
}
