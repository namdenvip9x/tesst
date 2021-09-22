/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edusys_entity;

/**
 *
 * @author top1z
 */
public class NhanVien {
    private String maNV;
    private String matKhau;
    private String hovaTen;
    private boolean vaiTro;
    
    public NhanVien(){
        
    }

    public NhanVien(String maNV, String matKhau, String hovaTen, boolean vaiTro) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.hovaTen = hovaTen;
        this.vaiTro = vaiTro;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHovaTen() {
        return hovaTen;
    }

    public void setHovaTen(String hovaTen) {
        this.hovaTen = hovaTen;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }
    
}
