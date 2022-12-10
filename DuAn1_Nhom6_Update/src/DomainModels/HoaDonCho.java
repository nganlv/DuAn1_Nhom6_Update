/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author levan
 */
public class HoaDonCho {
    private int maHd;
    private String  ngayTao, tenNv, tenKh;

    public HoaDonCho() {
    }

    public HoaDonCho(int maHd, String ngayTao, String tenNv, String tenKh) {
        this.maHd = maHd;
        this.ngayTao = ngayTao;
        this.tenNv = tenNv;
        this.tenKh = tenKh;
    }

    public int getMaHd() {
        return maHd;
    }

    public void setMaHd(int maHd) {
        this.maHd = maHd;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

   
    

   
    
}
