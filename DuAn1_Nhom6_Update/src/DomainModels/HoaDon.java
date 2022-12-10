/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author levan
 */
public class HoaDon {
    private int maHd;
    private String ngayTao, ngayTT, maKh, tenKh, tenNv;
    private double donGia,tongTien, tienKhachDua, tienThua;
    private String hinhThucBh, hinhThucTT, tinhTrang, ghiChu;

    public HoaDon() {
    }

    public HoaDon(int maHd, String ngayTao, String ngayTT, String maKh, String tenKh, String tenNv, double donGia, double tongTien, double tienKhachDua, double tienThua, String hinhThucBh, String hinhThucTT, String tinhTrang, String ghiChu) {
        this.maHd = maHd;
        this.ngayTao = ngayTao;
        this.ngayTT = ngayTT;
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.tenNv = tenNv;
        this.donGia = donGia;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.hinhThucBh = hinhThucBh;
        this.hinhThucTT = hinhThucTT;
        this.tinhTrang = tinhTrang;
        this.ghiChu = ghiChu;
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

    public String getNgayTT() {
        return ngayTT;
    }

    public void setNgayTT(String ngayTT) {
        this.ngayTT = ngayTT;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public double getTienThua() {
        return tienThua;
    }

    public void setTienThua(double tienThua) {
        this.tienThua = tienThua;
    }

    public String getHinhThucBh() {
        return hinhThucBh;
    }

    public void setHinhThucBh(String hinhThucBh) {
        this.hinhThucBh = hinhThucBh;
    }

    public String getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(String hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    

    

    
    
}
